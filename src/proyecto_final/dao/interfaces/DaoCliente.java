package proyecto_final.dao.interfaces;

import java.util.List;
import proyecto_final.modelo.Cliente;

public interface DaoCliente {
    boolean crearCliente(Cliente cliente);
    Cliente buscarClientePorCedula(String busqueda);
    List<Cliente> buscarClientes(String busqueda);
    List<Cliente> listarTodods();
    boolean actualizarCliente(Cliente cliente);
    boolean eliminarCliente(Cliente cliente);
}