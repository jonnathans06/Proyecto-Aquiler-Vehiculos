package proyecto_final.controlador;

import java.sql.*;
import proyecto_final.dao.interfaces.DaoEmpleado;
import proyecto_final.dao.interfaces.DaoUsuario;
import proyecto_final.modelo.Empleado;
import proyecto_final.modelo.Usuario;
import proyecto_final.vista.empleados.EmpActualizarVista;
import proyecto_final.vista.empleados.EmpCrearVista;
import proyecto_final.vista.empleados.EmpEliminarVista;
import proyecto_final.vista.empleados.EmpListarVista;
import proyecto_final.vista.empleados.EmpUsuarioVista;

public class EmpleadoControlador {
    private Empleado empleado;
    private Empleado empActual;
    private EmpCrearVista empCrearVista;
    private EmpListarVista empListarVista;
    private EmpActualizarVista empActVista;
    private EmpEliminarVista empEliVista;
    private EmpUsuarioVista empUsuVista;
    private DaoEmpleado daoEmpleado;
    private DaoUsuario daoUsuario; 

    public EmpleadoControlador(EmpCrearVista empCrearVista, EmpListarVista empListarVista, EmpActualizarVista empActVista, EmpEliminarVista empEliminarVista,
            EmpUsuarioVista empUsuVista, DaoEmpleado daoEmpleado, DaoUsuario daoUsuario) {
        this.empActual = null;
        this.empCrearVista = empCrearVista;
        this.empListarVista = empListarVista;
        this.empActVista = empActVista;
        this.empEliVista = empEliminarVista;
        this.empUsuVista = empUsuVista;
        this.daoEmpleado = daoEmpleado;
        this.daoUsuario = daoUsuario;
        accionesBotones();
    }
    
    private void accionesBotones() {
        // Crear Empleado
        empCrearVista.getBtnRegistrar().addActionListener((e) -> {
            crearEmpleado();
        });
        
        // Buscar Empleado
        empListarVista.getBtnBuscar().addActionListener((e) -> {
            buscarPorCoincidencia();
        });
        
        // Listar todos
        empListarVista.getBtnListar().addActionListener((e) -> {
            listarTodosEmpleados();
        });
        
        // Actualizar empleado
        empActVista.getBtnBuscar().addActionListener((e) -> {
            buscarEmpleadoActualizar();
        });
        empActVista.getBtnConfirmar().addActionListener((e) -> {
            actualizarEmpleado();
        });
        empActVista.getBtnLimpiar().addActionListener((e) -> {
            empActual = null;
        });
        empActVista.getBtnCancelar().addActionListener((e) -> {
            empActual = null;
        });
        
        // Eliminar Empleado
        empEliVista.getBtnBuscar().addActionListener((e) -> {
            buscarEmpleadoEliminar();
        });
        empEliVista.getBtnConfirmar().addActionListener((e) -> {
            eliminarEmpleado();
        });
        empEliVista.getBtnLimpiar().addActionListener((e) -> {
            empActual = null;
        });
        empEliVista.getBtnCancelar().addActionListener((e) -> {
            empActual = null;
        });
    }

