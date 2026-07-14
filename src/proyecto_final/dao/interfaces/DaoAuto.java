package proyecto_final.dao.interfaces;

import java.util.List;
import proyecto_final.dto.AutoDTO;
import proyecto_final.modelo.Auto;

public interface DaoAuto {
    boolean crearAuto(Auto auto);
    AutoDTO buscarAutoPorPlaca(String busqueda);
    List<AutoDTO> listarTodos();
    boolean actualizarAuto(Auto auto);
    boolean eliminarAuto();
}