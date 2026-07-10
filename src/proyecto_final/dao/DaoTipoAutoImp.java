package proyecto_final.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyecto_final.dao.interfaces.DaoTipoAuto;
import proyecto_final.modelo.TipoAuto;
import proyecto_final.sql.ConexionDB;

public class DaoTipoAutoImp implements DaoTipoAuto{
    
    Connection con = ConexionDB.conectar();
    
    @Override
    public List<TipoAuto> listarTiposAutos() {
        List<TipoAuto> tipos = new ArrayList<>();
        String query = "select * from alq_tipos_autos order by 2";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                tipos.add(new TipoAuto(rs.getInt("tip_codigo"), rs.getString("tip_nombre")));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return tipos;        
    }

    @Override
    public int obtenerCodigo(String busqueda) {
        String query = "select tip_codigo from alq_tipos_autos where tip_nombre = ?";
        
        try {
            PreparedStatement ps = con.prepareCall(query);
            ps.setString(1, busqueda);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("tip_codigo");
            }
            
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public TipoAuto buscarPorCodigo(int busqueda) {
        String query = "select tip_codigo, tip_nombre from alq_tipos_autos where tip_codigo = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, busqueda);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TipoAuto tipoAuto = new TipoAuto(
                    rs.getInt("tip_codigo"),
                    rs.getString("tip_nombre")
                );
                rs.close();
                ps.close();
                return tipoAuto;
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