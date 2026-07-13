package proyecto_final.dao.interfaces;

import java.util.List;
import proyecto_final.modelo.Auto;

public interface DaoAuto {
    boolean crearAuto(Auto auto);
    Auto buscarAutoPorPlaca(String busqueda);
    List<Auto> listarTodos();
    boolean actualizarAuto();
    boolean eliminarAuto();
}