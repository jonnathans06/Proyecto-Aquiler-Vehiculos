package proyecto_final.dao;

import java.sql.*;
import proyecto_final.dao.interfaces.DaoReserva;
import proyecto_final.modelo.Reserva;
import proyecto_final.sql.ConexionDB;

public class DaoReservaImp implements DaoReserva{
    
    Connection con = ConexionDB.conectar();

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
    public boolean listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public boolean buscarReserva(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}