    //Empleados
    private void crearEmpleado(){
        boolean inserto = false;
        try {
            String cedula = empCrearVista.getTxtCedula().getText().trim();
            String nombres = empCrearVista.getTxtNombre().getText().trim();
            String apellidos = empCrearVista.getTxtApellido().getText().trim();
            String direccion = empCrearVista.getTxtDireccion().getText().trim();
            String telefono = empCrearVista.getTxtTelefono().getText().trim();
            String correo = empCrearVista.getTxtCorreo().getText().trim();
            String tipoPersonal = empCrearVista.getCbxTipoPersonal().getSelectedItem().toString().toUpperCase().trim();
            String cargo = empCrearVista.getCbxCargo().getSelectedItem().toString().toUpperCase().trim();
            
            inserto = daoEmpleado.crearEmpleado(new Empleado(cedula, nombres, apellidos, direccion, telefono, correo, tipoPersonal, cargo));
                                   
            if (cedula.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
                empCrearVista.mostrarMensaje("Todos los campos son obligatorios");
            } else if (!cedula.matches("\\d+")) {
                empCrearVista.mostrarMensaje("Ingrese solo numeros en el campo cedula");
            } else if (telefono.length() != 10) {
                empCrearVista.mostrarMensaje("Se requiere 10 dígitos de teléfono");
            } else if (cedula.length() != 10) {
                empCrearVista.mostrarMensaje("Se requiere 10 dígitos de cedula");
            } else if (inserto) {
                empCrearVista.mostrarMensaje("Empleado Registrado Exitosamente");
                empCrearVista.limpiar();
            } else {
                empCrearVista.mostrarMensaje("Error Al Registrar Empleado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void crearUsuario(Empleado emp){
        boolean inserto = false;
        empCrearVista.setVisible(false);
        try {
            String username = empUsuVista.getTxtUsername().getText().trim();
            String contrasenia = empUsuVista.getTxtContrasenia().getText().trim();
            
            inserto = daoUsuario.crearUsuario(new Usuario(username, contrasenia, emp));
            
            if (inserto) {
                empUsuVista.mostrarMensaje("Crendenciales registradas correctamente");
                empUsuVista.limpiar();
                empUsuVista.dispose();
                empCrearVista.setVisible(true);
            } else {
                empUsuVista.mostrarMensaje("Error al crear credenciales");
            }
            
        } catch (Exception e) {
        }
    }
    
    private void buscarPorCoincidencia(){
        try {
            empListarVista.mostrarDatosEmpleado(daoEmpleado.buscarPorCoincidencia(empListarVista.getTxtBusqueda().getText()));
        } catch (NullPointerException nullEx) {
            empListarVista.mostrarMensajes("Error en la busqueda del empleado");
        }
    }
    
    private void buscarEmpleadoActualizar(){
            
        if (empActVista.getTxtBusqueda().getText().isEmpty()) {
            empActVista.mostrarMensaje("Debe completar el campo de busqueda");
            return;
        }

        if (empActual == null) {
            empActual = daoEmpleado.buscarEmpleadoPorCedula(empActVista.getTxtBusqueda().getText());
        }
        
        if (empActual == null) {
            Usuario usuTemp = daoUsuario.buscarUsuarioPorUsername(empActVista.getTxtBusqueda().getText());
            empActual = usuTemp.getUsuEmpleado();
        }
        
        if (empActual != null) {
            empActVista.cargarEmpleado(empActual);
        } else {
            empActVista.mostrarMensaje("Empleado no encontrado");
        }
    }
    
    private void buscarEmpleadoEliminar(){
            
        if (empEliVista.getTxtBusqueda().getText().isEmpty()) {
            empEliVista.mostrarMensaje("Debe completar el campo de busqueda");
            return;
        }

        if (empActual == null) {
            empActual = daoEmpleado.buscarEmpleadoPorCedula(empEliVista.getTxtBusqueda().getText());
        }
        
        if (empActual == null) {
            Usuario usuTemp = daoUsuario.buscarUsuarioPorUsername(empEliVista.getTxtBusqueda().getText());
            empActual = usuTemp.getUsuEmpleado();
        }
        
        if (empActual != null) {
            empEliVista.cargarEmpleado(empActual);
        } else {
            empEliVista.mostrarMensaje("Empleado no encontrado");
        }
    }
    
    private void listarTodosEmpleados(){
        try {
            empListarVista.mostrarDatosEmpleado(daoEmpleado.listarTodos());
        } catch (NullPointerException nullEx) {
        
        }
    }
    
    private void actualizarEmpleado() {
        boolean actualizo = false;
        try {
            String cedula = empActVista.getTxtCedula().getText().trim();
            String nombres = empActVista.getTxtNombre().getText().trim();
            String apellidos = empActVista.getTxtApellido().getText().trim();
            String direccion = empActVista.getTxtDireccion().getText().trim(); 
            String telefono = empActVista.getTxtTelefono().getText().trim();
            String correo = empActVista.getTxtCorreo().getText().trim();
            String tipoPersonal = empActVista.getCbxTipoPersonal().getSelectedItem().toString().toUpperCase().trim();
            String cargo = empActVista.getCbxCargo().getSelectedItem().toString().toUpperCase().trim();
            
            if (huboCambios(empActual)) {
                Empleado empleadoEditado = new Empleado(cedula, nombres, apellidos, direccion, telefono, correo, tipoPersonal, cargo);
                System.out.println(empActual);
                System.out.println(empleadoEditado);
                actualizo =  daoEmpleado.actualizarEmpleado(empleadoEditado);
            } else {
                empActVista.mostrarMensaje("No se detectaron modificaciones en los campos.");
            }
            
            if (actualizo) {
                empActVista.mostrarMensaje("Empleado Actualizado Exitosamente");
                empActVista.limpiar();
                empActual = null;
            }
        }
        catch (Exception e) {
            System.out.println("[ERROR al actualizar]: " + e.getMessage());
            empActVista.mostrarMensaje("Datos no validos");
        }
    }
    
    private void eliminarEmpleado(){
        boolean elimino = false;
        try {
            elimino = daoEmpleado.desactivarEmpleado(empActual.getEmpCedula());
            
            if (elimino) {
                empEliVista.mostrarMensaje("Empleado Eliminado Correctamente");
                empEliVista.limpiar();
                empActual = null;
            } else empEliVista.mostrarMensaje("Error al eliminar empleado");
            
        } catch (Exception e) {
            empEliVista.mostrarMensaje("Error al eliminar empleado");
            System.out.println("[Error al eliminar] ");
        }
    }
    
    private boolean huboCambios(Empleado empleadoOriginal) {
        boolean cambioCedula = !empActVista.getTxtCedula().getText().trim().equals(empleadoOriginal.getEmpCedula());
        boolean cambioNombres = !empActVista.getTxtNombre().getText().trim().equals(empleadoOriginal.getEmpNombre());
        boolean cambioApellidos = !empActVista.getTxtApellido().getText().trim().equals(empleadoOriginal.getEmpApellido());
        boolean cambioDireccion = !empActVista.getTxtDireccion().getText().trim().equals(empleadoOriginal.getEmpDireccion());
        boolean cambioTelefono = !empActVista.getTxtTelefono().getText().trim().equals(empleadoOriginal.getEmpTelefono());
        boolean cambioCorreo = !empActVista.getTxtCorreo().getText().trim().equals(empleadoOriginal.getEmpCorreo());
        boolean cambioTipoPersonal = !empActVista.getCbxTipoPersonal().getSelectedItem().toString().toUpperCase().trim().equals(empleadoOriginal.getEmpTipoPersonal());
        boolean cambioCargo = !empActVista.getCbxCargo().getSelectedItem().toString().toUpperCase().trim().equals(empleadoOriginal.getEmpCargo());

        return cambioCedula || cambioNombres || cambioApellidos || cambioDireccion || cambioTelefono || cambioCorreo || cambioTipoPersonal || cambioCargo;
    }
}