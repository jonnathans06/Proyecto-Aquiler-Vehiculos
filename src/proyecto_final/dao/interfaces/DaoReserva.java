package proyecto_final.dao.interfaces;

import java.util.List;
import proyecto_final.dto.ReservaDTO;
import proyecto_final.modelo.Reserva;


public interface DaoReserva {
    boolean crearReserva(Reserva reserva);
    List<ReservaDTO> listarTodas();
    boolean actualizarReserva(Reserva reserva);
    boolean eliminarReserva(Reserva reserva);
    List<ReservaDTO> buscarReserva(int codigo);
    ReservaDTO buscarReservaCruda(int codigo);
}