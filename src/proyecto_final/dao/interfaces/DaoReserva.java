package proyecto_final.dao.interfaces;

import proyecto_final.modelo.Reserva;


public interface DaoReserva {
    boolean crearReserva(Reserva reserva);
    boolean listarTodas();
    boolean actualizarReserva(Reserva reserva);
    boolean eliminarReserva(Reserva reserva);
    boolean buscarReserva(int codigo);
}