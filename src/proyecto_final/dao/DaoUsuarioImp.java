package proyecto_final.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyecto_final.dao.interfaces.DaoUsuario;
import proyecto_final.modelo.Empleado;
import proyecto_final.modelo.Usuario;
import proyecto_final.sql.ConexionDB;

public class DaoUsuarioImp implements DaoUsuario{

    @Override
    public Usuario buscarUsuarioPorUsername(String username) {
        String queryUsu = "select * from ALQ_USUARIOS where usu_username = ?";
        String queryEmp = "select * from ALQ_EMPLEADOS where emp_cedula = ?";
        Usuario usuEncontrado = null;

        try {
            Connection conexionBD = ConexionDB.conectar();
            PreparedStatement ps = conexionBD.prepareStatement(queryUsu);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nombreUsuario = rs.getString("usu_username");
                String contrasenia = rs.getString("usu_contrasenia");
                String cedulaEmpleado = rs.getString("emp_cedula");

                usuEncontrado = new Usuario(nombreUsuario, contrasenia);
                System.out.println("[ACCESO CORRECTO] " + usuEncontrado.mostrarEmpleado());
                
                PreparedStatement ps2 = conexionBD.prepareStatement(queryEmp);
                ps2.setString(1, cedulaEmpleado);
                ResultSet rs2 = ps2.executeQuery();

                if (rs2.next()) {
                    String cedula = rs2.getString("emp_cedula");
                    String nombre = rs2.getString("emp_nombre");
                    String apellido = rs2.getString("emp_apellido");
                    String direccion = rs2.getString("emp_direccion");
                    String telefono = rs2.getString("emp_telefono");
                    String correo = rs2.getString("emp_correo");
                    String tipoPersonal = rs2.getString("emp_tipo_personal");
                    String cargo = rs2.getString("emp_cargo");

                    Empleado empleado = new Empleado(cedula, nombre, apellido, direccion, telefono, correo, tipoPersonal, cargo);
                    usuEncontrado.setUsuEmpleado(empleado);
                    empleado.setEmpUsuario(usuEncontrado);
                }

                rs.close();
                rs2.close();
                ps.close();
                ps2.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al encontrar usuario: " + e.getMessage());
        }
        return usuEncontrado;
    }

    @Override
    public boolean crearUsuario(Usuario usuario) {
        String query = "insert into ALQ_USUARIOS values (?, ?, ?)";
        try {
            Connection conexionBD = ConexionDB.conectar();
            PreparedStatement ps = conexionBD.prepareStatement(query);
            
            ps.setString(1, usuario.getUsuUsername());
            ps.setString(2, usuario.getUsuPassword());
            ps.setString(3, usuario.getUsuEmpleado().getEmpCedula());
      
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
}