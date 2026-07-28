package proyecto_final.controlador;

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

    public ReservaControlador(SistemaVista sistemaVista, CliCrearVista cliCrearVista, ResCrearVista resCrearVista, DaoCliente daoCliente) {
        this.sistemaVista = sistemaVista;
        this.cliCrearVista = cliCrearVista;
        this.resCrearVista = resCrearVista;
        this.daoCliente = daoCliente;
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
    
    private void agregarCliente(){
        SistemaVista.addComponente(sistemaVista.getDesktopPane(), cliCrearVista);
    }
}