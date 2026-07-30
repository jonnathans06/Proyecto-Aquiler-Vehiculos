package proyecto_final.dao.interfaces;

import java.util.List;
import proyecto_final.dto.DetalleServicioDTO;
import proyecto_final.modelo.Contrato;

public interface DaoContrato {
    boolean crearContrato(Contrato contrato, List<DetalleServicioDTO> detalles);
}