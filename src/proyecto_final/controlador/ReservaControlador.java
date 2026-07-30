package proyecto_final.controlador;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import proyecto_final.dao.interfaces.DaoAuto;
import proyecto_final.dao.interfaces.DaoCliente;
import proyecto_final.dao.interfaces.DaoReserva;
import proyecto_final.dto.AutoDTO;
import proyecto_final.dto.ReservaDTO;
import proyecto_final.modelo.Auto;
import proyecto_final.modelo.Cliente;
import proyecto_final.modelo.Reserva;
import proyecto_final.vista.SistemaVista;
import proyecto_final.vista.clientes.CliCrearVista;
import proyecto_final.vista.reservas.ResActualizarVista;
import proyecto_final.vista.reservas.ResCrearVista;
import proyecto_final.vista.reservas.ResListarVista;

public class ReservaControlador {
    private SistemaVista sistemaVista;
    private CliCrearVista cliCrearVista;
    private ResCrearVista resCrearVista;
    private ResListarVista resListarVista;
    private ResActualizarVista resActualizarVista;
    private DaoCliente daoCliente;
    private DaoAuto daoAuto;
    private DaoReserva daoReserva;

    public ReservaControlador(SistemaVista sistemaVista, CliCrearVista cliCrearVista, ResCrearVista resCrearVista, ResListarVista resListarVista, ResActualizarVista resActualizarVista, 
                              DaoCliente daoCliente, DaoAuto daoAuto, DaoReserva daoReserva) {
        this.sistemaVista = sistemaVista;
        this.cliCrearVista = cliCrearVista;
        this.resCrearVista = resCrearVista;
        this.resListarVista = resListarVista;
        this.resActualizarVista = resActualizarVista;
        this.daoCliente = daoCliente;
        this.daoAuto = daoAuto;
        this.daoReserva = daoReserva;
        accionesBotones();
    }
    
    
    
    private void accionesBotones(){
        // Buscar Cliente
        resCrearVista.getBtnBscCliente().addActionListener((e) -> {
            buscarClienteCrearReserva();
        });     
        
        // Registrar Cliente
        resCrearVista.getBtnAgrCliente().addActionListener((e) -> {
            agregarCliente();
        });
        
        // Buscar Auto
        cargarDatosAutoCrearReserva();
        
        // Crear Reserva
        resCrearVista.getBtnConfirmar().addActionListener((e) -> {
            crearReserva();
        });
        
        // Listar Todas
        resListarVista.getBtnListar().addActionListener((e) -> {
            listarTodas();
        });
        
        // Buscar Rerserva Listar
        resListarVista.getBtnBuscar().addActionListener((e) -> {
            buscarReservaListar();
        });
        ActionListener l;
        
        // Buscar Reserva Actualizar
        resActualizarVista.getBtnBuscar().addActionListener((e) -> {
            buscarReservaActualizar();
        });
        
        // Cargar Autos Actualizar
        cargarDatosAutoActualizarReserva();
        
        // Actualizar Reserva
        resActualizarVista.getBtnConfirmar().addActionListener((e) -> {
            actualizarReserva();
        });
    }
    
    private boolean buscarClienteCrearReserva(){
        try {
            Cliente cli = daoCliente.buscarClientePorCedula(resCrearVista.getTxtBusqCliente().getText().trim());
            if (cli != null) {
                resCrearVista.getTxtNomCliente().setText(cli.getCliNombre());
                resCrearVista.getTxtApeCliente().setText(cli.getCliApellido());
                return true;
            } else {
                resCrearVista.mostrarMensajes("Error al encontrar cliente");
            }
        } catch (NullPointerException nul) {
            System.out.println("Error");
        }
        
        return false;
    }
    
    private void cargarDatosAutoCrearReserva(){
        resCrearVista.getCbxTipo().addActionListener((e) -> {
            String modelo = resCrearVista.getCbxTipo().getSelectedItem().toString();
            
            resCrearVista.mostrarDatosAuto(daoAuto.buscarAutoReserva(modelo));
        });
    }
    
    private void cargarDatosAutoActualizarReserva(){
        resActualizarVista.getCbxTipo().addActionListener((e) -> {
            String tipo = resActualizarVista.getCbxTipo().getSelectedItem().toString();
            
            resActualizarVista.mostrarDatosAuto(daoAuto.buscarAutoReserva(tipo));
        });
    }
    
    private void agregarCliente(){
        SistemaVista.addComponente(sistemaVista.getDesktopPane(), cliCrearVista);
    }
    
