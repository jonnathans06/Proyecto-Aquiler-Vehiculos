package proyecto_final.dao.interfaces;

import java.util.List;
import proyecto_final.modelo.Marca;

public interface DaoMarca {
    List<Marca> listarMarcas();
    int obtenerCodigo(String busqueda);
}