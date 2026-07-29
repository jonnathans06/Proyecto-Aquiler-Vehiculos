package proyecto_final.controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import proyecto_final.dao.interfaces.DaoAuto;
import proyecto_final.dao.interfaces.DaoCliente;
import proyecto_final.dao.interfaces.DaoReserva;
import proyecto_final.modelo.Auto;
import proyecto_final.modelo.Cliente;
import proyecto_final.modelo.Reserva;
import proyecto_final.vista.SistemaVista;
import proyecto_final.vista.clientes.CliCrearVista;
import proyecto_final.vista.reservas.ResCrearVista;

public class ReservaControlador {
    private SistemaVista sistemaVista;
    private CliCrearVista cliCrearVista;
    private ResCrearVista resCrearVista;
    private DaoCliente daoCliente;
    private DaoAuto daoAuto;
    private DaoReserva daoReserva;

    public ReservaControlador(SistemaVista sistemaVista, CliCrearVista cliCrearVista, ResCrearVista resCrearVista, DaoCliente daoCliente, DaoAuto daoAuto, DaoReserva daoReserva) {
        this.sistemaVista = sistemaVista;
        this.cliCrearVista = cliCrearVista;
        this.resCrearVista = resCrearVista;
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
}