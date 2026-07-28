package proyecto_final.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyecto_final.sql.ConexionDB;

public class DaoDatosTablas {
    static private Connection con = ConexionDB.conectar();
    
    public static List<String> obtenerDatos(String tabla, String campo){
        List<String> objetos = new ArrayList<>();
        String query = "select " + campo + " as Campo from alq_" + tabla;
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                objetos.add(rs.getString("campo"));
            }
            
            rs.close();
            ps.close();
            return objetos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return objetos;
    }
}