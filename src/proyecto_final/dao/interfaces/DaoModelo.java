package proyecto_final.dao.interfaces;

import java.util.List;
import proyecto_final.modelo.Modelo;

public interface DaoModelo {
    List<Modelo> listarTodo();
    List<Modelo> buscarModelosPorMarca(String busqueda);
    Modelo buscarModeloPorNombre(String busqueda);
}