    private void crearReserva(){
        boolean inserto = false;

        Date fechaInicio = resCrearVista.getDtFechaIni().getDate();
        Date fechaFin = resCrearVista.getDtFechaFin().getDate();
        Date horaInicio = (Date) resCrearVista.getSpHoraIni().getValue();
        Date horaFin = (Date) resCrearVista.getSpHoraFin().getValue();

        String cedula = resCrearVista.getTxtBusqCliente().getText().trim();
        String matricula = resCrearVista.getTxtMatricula().getText().trim();
        String usuario = LoginControlador.getUsuarioAutenticado().getUsuUsername();

        if (!buscarClienteCrearReserva()) {
            resCrearVista.mostrarMensajes("Cliente no encontrado");
            return;
        }

        if (matricula.isEmpty()) {
            resCrearVista.mostrarMensajes("Debe seleccionar un auto");
            return;
        }

        if (fechaInicio == null || fechaFin == null) {
            resCrearVista.mostrarMensajes("Seleccione la fecha de inicio y la fecha de finalización.");
            return;
        }

        if (horaInicio == null || horaFin == null) {
            resCrearVista.mostrarMensajes("Seleccione la hora de inicio y la hora de finalización.");
            return;
        }

        if (usuario == null || usuario.isEmpty()) {
            resCrearVista.mostrarMensajes("No se pudo identificar al usuario autenticado.");
            return;
        }

        LocalDateTime fechaHoraInicio = convertirFechaHora(fechaInicio, horaInicio);
        LocalDateTime fechaHoraFin = convertirFechaHora(fechaFin, horaFin);

        if (!fechaHoraFin.isAfter(fechaHoraInicio)) {
            resCrearVista.mostrarMensajes("La fecha y hora de finalización deben ser posteriores a la fecha y hora de inicio.");
            return;
        }

        Cliente cliente = new Cliente();
        cliente.setCliCedula(cedula);

        Auto auto = new Auto();
        auto.setAutMatricula(matricula);

        Reserva reserva = new Reserva(fechaHoraInicio, fechaHoraFin, cliente, auto, usuario);

        inserto = daoReserva.crearReserva(reserva);

        if (inserto) {
            resCrearVista.mostrarMensajes("Reserva registrada correctamente");
            resCrearVista.limpiarCampos();
        } else {
            resCrearVista.mostrarMensajes("No se pudo registrar la reserva. El auto podría no estar disponible.");
        }
    }
    
    private LocalDateTime convertirFechaHora(Date fecha, Date hora){
        return LocalDateTime.of(
                fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                hora.toInstant().atZone(ZoneId.systemDefault()).toLocalTime().withSecond(0).withNano(0)
        );
    }
    
    private void listarTodas(){
        resListarVista.cargarDatosResevas(daoReserva.listarTodas());
    }
    
    private void buscarReservaListar() {
        if (resListarVista.getTxtBusqueda().getText().isEmpty()) {
            resListarVista.mostrarMensajes("Debe colocar el codigo de reserva para buscar");
            return;
        }
        
        if (!resListarVista.getTxtBusqueda().getText().matches("\\d+")) {
            resListarVista.mostrarMensajes("Codigo invalido");
            return;
        }
        
        resListarVista.cargarDatosResevas(daoReserva.buscarReserva(Integer.parseInt(resListarVista.getTxtBusqueda().getText().trim())));
    }
    
    private boolean buscarReservaActualizar (){      
        if (resActualizarVista.getTxtBusqueda().getText().isEmpty()) {
            resActualizarVista.mostrarMensajes("Campo de busqueda vacío");
            return false;
        }

        ReservaDTO reserva = daoReserva.buscarReservaCruda(Integer.parseInt(resActualizarVista.getTxtBusqueda().getText().trim()));

        if (reserva == null) {
            resActualizarVista.mostrarMensajes("Error al buscar reserva");
            return false;
        }

        AutoDTO autoAnterior = daoAuto.buscarAutoPorPlaca(reserva.getMatricula());
        Cliente cliente = daoCliente.buscarClientePorCedula(reserva.getCliente());

        resActualizarVista.getTxtMarcaAnterior().setText(autoAnterior.getMarca());
        resActualizarVista.getTxtMatriculaAnterior().setText(autoAnterior.getMatricula());
        resActualizarVista.getTxtModeloAnterior().setText(autoAnterior.getModelo());
        resActualizarVista.getTxtPrecioAnterior().setText(String.valueOf(autoAnterior.getPrecioDia()));

        resActualizarVista.getTxtCliNombre().setText(cliente.getCliNombre());
        resActualizarVista.getTxtCliApellido().setText(cliente.getCliApellido());

        LocalDateTime fechaHoraInicio = reserva.getFechaInicio();
        LocalDateTime fechaHoraFin = reserva.getFechaFin();

        Date fechaInicio = Date.from(fechaHoraInicio.atZone(ZoneId.systemDefault()).toInstant());
        Date fechaFin = Date.from(fechaHoraFin.atZone(ZoneId.systemDefault()).toInstant());

        resActualizarVista.getDtFechaIni().setDate(fechaInicio);
        resActualizarVista.getDtFechaFin().setDate(fechaFin);

        resActualizarVista.getSpHoraIni().setValue(fechaInicio);
        resActualizarVista.getSpHoraFin().setValue(fechaFin);
        
        return true;
    }
    
