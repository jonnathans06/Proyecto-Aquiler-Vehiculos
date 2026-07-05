package proyecto_final.dao;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import proyecto_final.modelo.Cliente;
import proyecto_final.sql.ConexionDB;
import proyecto_final.dao.interfaces.DaoCliente;

public class DaoClienteImp implements DaoCliente{    
    private Connection con = ConexionDB.conectar();

    @Override
    public boolean crearCliente(Cliente cliente) {
        String query = "insert into alq_clientes (cli_cedula, cli_nombre, cli_apellido, cli_direccion, cli_telefono, cli_correo, cli_estado) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getCliCedula());
            ps.setString(2, cliente.getCliNombre());
            ps.setString(3, cliente.getCliApellido());
            ps.setString(4, cliente.getCliDireccion());
            ps.setString(5, cliente.getCliTelefono());
            ps.setString(6, cliente.getCliCorreo());
            ps.setString(7, "ACTIVO");
            
            ps.executeQuery();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    @Override
    public Cliente buscarClientePorCedula(String busqueda) {
        String query = "select * from alq_clientes where cli_cedula = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, busqueda);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String cedula = rs.getString("cli_cedula");
                String nombre = rs.getString("cli_nombre");
                String apellido = rs.getString("cli_apellido");
                String direccion = rs.getString("cli_direccion");
                String telefono = rs.getString("cli_telefono");
                String correo = rs.getString("cli_correo");
                return new Cliente(cedula, nombre, apellido, direccion, telefono, correo);
            }
            
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Cliente> buscarClientes(String busqueda) {
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from alq_clientes where cli_cedula = ? or cli_nombre like ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, busqueda);
            ps.setString(2, "%" + busqueda + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String cedula = rs.getString("cli_cedula");
                String nombre = rs.getString("cli_nombre");
                String apellido = rs.getString("cli_apellido");
                String direccion = rs.getString("cli_direccion");
                String telefono = rs.getString("cli_telefono");
                String correo = rs.getString("cli_correo");
                clientes.add(new Cliente(cedula, nombre, apellido, direccion, telefono, correo));
            }
            
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clientes;
    }

    @Override
    public List<Cliente> listarTodods() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from alq_clientes";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String cedula = rs.getString("cli_cedula");
                String nombreEnc = rs.getString("cli_nombre");
                String apellido = rs.getString("cli_apellido");
                String direccion = rs.getString("cli_direccion");
                String telefono = rs.getString("cli_telefono");
                String correo = rs.getString("cli_correo");
                clientes.add(new Cliente(cedula, nombreEnc, apellido, direccion, telefono, correo));
            }
            
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clientes;
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}