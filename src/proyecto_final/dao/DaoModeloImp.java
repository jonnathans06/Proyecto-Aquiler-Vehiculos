package proyecto_final.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyecto_final.dao.interfaces.DaoModelo;
import proyecto_final.modelo.Modelo;
import proyecto_final.sql.ConexionDB;

public class DaoModeloImp implements DaoModelo{
    private Connection con = ConexionDB.conectar();
    private List<Modelo> modelos = new ArrayList<>();
    
    @Override
    public List<Modelo> listarTodo() {
        modelos.clear();
        String query = "select * from alq_modelos";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                modelos.add(new Modelo(rs.getInt("mod_codigo"), rs.getString("mod_nombre"), rs.getInt("mar_codigo"), rs.getInt("tip_codigo"), rs.getInt("mod_capacidad"), rs.getDouble("mod_precio_dia"), rs.getString("mod_estado")));
            }
            
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelos;
    }
    
    @Override
    public List<Modelo> buscarModelosPorMarca(String busqueda) {
        modelos.clear();
        String query = "select m.mod_codigo, m.mod_nombre, m.mar_codigo, m.tip_codigo, m.mod_capacidad, m.mod_precio_dia, m.mod_estado "
                + "from alq_modelos m "
                + "join alq_marcas ma on m.mar_codigo = ma.mar_codigo "
                + "where ma.mar_nombre = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, busqueda);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                modelos.add(new Modelo(rs.getInt("mod_codigo"), rs.getString("mod_nombre"), rs.getInt("mar_codigo"), rs.getInt("tip_codigo"), rs.getInt("mod_capacidad"), rs.getDouble("mod_precio_dia"), rs.getString("mod_estado")));
            }
            
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelos;
    }   
    
    public List<Modelo> getModelos() {
        return modelos;
    }
    
    @Override
    public Modelo buscarModeloPorNombre(String busqueda) {
        String query = "select m.mod_codigo, m.mod_nombre, m.mar_codigo, m.tip_codigo, m.mod_capacidad, m.mod_precio_dia, m.mod_estado "
                + "from alq_modelos m "
                + "where m.mod_nombre = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, busqueda);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                return new Modelo(rs.getInt("mod_codigo"), rs.getString("mod_nombre"), rs.getInt("mar_codigo"), rs.getInt("tip_codigo"), rs.getInt("mod_capacidad"), rs.getDouble("mod_precio_dia"), rs.getString("mod_estado"));
            }
            
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}