    private void actualizarReserva(){
        boolean actualizo = false;

        if (!buscarReservaActualizar()) {
            resActualizarVista.mostrarMensajes("Reserva no encontrada");
            return;
        }

        String codigoTexto = resActualizarVista.getTxtBusqueda().getText().trim();
        String matriculaAnterior = resActualizarVista.getTxtMatriculaAnterior().getText().trim();
        String matriculaNueva = resActualizarVista.getTxtMatriculaNuevo().getText().trim();

        Date fechaInicio = resActualizarVista.getDtFechaIni().getDate();
        Date fechaFin = resActualizarVista.getDtFechaFin().getDate();
        Date horaInicio = (Date) resActualizarVista.getSpHoraIni().getValue();
        Date horaFin = (Date) resActualizarVista.getSpHoraFin().getValue();

        if (codigoTexto.isEmpty()) {
            resActualizarVista.mostrarMensajes("Ingrese el código de la reserva");
            return;
        }

        if (!codigoTexto.matches("\\d+")) {
            resActualizarVista.mostrarMensajes("El código de la reserva debe ser numérico");
            return;
        }

        if (matriculaNueva.isEmpty()) {
            resActualizarVista.mostrarMensajes("Debe seleccionar un auto");
            return;
        }

        if (fechaInicio == null || fechaFin == null) {
            resActualizarVista.mostrarMensajes("Seleccione la fecha de inicio y la fecha de finalización");
            return;
        }

        if (horaInicio == null || horaFin == null) {
            resActualizarVista.mostrarMensajes("Seleccione la hora de inicio y la hora de finalización");
            return;
        }

        int codigo = Integer.parseInt(codigoTexto);

        LocalDateTime fechaHoraInicio = convertirFechaHora(fechaInicio, horaInicio);
        LocalDateTime fechaHoraFin = convertirFechaHora(fechaFin, horaFin);

        if (!fechaHoraFin.isAfter(fechaHoraInicio)) {
            resActualizarVista.mostrarMensajes("La fecha y hora de finalización deben ser posteriores a la fecha y hora de inicio");
            return;
        }

        ReservaDTO reservaAnterior = daoReserva.buscarReservaCruda(codigo);

        if (reservaAnterior == null) {
            resActualizarVista.mostrarMensajes("No se pudo recuperar la reserva");
            return;
        }

        Cliente cliente = daoCliente.buscarClientePorCedula(reservaAnterior.getCliente());

        Auto auto = new Auto();
        auto.setAutMatricula(matriculaNueva);

        String usuario = LoginControlador.getUsuarioAutenticado().getUsuUsername();

        Reserva reserva = new Reserva(codigo, fechaHoraInicio, fechaHoraFin, cliente, auto, usuario, reservaAnterior.getEstado());

        boolean cambioAuto = !matriculaAnterior.equals(matriculaNueva);

        if (cambioAuto) {
            boolean liberoAutoAnterior = daoAuto.cambiarEstadoAuto(matriculaAnterior, "ACTIVO");

            if (!liberoAutoAnterior) {
                resActualizarVista.mostrarMensajes("No se pudo liberar el auto anterior");
                return;
            }

            boolean reservoAutoNuevo = daoAuto.cambiarEstadoAuto(matriculaNueva, "ALQUILADO");

            if (!reservoAutoNuevo) {
                daoAuto.cambiarEstadoAuto(matriculaAnterior, "ALQUILADO");
                resActualizarVista.mostrarMensajes("No se pudo asignar el nuevo auto");
                return;
            }
        }

        actualizo = daoReserva.actualizarReserva(reserva);

        if (actualizo) {
            resActualizarVista.mostrarMensajes("Reserva actualizada correctamente");
            resActualizarVista.limpiar();
        } else {
            if (cambioAuto) {
                daoAuto.cambiarEstadoAuto(matriculaNueva, "ACTIVO");
                daoAuto.cambiarEstadoAuto(matriculaAnterior, "ALQUILADO");
            }

            resActualizarVista.mostrarMensajes("No se pudo actualizar la reserva");
        }
    }
}