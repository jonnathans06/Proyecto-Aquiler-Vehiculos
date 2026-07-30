package proyecto_final.dao;

import java.sql.*;
import java.util.List;
import proyecto_final.dao.interfaces.DaoContrato;
import proyecto_final.dto.DetalleServicioDTO;
import proyecto_final.modelo.Contrato;
import proyecto_final.sql.ConexionDB;

public class DaoContratoImp implements DaoContrato{
    Connection con = ConexionDB.conectar();
    
    @Override
    public boolean crearContrato(Contrato contrato, List<DetalleServicioDTO> detalles) {
        String queryContrato = "insert into alq_contratos "
                + "(con_codigo, con_fecha_inicio, con_fecha_fin, con_subtotal_auto, "
                + "con_subtotal_servicios, con_iva, con_total, cli_cedula, "
                + "aut_matricula, usu_username, res_codigo, con_estado) "
                + "values (seq_alq_contratos.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String queryCodigo = "select seq_alq_contratos.currval from dual";

        String queryDetalle = "insert into alq_contrato_servicios_detalles "
                + "(det_ser_codigo, det_cantidad, det_ser_precio_unitario, "
                + "con_ser_subtotal, det_ser_iva, det_ser_total, con_codigo, ser_codigo) "
                + "values (seq_alq_contrato_servicios_detalles.nextval, ?, ?, ?, ?, ?, ?, ?)";

        String queryReserva = "update alq_reservas set res_estado = 'INACTIVA' "
                + "where res_codigo = ? and res_estado = 'ACTIVA'";

        String queryAuto = "update alq_autos set aut_estado = 'EN_CONTRATO' "
                + "where aut_matricula = ?";

        PreparedStatement psContrato = null;
        PreparedStatement psDetalle = null;
        PreparedStatement psReserva = null;
        PreparedStatement psAuto = null;
        PreparedStatement psCodigo = null;
        ResultSet rs = null;

        try {
            con.setAutoCommit(false);

            psContrato = con.prepareStatement(queryContrato);

            psContrato.setDate(1, java.sql.Date.valueOf(contrato.getConFechaInicio()));
            psContrato.setDate(2, java.sql.Date.valueOf(contrato.getConFechaFin()));
            psContrato.setDouble(3, contrato.getConSubtotalAuto());
            psContrato.setDouble(4, contrato.getConSubtotalServicios());
            psContrato.setDouble(5, contrato.getConIva());
            psContrato.setDouble(6, contrato.getConTotal());
            psContrato.setString(7, contrato.getConCliente().getCliCedula());
            psContrato.setString(8, contrato.getConAuto().getAutMatricula());
            psContrato.setString(9, contrato.getConUsuario().getUsuUsername());
            psContrato.setInt(10, contrato.getConReserva().getResCodigo());
            psContrato.setString(11, contrato.getConEstado());

            int contratoInsertado = psContrato.executeUpdate();

            if (contratoInsertado != 1) {
                con.rollback();
                return false;
            }

            psCodigo = con.prepareStatement(queryCodigo);
            rs = psCodigo.executeQuery();

            if (!rs.next()) {
                con.rollback();
                return false;
            }

            int codigoContrato = rs.getInt(1);
            contrato.setConCodigo(codigoContrato);

            psDetalle = con.prepareStatement(queryDetalle);

            for (DetalleServicioDTO detalle : detalles) {
                psDetalle.setInt(1, detalle.getCantidad());
                psDetalle.setDouble(2, detalle.getPrecioUnitario());
                psDetalle.setDouble(3, detalle.getSubtotal());
                psDetalle.setDouble(4, detalle.getIva());
                psDetalle.setDouble(5, detalle.getTotal());
                psDetalle.setInt(6, codigoContrato);
                psDetalle.setInt(7, detalle.getCodigoServicio());

                int detalleInsertado = psDetalle.executeUpdate();

                if (detalleInsertado != 1) {
                    con.rollback();
                    return false;
                }
            }

            psReserva = con.prepareStatement(queryReserva);
            psReserva.setInt(1, contrato.getConReserva().getResCodigo());

            int reservaActualizada = psReserva.executeUpdate();

            if (reservaActualizada != 1) {
                con.rollback();
                return false;
            }

            psAuto = con.prepareStatement(queryAuto);
            psAuto.setString(1, contrato.getConAuto().getAutMatricula());

            int autoActualizado = psAuto.executeUpdate();

            if (autoActualizado != 1) {
                con.rollback();
                return false;
            }

            con.commit();
            return true;

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException error) {
                System.out.println("Error en rollback: " + error.getMessage());
            }

            System.out.println("Error al crear contrato: " + e.getMessage());
            return false;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (psCodigo != null) {
                    psCodigo.close();
                }

                if (psContrato != null) {
                    psContrato.close();
                }

                if (psDetalle != null) {
                    psDetalle.close();
                }

                if (psReserva != null) {
                    psReserva.close();
                }

                if (psAuto != null) {
                    psAuto.close();
                }

                con.setAutoCommit(true);

            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}