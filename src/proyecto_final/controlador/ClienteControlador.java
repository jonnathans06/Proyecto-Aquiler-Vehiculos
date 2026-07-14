package proyecto_final.controlador;

import java.util.ArrayList;
import java.util.List;
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
    private Cliente cliAct;
    private List<Cliente> clientes;

    public ClienteControlador(CliCrearVista cliCrearVista, CliListarVista cliListarVista, CliActualizarVista cliActualizarVista, 
                             CliEliminarVista cliEliminarVista, DaoCliente daoCliente) {
        this.cliCrearVista = cliCrearVista;
        this.cliListarVista = cliListarVista;
        this.cliActualizarVista = cliActualizarVista;
        this.cliEliminarVista = cliEliminarVista;
        this.daoCliente = daoCliente;
        this.cliAct = null;
        this.clientes = new ArrayList<>();
        configurarAccionesBotones();
    }
    
    
    // Acciones botones
    private void configurarAccionesBotones(){
        // Crear Cliente
        cliCrearVista.getBtnRegistrar().addActionListener((e) -> {
            crearCliente();
        });
        
        // Listar todos los clientes
        cliListarVista.getBtnListar().addActionListener((e) -> {
            listarTodos();
        });
        
        //Buscar cliente
        cliListarVista.getBtnBuscar().addActionListener((e) -> {
            listarClientes();
        });
        
        //Buscar cliente actualizar
        cliActualizarVista.getBtnBuscar().addActionListener((e) -> {
            buscarClienteActualizar();
        });
        
        //Actualizar Cliente
        cliActualizarVista.getBtnActualizar().addActionListener((e) -> {
            actualizarCliente();
        });
        
        //Buscar empleado eliminar
        cliEliminarVista.getBtnBuscar().addActionListener((e) -> {
            buscarClienteEliminar();
        });

        //Eliminar Empleado
        cliEliminarVista.getBtnConfirmar().addActionListener((e) -> {
            eliminarCliente();
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
            inserto = daoCliente.crearCliente(new Cliente(cedula, nombre, apellido, direccion, telefono, correo, "ACTIVO"));
        }
        
        if (inserto) {
            cliCrearVista.mostrarMensaje("Cliente Registrado Exitosamente");
            cliCrearVista.limpiar();
        } else {
            cliCrearVista.mostrarMensaje("Error al Registrar Cliente");
        }
    }
    
    private void listarTodos(){
        cliListarVista.mostrarDatosCliente(daoCliente.listarTodods());
    }
    
    private void listarClientes(){
        clientes = daoCliente.buscarClientes(cliListarVista.getTxtBusqueda().getText().trim());
        if (clientes.isEmpty()) {
            cliListarVista.mostrarMensajes("Clientes no encontrados");
        } else {
            cliListarVista.mostrarDatosCliente(clientes);
            clientes.clear();
        }
    }
    
    private void buscarClienteActualizar(){
        cliAct = daoCliente.buscarClientePorCedula(cliActualizarVista.getTxtBusqueda().getText().trim());
        if (cliAct == null) {
            cliActualizarVista.mostrarMensaje("Clientes no encontrados");
        } else {
            cliActualizarVista.mostrarDatosCliente(cliAct);
            cliAct = null;
        }
    }
    
    private void actualizarCliente(){
        boolean actualizo = false;
        
        String cedula = cliActualizarVista.getTxtCedula().getText().trim();
        String nombre = cliActualizarVista.getTxtNombre().getText().trim();
        String apellido = cliActualizarVista.getTxtApellido().getText().trim();
        String direccion = cliActualizarVista.getTxtDireccion().getText().trim();
        String telefono = cliActualizarVista.getTxtTelefono().getText().trim();
        String correo = cliActualizarVista.getTxtCorreo().getText().trim();
        String estado = cliActualizarVista.getCbxEstado().getSelectedItem().toString();
        
        if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || correo.isEmpty() || estado.isEmpty()) {
            cliActualizarVista.mostrarMensaje("Todos los campos son obligatorios");
            return;
        } else if (!cedula.matches("\\d+") || cedula.length() != 10) {
            cliActualizarVista.mostrarMensaje("Número de cedula no valido");
            return;
        } else if (!telefono.matches("\\d+") || telefono.length() != 10) {
            cliActualizarVista.mostrarMensaje("Número de telefono no valido");
            return;
        } else {
            actualizo = daoCliente.actualizarCliente(new Cliente(cedula, nombre, apellido, direccion, telefono, correo, estado));
        }
        
        if (actualizo) {
            cliActualizarVista.mostrarMensaje("Cliente Actualizado Exitosamente");
            cliActualizarVista.limpiar();
            cliAct = null;
        } else {
            cliActualizarVista.mostrarMensaje("Error al Actualizar Cliente");
        }
    }
    
    private void buscarClienteEliminar(){
        cliAct = daoCliente.buscarClientePorCedula(cliEliminarVista.getTxtBusqueda().getText().trim());
        if (cliAct == null) {
            cliEliminarVista.mostrarMensaje("Clientes no encontrados");
            cliAct = null;
        } else {
            cliEliminarVista.mostrarDatosCliente(cliAct);
        }
    }
    
    private void eliminarCliente() {
        boolean elimino = daoCliente.eliminarCliente(cliAct);
        
        if (elimino) {
            cliEliminarVista.mostrarMensaje("Cliente Eliminado Exitosamente");
            cliEliminarVista.limpiar();
        } else {
            cliEliminarVista.mostrarMensaje("Error al Eliminar Empleado");
        }
    }
}