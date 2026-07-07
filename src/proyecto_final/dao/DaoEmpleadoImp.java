package proyecto_final.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyecto_final.dao.interfaces.DaoEmpleado;
import proyecto_final.modelo.Empleado;
import proyecto_final.sql.ConexionDB;

public class DaoEmpleadoImp implements DaoEmpleado{   

    @Override
    public boolean crearEmpleado(Empleado empleado) {
        String query = "insert into ALQ_EMPLEADOS (emp_cedula, emp_nombre, emp_apellido, emp_direccion, emp_telefono, emp_correo, emp_tipo_personal, emp_cargo, emp_estado) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conexionBD = ConexionDB.conectar();
            PreparedStatement ps = conexionBD.prepareStatement(query);
            ps.setString(1, empleado.getEmpCedula());
            ps.setString(2, empleado.getEmpNombre());
            ps.setString(3, empleado.getEmpApellido());
            ps.setString(4, empleado.getEmpDireccion());
            ps.setString(5, empleado.getEmpTelefono());
            ps.setString(6, empleado.getEmpCorreo());
            ps.setString(7, empleado.getEmpTipoPersonal());
            ps.setString(8, empleado.getEmpCargo());
            ps.setString(9, "ACTIVO");  
      
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Empleado buscarEmpleadoPorCedula(String username) {
        String query = "select * from ALQ_EMPLEADOS where emp_cedula = ? and emp_estado = 'ACTIVO'";

        try {
            Connection conexionBD = ConexionDB.conectar();
            PreparedStatement ps = conexionBD.prepareStatement(query);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String cedula = rs.getString("emp_cedula");
                String nombres = rs.getString("emp_nombre");
                String apellidos = rs.getString("emp_apellido");
                String direccion = rs.getString("emp_direccion");
                String telefono = rs.getString("emp_telefono");
                String correo = rs.getString("emp_correo");
                String tipoPersonal = rs.getString("emp_tipo_personal");
                String cargo = rs.getString("emp_cargo");

                Empleado empleado = new Empleado(cedula, nombres, apellidos, direccion, telefono, correo, tipoPersonal, cargo);
                System.out.println(empleado);

                rs.close();
                ps.close();
                return empleado;
            }
        } catch (SQLException e) {
            System.out.println("Error al encontrar empleado: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public Empleado buscarEmpleadoPorNombre(String username) {
        String query = "select * from ALQ_EMPLEADOS where emp_nombre like ? and emp_estado = 'ACTIVO'";

        try {
            Connection conexionBD = ConexionDB.conectar();
            PreparedStatement ps = conexionBD.prepareStatement(query);
            ps.setString(1, "%" + username + "%");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String cedula = rs.getString("emp_cedula");
                String nombres = rs.getString("emp_nombre");
                String apellidos = rs.getString("emp_apellido");
                String direccion = rs.getString("emp_direccion");
                String telefono = rs.getString("emp_telefono");
                String correo = rs.getString("emp_correo");
                String tipoPersonal = rs.getString("emp_tipo_personal");
                String cargo = rs.getString("emp_cargo");

                Empleado empleado = new Empleado(cedula, nombres, apellidos, direccion, telefono, correo, tipoPersonal, cargo);
                System.out.println(empleado);

                rs.close();
                ps.close();
                return empleado;
            }
        } catch (SQLException e) {
            System.out.println("Error al encontrar empleado: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Empleado> buscarPorCoincidencia(String username) {
        List<Empleado> listaEmpleados = new ArrayList<>();
        String query = "select * from ALQ_EMPLEADOS where emp_cedula = ? or emp_nombre like ? and emp_estado = 'ACTIVO'";

        try {
            Connection conexionBD = ConexionDB.conectar();
            PreparedStatement ps = conexionBD.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, "%" + username + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cedula = rs.getString("emp_cedula");
                String nombres = rs.getString("emp_nombre");
                String apellidos = rs.getString("emp_apellido");
                String direccion = rs.getString("emp_direccion");
                String telefono = rs.getString("emp_telefono");
                String correo = rs.getString("emp_correo");
                String tipoPersonal = rs.getString("emp_tipo_personal");
                String cargo = rs.getString("emp_cargo");

                Empleado empleado = new Empleado(cedula, nombres, apellidos, direccion, telefono, correo, tipoPersonal, cargo);
                System.out.println(empleado);
                
                listaEmpleados.add(empleado);
            }
            return listaEmpleados;
        } catch (SQLException e) {
            System.out.println("Error al listar todos los empleado: " + e.getMessage());
        }

        return null;
    }
    
    @Override
    public List<Empleado> listarTodos() {
        List<Empleado> listaEmpleados = new ArrayList<>();
        String query = "select * from ALQ_EMPLEADOS where emp_estado = 'ACTIVO'order by 3 asc";

        try {
            Connection conexionBD = ConexionDB.conectar();
            PreparedStatement ps = conexionBD.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cedula = rs.getString("emp_cedula");
                String nombres = rs.getString("emp_nombre");
                String apellidos = rs.getString("emp_apellido");
                String direccion = rs.getString("emp_direccion");
                String telefono = rs.getString("emp_telefono");
                String correo = rs.getString("emp_correo");
                String tipoPersonal = rs.getString("emp_tipo_personal");
                String cargo = rs.getString("emp_cargo");

                Empleado empleado = new Empleado(cedula, nombres, apellidos, direccion, telefono, correo, tipoPersonal, cargo);
                listaEmpleados.add(empleado);
            }
            return listaEmpleados;
        } catch (SQLException e) {
            System.out.println("Error al listar todos los empleado: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean actualizarEmpleado(Empleado empleado) {
        String query = "update ALQ_EMPLEADOS set emp_nombre = ?, emp_apellido = ?, emp_direccion = ?, "
                     + "emp_telefono = ?, emp_correo = ?, emp_tipo_personal= ?, emp_cargo = ?"
                     + "where emp_cedula = ?";

        try {
            Connection conexionBD = ConexionDB.conectar();
            PreparedStatement ps = conexionBD.prepareStatement(query);
            
            ps.setString(1, empleado.getEmpNombre());
            ps.setString(2, empleado.getEmpApellido());
            ps.setString(3, empleado.getEmpDireccion());
            ps.setString(4, empleado.getEmpTelefono());
            ps.setString(5, empleado.getEmpCorreo());
            ps.setString(6, empleado.getEmpTipoPersonal());
            ps.setString(7, empleado.getEmpCargo());
            ps.setString(8, empleado.getEmpCedula());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("[Error al actualizar] " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean desactivarEmpleado(String empCedula) {
        String queryUsu = "delete from ALQ_USUARIOS where emp_cedula = ?";
        String queryEmp = "update ALQ_EMPLEADOS set emp_estado = ? where emp_cedula = ?";

        try {
            Connection conexionBD = ConexionDB.conectar();

            // Eliminar el usuario 
            PreparedStatement ps1 = conexionBD.prepareStatement(queryUsu);
            ps1.setString(1, empCedula);
            ps1.executeUpdate();
            ps1.close();
            
            PreparedStatement ps2 = conexionBD.prepareStatement(queryEmp);
            ps2.setString(1, "INACTIVO");
            ps2.setString(2, empCedula);
            ps2.executeUpdate();
            ps2.close();

            return true;
        } catch (SQLException e) {
            System.out.println("[Error al desactivar empleado] " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}