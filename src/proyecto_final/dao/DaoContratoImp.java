package proyecto_final.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import proyecto_final.dao.interfaces.DaoContrato;
import proyecto_final.dto.ContratoDTO;
import proyecto_final.dto.DetalleContratoDTO;
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
    
    @Override
    public List<ContratoDTO> buscarContratosPorReserva(int codigoReserva) {
        List<ContratoDTO> contratos = new ArrayList<>();

        String query = "select c.con_codigo, c.res_codigo, c.con_fecha_inicio, c.con_fecha_fin, "
                     + "ma.mar_nombre || ' ' || mo.mod_nombre as vehiculo, "
                     + "a.aut_matricula, "
                     + "cl.cli_nombre || ' ' || cl.cli_apellido as cliente, "
                     + "em.emp_nombre || ' ' || em.emp_apellido as usuario, "
                     + "c.con_subtotal_auto, c.con_subtotal_servicios, "
                     + "(c.con_subtotal_auto + c.con_subtotal_servicios) as subtotal_total, "
                     + "c.con_iva, c.con_total, c.con_estado "
                     + "from alq_contratos c "
                     + "inner join alq_clientes cl on c.cli_cedula = cl.cli_cedula "
                     + "inner join alq_autos a on c.aut_matricula = a.aut_matricula "
                     + "inner join alq_modelos mo on a.mod_codigo = mo.mod_codigo "
                     + "inner join alq_marcas ma on mo.mar_codigo = ma.mar_codigo "
                     + "inner join alq_usuarios u on c.usu_username = u.usu_username "
                     + "inner join alq_empleados em on u.emp_cedula = em.emp_cedula "
                     + "where c.res_codigo = ? "
                     + "order by c.con_codigo";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigoReserva);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                contratos.add(new ContratoDTO(
                        rs.getInt("con_codigo"),
                        rs.getInt("res_codigo"),
                        rs.getDate("con_fecha_inicio").toLocalDate(),
                        rs.getDate("con_fecha_fin").toLocalDate(),
                        rs.getString("vehiculo"),
                        rs.getString("aut_matricula"),
                        rs.getString("cliente"),
                        rs.getString("usuario"),
                        rs.getDouble("con_subtotal_auto"),
                        rs.getDouble("con_subtotal_servicios"),
                        rs.getDouble("subtotal_total"),
                        rs.getDouble("con_iva"),
                        rs.getDouble("con_total"),
                        rs.getString("con_estado")
                ));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar contratos: " + e.getMessage());
        }

        return contratos;
    }
    
    @Override
    public List<ContratoDTO> listarContratos() {
        List<ContratoDTO> contratos = new ArrayList<>();

        String query = "select c.con_codigo, c.res_codigo, c.con_fecha_inicio, c.con_fecha_fin, "
                     + "ma.mar_nombre || ' ' || mo.mod_nombre as vehiculo, "
                     + "a.aut_matricula, "
                     + "cl.cli_nombre || ' ' || cl.cli_apellido as cliente, "
                     + "em.emp_nombre || ' ' || em.emp_apellido as usuario, "
                     + "c.con_subtotal_auto, c.con_subtotal_servicios, "
                     + "(c.con_subtotal_auto + c.con_subtotal_servicios) as subtotal_total, "
                     + "c.con_iva, c.con_total, c.con_estado "
                     + "from alq_contratos c "
                     + "inner join alq_clientes cl on c.cli_cedula = cl.cli_cedula "
                     + "inner join alq_autos a on c.aut_matricula = a.aut_matricula "
                     + "inner join alq_modelos mo on a.mod_codigo = mo.mod_codigo "
                     + "inner join alq_marcas ma on mo.mar_codigo = ma.mar_codigo "
                     + "inner join alq_usuarios u on c.usu_username = u.usu_username "
                     + "inner join alq_empleados em on u.emp_cedula = em.emp_cedula "
                     + "order by c.con_codigo";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                contratos.add(new ContratoDTO(
                        rs.getInt("con_codigo"),
                        rs.getInt("res_codigo"),
                        rs.getDate("con_fecha_inicio").toLocalDate(),
                        rs.getDate("con_fecha_fin").toLocalDate(),
                        rs.getString("vehiculo"),
                        rs.getString("aut_matricula"),
                        rs.getString("cliente"),
                        rs.getString("usuario"),
                        rs.getDouble("con_subtotal_auto"),
                        rs.getDouble("con_subtotal_servicios"),
                        rs.getDouble("subtotal_total"),
                        rs.getDouble("con_iva"),
                        rs.getDouble("con_total"),
                        rs.getString("con_estado")
                ));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al listar contratos: " + e.getMessage());
        }

        return contratos;
    }
    
    @Override
    public List<DetalleContratoDTO> listarDetallesContrato(int codigoContrato) {
        List<DetalleContratoDTO> detalles = new ArrayList<>();

        String query = "select d.det_ser_codigo, d.ser_codigo, s.ser_nombre, "
                + "d.det_ser_precio_unitario, d.det_cantidad, "
                + "d.det_ser_iva, d.con_ser_subtotal, d.det_ser_total "
                + "from alq_contrato_servicios_detalles d "
                + "inner join alq_servicios s on d.ser_codigo = s.ser_codigo "
                + "where d.con_codigo = ? "
                + "order by d.det_ser_codigo";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigoContrato);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                detalles.add(new DetalleContratoDTO(
                        rs.getInt("det_ser_codigo"),
                        rs.getInt("ser_codigo"),
                        rs.getString("ser_nombre"),
                        rs.getDouble("det_ser_precio_unitario"),
                        rs.getInt("det_cantidad"),
                        rs.getDouble("det_ser_iva"),
                        rs.getDouble("con_ser_subtotal"),
                        rs.getDouble("det_ser_total")
                ));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al listar detalles del contrato: " + e.getMessage());
        }

        return detalles;
    }
    
    @Override
    public ContratoDTO buscarContratoPorCodigo(int codigoContrato) {
        String query = "select c.con_codigo, c.res_codigo, c.con_fecha_inicio, "
                + "c.con_fecha_fin, "
                + "ma.mar_nombre || ' ' || mo.mod_nombre as vehiculo, "
                + "c.aut_matricula, "
                + "cl.cli_nombre || ' ' || cl.cli_apellido as cliente, "
                + "em.emp_nombre || ' ' || em.emp_apellido as usuario, "
                + "c.con_subtotal_auto, c.con_subtotal_servicios, "
                + "(c.con_subtotal_auto + c.con_subtotal_servicios) as subtotal_total, "
                + "c.con_iva, c.con_total, c.con_estado "
                + "from alq_contratos c "
                + "inner join alq_clientes cl on c.cli_cedula = cl.cli_cedula "
                + "inner join alq_autos au on c.aut_matricula = au.aut_matricula "
                + "inner join alq_modelos mo on au.mod_codigo = mo.mod_codigo "
                + "inner join alq_marcas ma on mo.mar_codigo = ma.mar_codigo "
                + "inner join alq_usuarios u on c.usu_username = u.usu_username "
                + "inner join alq_empleados em on u.emp_cedula = em.emp_cedula "
                + "where c.con_codigo = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigoContrato);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ContratoDTO contrato = new ContratoDTO(
                        rs.getInt("con_codigo"),
                        rs.getInt("res_codigo"),
                        rs.getDate("con_fecha_inicio").toLocalDate(),
                        rs.getDate("con_fecha_fin").toLocalDate(),
                        rs.getString("vehiculo"),
                        rs.getString("aut_matricula"),
                        rs.getString("cliente"),
                        rs.getString("usuario"),
                        rs.getDouble("con_subtotal_auto"),
                        rs.getDouble("con_subtotal_servicios"),
                        rs.getDouble("subtotal_total"),
                        rs.getDouble("con_iva"),
                        rs.getDouble("con_total"),
                        rs.getString("con_estado")
                );

                rs.close();
                ps.close();
                return contrato;
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar contrato: " + e.getMessage());
        }

        return null;
    }
    
    @Override
    public boolean actualizarContrato(int codigoContrato, LocalDate fechaInicio, LocalDate fechaFin, double subtotalAuto, double subtotalServicios, double iva, double total, List<DetalleServicioDTO> detalles) {
        String queryContrato = "update alq_contratos set con_fecha_inicio = ?, con_fecha_fin = ?, "
                + "con_subtotal_auto = ?, con_subtotal_servicios = ?, con_iva = ?, con_total = ? "
                + "where con_codigo = ?";

        String queryEliminarDetalles = "delete from alq_contrato_servicios_detalles where con_codigo = ?";

        String queryInsertarDetalle = "insert into alq_contrato_servicios_detalles "
                + "(det_ser_codigo, det_cantidad, det_ser_precio_unitario, con_ser_subtotal, "
                + "det_ser_iva, det_ser_total, con_codigo, ser_codigo) "
                + "values (seq_alq_contrato_servicios_detalles.nextval, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement psContrato = null;
        PreparedStatement psEliminar = null;
        PreparedStatement psDetalle = null;

        try {
            con.setAutoCommit(false);

            psContrato = con.prepareStatement(queryContrato);
            psContrato.setDate(1, java.sql.Date.valueOf(fechaInicio));
            psContrato.setDate(2, java.sql.Date.valueOf(fechaFin));
            psContrato.setDouble(3, subtotalAuto);
            psContrato.setDouble(4, subtotalServicios);
            psContrato.setDouble(5, iva);
            psContrato.setDouble(6, total);
            psContrato.setInt(7, codigoContrato);

            int contratoActualizado = psContrato.executeUpdate();

            if (contratoActualizado != 1) {
                con.rollback();
                return false;
            }

            psEliminar = con.prepareStatement(queryEliminarDetalles);
            psEliminar.setInt(1, codigoContrato);
            psEliminar.executeUpdate();

            if (detalles != null && !detalles.isEmpty()) {
                psDetalle = con.prepareStatement(queryInsertarDetalle);

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
            }

            con.commit();
            return true;

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException error) {
                System.out.println("Error en rollback: " + error.getMessage());
            }

            System.out.println("Error al actualizar contrato: " + e.getMessage());
            return false;

        } finally {
            try {
                if (psContrato != null) {
                    psContrato.close();
                }

                if (psEliminar != null) {
                    psEliminar.close();
                }

                if (psDetalle != null) {
                    psDetalle.close();
                }

                con.setAutoCommit(true);

            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
    
    @Override
    public boolean cancelarContrato(int codigoContrato, String matricula) {
        String queryContrato = "update alq_contratos set con_estado = 'INACTIVO' "
                + "where con_codigo = ? and con_estado = 'ACTIVO'";

        String queryAuto = "update alq_autos set aut_estado = 'ACTIVO' "
                + "where aut_matricula = ? and aut_estado = 'EN_CONTRATO'";

        PreparedStatement psContrato = null;
        PreparedStatement psAuto = null;

        try {
            con.setAutoCommit(false);

            psContrato = con.prepareStatement(queryContrato);
            psContrato.setInt(1, codigoContrato);

            int contratoActualizado = psContrato.executeUpdate();

            if (contratoActualizado != 1) {
                con.rollback();
                return false;
            }

            psAuto = con.prepareStatement(queryAuto);
            psAuto.setString(1, matricula);

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

            System.out.println("Error al cancelar contrato: " + e.getMessage());
            return false;

        } finally {
            try {
                if (psContrato != null) {
                    psContrato.close();
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