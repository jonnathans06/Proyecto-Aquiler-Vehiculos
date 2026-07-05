package proyecto_final.controlador;

import proyecto_final.vista.clientes.CliActualizarVista;
import proyecto_final.vista.clientes.CliCrearVista;
import proyecto_final.vista.clientes.CliEliminarVista;
import proyecto_final.vista.clientes.CliListarVista;
import proyecto_final.dao.interfaces.DaoCliente;
import proyecto_final.modelo.Cliente;

public class ClienteControlador {
    private CliCrearVista cliCrearVista;
    private CliListarVista cliListarVista;
    private CliActualizarVista cliActualizarVista;
    private CliEliminarVista cliEliminarVista;
    private DaoCliente daoCliente; 

    public ClienteControlador(CliCrearVista cliCrearVista, CliListarVista cliListarVista, CliActualizarVista cliActualizarVista, 
                             CliEliminarVista cliEliminarVista, DaoCliente daoCliente) {
        this.cliCrearVista = cliCrearVista;
        this.cliListarVista = cliListarVista;
        this.cliActualizarVista = cliActualizarVista;
        this.cliEliminarVista = cliEliminarVista;
        this.daoCliente = daoCliente;
        configurarAccionesBotones();
    }
    
    
    // Acciones botones
    private void configurarAccionesBotones(){
        // Crear Cliente
        cliCrearVista.getBtnRegistrar().addActionListener((e) -> {
            crearCliente();
        });
    }
    
    // Clientes
    private void crearCliente(){
        boolean inserto = false;
        
        String cedula = cliCrearVista.getTxtCedula().getText().trim();
        String nombre = cliCrearVista.getTxtNombre().getText().trim();
        String apellido = cliCrearVista.getTxtApellido().getText().trim();
        String direccion = cliCrearVista.getTxtDireccion().getText().trim();
        String telefono = cliCrearVista.getTxtTelefono().getText().trim();
        String correo = cliCrearVista.getTxtCorreo().getText().trim();
        
        if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
            cliCrearVista.mostrarMensaje("Todos los campos son obligatorios");
            return;
        } else if (!cedula.matches("\\d+") || cedula.length() != 10) {
            cliCrearVista.mostrarMensaje("Número de cedula no valido");
            return;
        } else if (!telefono.matches("\\d+") || telefono.length() != 10) {
            cliCrearVista.mostrarMensaje("Número de telefono no valido");
            return;
        } else {
            inserto = daoCliente.crearCliente(new Cliente(cedula, nombre, apellido, direccion, telefono, correo));
        }
        
        if (inserto) {
            cliCrearVista.mostrarMensaje("Cliente Registrado Exitosamente");
            cliCrearVista.limpiar();
        } else {
            cliCrearVista.mostrarMensaje("Error al Registrar Cliente");
        }
    }
}