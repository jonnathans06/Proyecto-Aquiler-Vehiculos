package proyecto_final.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyecto_final.dao.interfaces.DaoServicio;
import proyecto_final.modelo.Servicio;
import proyecto_final.sql.ConexionDB;

public class DaoServicioImp implements DaoServicio{
    Connection con = ConexionDB.conectar();
    
    @Override
    public List<Servicio> listarServicios() {
        List<Servicio> servicios = new ArrayList<>();

        String query = "select ser_codigo, ser_nombre, ser_precio_unitario "
                     + "from alq_servicios "
                     + "order by ser_nombre";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Servicio servicio = new Servicio(rs.getInt("ser_codigo"), rs.getString("ser_nombre"), rs.getDouble("ser_precio_unitario"));

                servicios.add(servicio);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al listar servicios: " + e.getMessage());
        }

        return servicios;
    }
    
}