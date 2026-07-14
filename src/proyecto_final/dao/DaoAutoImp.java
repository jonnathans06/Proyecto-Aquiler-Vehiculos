package proyecto_final.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyecto_final.dao.interfaces.DaoAuto;
import proyecto_final.dto.AutoDTO;
import proyecto_final.modelo.Auto;
import proyecto_final.sql.ConexionDB;

public class DaoAutoImp implements DaoAuto{    
    Connection con = ConexionDB.conectar();
    List<AutoDTO> autos = new ArrayList<>();
    
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
    public AutoDTO buscarAutoPorPlaca(String busqueda) {
        autos.clear();
        String query = "select au.aut_matricula, ma.mar_nombre, mo.mod_nombre, ti.tip_nombre, au.aut_anio, mo.mod_capacidad, mo.mod_precio_dia, au.aut_color, au.aut_kilometraje, au.aut_estado "
                     + "from alq_autos au "
                     + "join alq_modelos mo on au.mod_codigo = mo.mod_codigo "
                     + "join alq_marcas ma on mo.mar_codigo = ma.mar_codigo "
                     + "join alq_tipos_autos ti on mo.tip_codigo = ti.tip_codigo "
                     + "where au.aut_matricula = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, busqueda);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new AutoDTO(
                    rs.getString("aut_matricula"),
                    rs.getString("mar_nombre"),
                    rs.getString("mod_nombre"),
                    rs.getString("tip_nombre"),
                    rs.getInt("aut_anio"),
                    rs.getInt("mod_capacidad"),
                    rs.getDouble("mod_precio_dia"),
                    rs.getString("aut_color"),
                    rs.getInt("aut_kilometraje"),
                    rs.getString("aut_estado")
                );
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

    @Override
    public List<AutoDTO> listarTodos() {
        autos.clear();
        String query = "select au.aut_matricula, ma.mar_nombre, mo.mod_nombre, ti.tip_nombre, au.aut_anio, mo.mod_capacidad, mo.mod_precio_dia, au.aut_color, au.aut_kilometraje, au.aut_estado "
                     + "from alq_autos au "
                     + "join alq_modelos mo on au.mod_codigo = mo.mod_codigo "
                     + "join alq_marcas ma on mo.mar_codigo = ma.mar_codigo "
                     + "join alq_tipos_autos ti on mo.tip_codigo = ti.tip_codigo";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                autos.add(new AutoDTO(
                    rs.getString("aut_matricula"),
                    rs.getString("mar_nombre"),
                    rs.getString("mod_nombre"),
                    rs.getString("tip_nombre"),
                    rs.getInt("aut_anio"),
                    rs.getInt("mod_capacidad"),
                    rs.getDouble("mod_precio_dia"),
                    rs.getString("aut_color"),
                    rs.getInt("aut_kilometraje"),
                    rs.getString("aut_estado")
                ));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return autos;
    }

    @Override
    public boolean actualizarAuto(Auto auto) {
        String query = "update alq_autos set aut_anio = ?, aut_color = ?, aut_kilometraje = ?, aut_estado = ? "
                     + "where aut_matricula = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, auto.getAutAnio());
            ps.setString(2, auto.getAutColor());
            ps.setInt(3, auto.getAutKilometraje());
            ps.setString(4, auto.getAutEstado());
            ps.setString(5, auto.getAutMatricula());

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
    public boolean eliminarAuto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }    
}