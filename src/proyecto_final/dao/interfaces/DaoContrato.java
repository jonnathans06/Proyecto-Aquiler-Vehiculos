package proyecto_final.dao.interfaces;

import java.util.List;
import proyecto_final.dto.ContratoDTO;
import proyecto_final.dto.DetalleContratoDTO;
import proyecto_final.dto.DetalleServicioDTO;
import proyecto_final.modelo.Contrato;

public interface DaoContrato {
    boolean crearContrato(Contrato contrato, List<DetalleServicioDTO> detalles);
    List<ContratoDTO> buscarContratosPorReserva(int codigoReserva);
    List<ContratoDTO> listarContratos();
    List<DetalleContratoDTO> listarDetallesContrato(int codigoContrato);
}