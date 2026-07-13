package proyecto_final.dao.interfaces;

import java.util.List;
import proyecto_final.modelo.Marca;

public interface DaoMarca {
    List<Marca> listarMarcas();
    Integer obtenerCodigo(String busqueda);
}