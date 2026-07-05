package proyecto_final.dao.interfaces;

import java.util.List;
import proyecto_final.modelo.Cliente;

public interface DaoCliente {
    boolean crearCliente(Cliente cliente);    
    Cliente buscarClientePorCedula(String cedula);
    List<Cliente> buscarPorCoincidencia(String nombre);
    List<Cliente> listarTodods();
    boolean actualizarCliente(Cliente cliente);
    boolean eliminarCliente(Cliente cliente);
}