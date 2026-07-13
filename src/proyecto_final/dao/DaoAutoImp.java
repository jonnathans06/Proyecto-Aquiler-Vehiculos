package proyecto_final.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyecto_final.dao.interfaces.DaoAuto;
import proyecto_final.modelo.Auto;
import proyecto_final.sql.ConexionDB;

public class DaoAutoImp implements DaoAuto{    
    Connection con = ConexionDB.conectar();
    List<Auto> autos = new ArrayList<>();
    
    @Override
    public boolean crearAuto(Auto auto) {
        String query = "insert into alq_autos values (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, auto.getAutMatricula());
            ps.setInt(2, auto.getAutAnio());
            ps.setString(3, auto.getAutEstado());
            ps.setInt(4, auto.getAutModelo());
            ps.setString(5, auto.getAutColor());
            ps.setInt(6, auto.getAutKilometraje());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Auto buscarAutoPorPlaca(String busqueda) {
        
        return null;
    }

    @Override
    public List<Auto> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarAuto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarAuto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}