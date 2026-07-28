package proyecto_final.controlador;

import proyecto_final.dao.interfaces.DaoAuto;
import proyecto_final.dao.interfaces.DaoCliente;
import proyecto_final.modelo.Cliente;
import proyecto_final.vista.SistemaVista;
import proyecto_final.vista.clientes.CliCrearVista;
import proyecto_final.vista.reservas.ResCrearVista;

public class ReservaControlador {
    private SistemaVista sistemaVista;
    private CliCrearVista cliCrearVista;
    private ResCrearVista resCrearVista;
    private DaoCliente daoCliente;
    private DaoAuto daoAuto;

    public ReservaControlador(SistemaVista sistemaVista, CliCrearVista cliCrearVista, ResCrearVista resCrearVista, DaoCliente daoCliente, DaoAuto daoAuto) {
        this.sistemaVista = sistemaVista;
        this.cliCrearVista = cliCrearVista;
        this.resCrearVista = resCrearVista;
        this.daoCliente = daoCliente;
        this.daoAuto = daoAuto;
        accionesBotones();
    }
    
    
    
    private void accionesBotones(){
        // Buscar Cliente
        resCrearVista.getBtnBscCliente().addActionListener((e) -> {
            buscarClienteCrearReserva();
        });     
        
        // Registrar Cliente
        resCrearVista.getBtnAgrCliente().addActionListener((e) -> {
            agregarCliente();
        });
        
        // Buscar Auto
        cargarDatosAutoCrearReserva();
        
    }
    
    private void buscarClienteCrearReserva(){
        try {
            Cliente cli = daoCliente.buscarClientePorCedula(resCrearVista.getTxtBusqCliente().getText().trim());
            if (cli != null) {
                resCrearVista.getTxtNomCliente().setText(cli.getCliNombre());
                resCrearVista.getTxtApeCliente().setText(cli.getCliApellido());
            } else {
                resCrearVista.mostrarMensajes("Error al encontrar cliente");
            }
        } catch (NullPointerException nul) {
            System.out.println("Error");
        }
    }
    
    private void cargarDatosAutoCrearReserva(){
        resCrearVista.getCbxTipo().addActionListener((e) -> {
            String marca = resCrearVista.getCbxMarcas().getSelectedItem().toString();
            String modelo = resCrearVista.getCbxTipo().getSelectedItem().toString();
            
            resCrearVista.mostrarDatosAuto(daoAuto.buscarAutoReserva(marca, modelo));
        });
    }
    
    private void agregarCliente(){
        SistemaVista.addComponente(sistemaVista.getDesktopPane(), cliCrearVista);
    }
}