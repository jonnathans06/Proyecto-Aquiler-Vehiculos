package proyecto_final.dao.interfaces;

import java.util.List;
import proyecto_final.modelo.Empleado;

public interface DaoEmpleado {
    boolean crearEmpleado(Empleado empleado);
    Empleado buscarEmpleadoPorCedula(String username);
    Empleado buscarEmpleadoPorNombre(String username);
    List<Empleado> buscarPorCoincidencia(String username);
    List<Empleado> listarTodos();
    boolean actualizarEmpleado(Empleado empleado);
    boolean desactivarEmpleado(String username);
}