package proyecto_final.controlador;

import java.sql.*;
import proyecto_final.dao.interfaces.DaoUsuario;
import proyecto_final.modelo.Usuario;
import proyecto_final.vista.SistemaVista;
import proyecto_final.vista.login.LoginVista;

public class LoginControlador {
    private Usuario usuario;
    private DaoUsuario daoUsuario;
    private LoginVista loginVista;
    private SistemaVista principalVista;

    public LoginControlador(DaoUsuario daoUsuario, LoginVista loginVista, SistemaVista principalVista) {
        this.daoUsuario = daoUsuario;
        this.loginVista = loginVista;
        this.principalVista = principalVista;
        accionesBotones();
    }
    
    protected void accionesBotones(){
        // Login
        loginVista.getBtnLogin().addActionListener((e) -> {
            crearAcceso();
        });
        
        // Logout
        cerrarSesion();
    }
    
    private void crearAcceso(){
        try {
            usuario = daoUsuario.buscarUsuarioPorUsername(loginVista.getTxtUsername().getText());

            if (usuario == null) {
                loginVista.getLblErrores().setText("Usuario no encontrado");
                return;
            }

            if (loginVista.getTxtPassword().getText().equals(usuario.getUsuPassword())) {
                loginVista.getLblErrores().setText("Bienvenido: " + usuario.getUsuEmpleado().getEmpNombre());
                loginVista.dispose();
                loginVista.limpiar();
                principalVista.setVisible(true);
            } else {
                loginVista.getLblErrores().setText("Acceso incorrecto");
            }
        } catch (Exception e) {
            loginVista.getLblErrores().setText("Error al iniciar sesion");
            System.out.println(e.getMessage());
        }
    }
    
    public void cerrarSesion(){
        principalVista.getCerrarSesionMenuItem().addActionListener((e) -> {
            principalVista.dispose();
            loginVista.setVisible(true);
            usuario = null;
        });
    }
}