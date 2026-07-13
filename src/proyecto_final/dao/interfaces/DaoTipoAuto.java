package proyecto_final.dao.interfaces;

import java.util.List;
import proyecto_final.modelo.TipoAuto;

public interface DaoTipoAuto {
    List<TipoAuto> listarTiposAutos();
    TipoAuto buscarPorCodigo(int busqueda);
    Integer obtenerCodigo(String busqueda);
}