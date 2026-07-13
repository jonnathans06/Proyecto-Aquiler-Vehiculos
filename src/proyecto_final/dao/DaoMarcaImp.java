package proyecto_final.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyecto_final.dao.interfaces.DaoMarca;
import proyecto_final.modelo.Marca;
import proyecto_final.sql.ConexionDB;

public class DaoMarcaImp implements DaoMarca{
    Connection con = ConexionDB.conectar();
    
    @Override
    public List<Marca> listarMarcas() {
        List<Marca> marcas = new ArrayList<>();
        String query = "select * from alq_marcas";
        
        try {
            PreparedStatement ps = con.prepareCall(query);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                marcas.add(new Marca(rs.getInt("mar_codigo"), rs.getString("mar_nombre")));
            }
            
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return marcas;
    }

    @Override
    public Integer obtenerCodigo(String busqueda) {
        String query = "select mar_codigo from alq_marcas where mar_nombre = ?";
        
        try {
            PreparedStatement ps = con.prepareCall(query);
            ps.setString(1, busqueda);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("mar_codigo");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}