package proyecto_final.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyecto_final.dao.interfaces.DaoReserva;
import proyecto_final.dto.ReservaDTO;
import proyecto_final.modelo.Reserva;
import proyecto_final.sql.ConexionDB;

public class DaoReservaImp implements DaoReserva{
    
    Connection con = ConexionDB.conectar();
    List<ReservaDTO> reservas = new ArrayList<>();

    @Override
    public boolean crearReserva(Reserva reserva) {
        String queryReserva =
                "insert into alq_reservas "
                + "(res_codigo, res_fecha_hora_inicio, res_fecha_hora_fin, "
                + "cli_cedula, aut_matricula, usu_username, res_estado) "
                + "values (seq_alq_reservas.nextval, ?, ?, ?, ?, ?, 'ACTIVA')";
        
        String queryAuto =
                "update alq_autos "
                + "set aut_estado = 'ALQUILADO' "
                + "where aut_matricula = ? "
                + "and aut_estado = 'ACTIVO'";
        
        try {
            con.setAutoCommit(false);

            PreparedStatement psReserva = con.prepareStatement(queryReserva);

            psReserva.setTimestamp(1, Timestamp.valueOf(reserva.getResFechaHoraInicio()));
            psReserva.setTimestamp(2, Timestamp.valueOf(reserva.getResFechaHoraFin()));
            psReserva.setString(3, reserva.getResCliente().getCliCedula());
            psReserva.setString(4, reserva.getResAuto().getAutMatricula());
            psReserva.setString(5, reserva.getResUsuario());

            int reservaCreada = psReserva.executeUpdate();
            
            PreparedStatement psAuto = con.prepareStatement(queryAuto);
            psAuto.setString(1, reserva.getResAuto().getAutMatricula());
            
            int autoActualizado = psAuto.executeUpdate();

            if (reservaCreada == 1 && autoActualizado == 1) {
                con.commit();

                psReserva.close();
                psAuto.close();

                return true;
            }

            con.rollback();

            psReserva.close();
            psAuto.close();

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException errorRollback) {
                System.out.println(errorRollback.getMessage());
            }

            System.out.println(e.getMessage());

        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException errorRollback) {
                System.out.println(errorRollback.getMessage());
            }

            System.out.println(e.getMessage());

        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return false;
    }

    @Override
    public List<ReservaDTO> listarTodas() {
        reservas.clear();
        
        String query = "select r.res_codigo as codigo, r.res_fecha_hora_inicio as fecha_inicio, r.res_fecha_hora_fin as fecha_fin, "
                     + "cl.cli_cedula as cedula_cliente, cl.cli_nombre || ' ' || cl.cli_apellido as cliente, "
                     + "ma.mar_nombre || ' ' || mo.mod_nombre as auto, "
                     + "em.emp_nombre || ' ' || em.emp_apellido as empleado, r.res_estado as estado "
                     + "from alq_reservas r "
                     + "inner join alq_clientes cl on r.cli_cedula = cl.cli_cedula "
                     + "inner join alq_autos au on r.aut_matricula = au.aut_matricula "
                     + "inner join alq_modelos mo on au.mod_codigo = mo.mod_codigo "
                     + "inner join alq_marcas ma on mo.mar_codigo = ma.mar_codigo "
                     + "inner join alq_usuarios us on r.usu_username = us.usu_username "
                     + "inner join alq_empleados em on us.emp_cedula = em.emp_cedula "
                     + "order by r.res_codigo";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reservas.add(new ReservaDTO(
                    rs.getInt("codigo"),
                    rs.getTimestamp("fecha_inicio").toLocalDateTime(),
                    rs.getTimestamp("fecha_fin").toLocalDateTime(),
                    rs.getString("cedula_cliente"),
                    rs.getString("cliente"),
                    rs.getString("auto"),
                    rs.getString("empleado"),
                    rs.getString("estado")
                ));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al listar reservas: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return reservas;
    }

    @Override
    public boolean actualizarReserva(Reserva reserva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarReserva(Reserva reserva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ReservaDTO> buscarReserva(int codigo) {
        reservas.clear();
        
        String query = "select r.res_codigo as codigo, r.res_fecha_hora_inicio as fecha_inicio, r.res_fecha_hora_fin as fecha_fin, "
                     + "cl.cli_cedula as cedula_cliente, cl.cli_nombre || ' ' || cl.cli_apellido as cliente, "
                     + "ma.mar_nombre || ' ' || mo.mod_nombre as auto, "
                     + "em.emp_nombre || ' ' || em.emp_apellido as empleado, r.res_estado as estado "
                     + "from alq_reservas r "
                     + "inner join alq_clientes cl on r.cli_cedula = cl.cli_cedula "
                     + "inner join alq_autos au on r.aut_matricula = au.aut_matricula "
                     + "inner join alq_modelos mo on au.mod_codigo = mo.mod_codigo "
                     + "inner join alq_marcas ma on mo.mar_codigo = ma.mar_codigo "
                     + "inner join alq_usuarios us on r.usu_username = us.usu_username "
                     + "inner join alq_empleados em on us.emp_cedula = em.emp_cedula "
                     + "where r.res_codigo = ? "
                     + "order by r.res_codigo";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reservas.add(new ReservaDTO(
                    rs.getInt("codigo"),
                    rs.getTimestamp("fecha_inicio").toLocalDateTime(),
                    rs.getTimestamp("fecha_fin").toLocalDateTime(),
                    rs.getString("cedula_cliente"),
                    rs.getString("cliente"),
                    rs.getString("auto"),
                    rs.getString("empleado"),
                    rs.getString("estado")
                ));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al listar reservas: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return reservas;
    }   
}