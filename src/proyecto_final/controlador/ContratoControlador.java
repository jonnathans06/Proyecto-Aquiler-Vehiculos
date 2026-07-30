package proyecto_final.controlador;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import proyecto_final.dao.interfaces.DaoAuto;
import proyecto_final.dao.interfaces.DaoCliente;
import proyecto_final.dao.interfaces.DaoContrato;
import proyecto_final.dao.interfaces.DaoReserva;
import proyecto_final.dao.interfaces.DaoServicio;
import proyecto_final.dto.AutoDTO;
import proyecto_final.dto.ContratoDTO;
import proyecto_final.dto.DetalleContratoDTO;
import proyecto_final.dto.DetalleServicioDTO;
import proyecto_final.dto.ReservaDTO;
import proyecto_final.modelo.Auto;
import proyecto_final.modelo.Cliente;
import proyecto_final.modelo.Contrato;
import proyecto_final.modelo.Reserva;
import proyecto_final.modelo.Servicio;
import proyecto_final.modelo.Usuario;
import proyecto_final.vista.contratos.ConCrearVista;
import proyecto_final.vista.contratos.ConListarVista;

public class ContratoControlador {

    private ConCrearVista conCrearVista;
    private ConListarVista conListarVista;
    private List<ContratoDTO> contratosListados;

    private DaoCliente daoCliente;
    private DaoReserva daoReserva;
    private DaoServicio daoServicio;
    private DaoAuto daoAuto;
    private DaoContrato daoContrato;

    private List<Servicio> servicios;
    private Servicio servicioSeleccionado;

    private List<ReservaDTO> reservasCliente;
    private ReservaDTO reservaSeleccionada;

    private List<DetalleServicioDTO> detallesServicios = new ArrayList<>();

    private AutoDTO autoSeleccionado;

    public ContratoControlador(ConCrearVista conCrearVista, ConListarVista conListarVista,
            DaoCliente daoCliente, DaoReserva daoReserva, DaoServicio daoServicio,
            DaoAuto daoAuto, DaoContrato daoContrato) {

        this.conCrearVista = conCrearVista;
        this.conListarVista = conListarVista;
        this.daoCliente = daoCliente;
        this.daoReserva = daoReserva;
        this.daoServicio = daoServicio;
        this.daoAuto = daoAuto;
        this.daoContrato = daoContrato;

        configurarAcciones();
        cargarServicios();
    }

    private void configurarAcciones(){
        conCrearVista.getBtnBuscar().addActionListener(
                e -> buscarClienteContrato()
        );

        conCrearVista.getBtnSeleccionar().addActionListener(
                e -> seleccionarReserva()
        );

        conCrearVista.getCbxServicios().addActionListener(
                e -> seleccionarServicio()
        );

        conCrearVista.getBtnAgregarServicio().addActionListener(
                e -> agregarServicio()
        );

        conCrearVista.getBtnEliminarServicios().addActionListener(
                e -> eliminarServicio()
        );

        conCrearVista.getBtnConfirmar().addActionListener(
                e -> crearContrato()
        );

        conCrearVista.getDtFechaFin().getDateEditor()
                .addPropertyChangeListener(
                        "date",
                        e -> actualizarSubtotalAuto()
                );
        
        conListarVista.getBtnBuscar().addActionListener(e -> buscarContrato());
        conListarVista.getBtnListar().addActionListener(e -> listarContratos());
        conListarVista.getBtnLimpiar().addActionListener(e -> limpiarListado());

        conListarVista.getTblContrato().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarContratoListado();
            }
        });
    }

    private void buscarClienteContrato(){
        String cedula = conCrearVista.getTxtBusqueda().getText().trim();

        if (cedula.isEmpty()) {
            conCrearVista.mostrarMensajes(
                    "Ingrese la cédula del cliente"
            );
            return;
        }

        Cliente cliente = daoCliente.buscarClientePorCedula(cedula);

        if (cliente == null) {
            conCrearVista.mostrarMensajes(
                    "Cliente no encontrado"
            );
            return;
        }

        reservasCliente = daoReserva.buscarReservasActivasCliente(cedula);

        if (reservasCliente == null || reservasCliente.isEmpty()) {
            conCrearVista.mostrarMensajes(
                    "El cliente no tiene reservas activas"
            );

            conCrearVista.getCbxReservas().removeAllItems();
            return;
        }

        String nombreCliente = cliente.getCliNombre()
                + " "
                + cliente.getCliApellido();

        conCrearVista.getTxtCliente().setText(nombreCliente);
        conCrearVista.getTxtResCliente().setText(nombreCliente);

        conCrearVista.cargarReservas(reservasCliente);
    }

    private void seleccionarReserva(){
        if (reservasCliente == null || reservasCliente.isEmpty()) {
            conCrearVista.mostrarMensajes(
                    "Primero busque las reservas del cliente"
            );
            return;
        }

        int indice = conCrearVista.getCbxReservas().getSelectedIndex();

        if (indice < 0 || indice >= reservasCliente.size()) {
            conCrearVista.mostrarMensajes(
                    "Seleccione una reserva"
            );
            return;
        }

        reservaSeleccionada = reservasCliente.get(indice);

        autoSeleccionado = daoAuto.buscarAutoPorPlaca(
                reservaSeleccionada.getMatricula()
        );

        if (autoSeleccionado == null) {
            conCrearVista.mostrarMensajes(
                    "No se pudo obtener el auto"
            );
            return;
        }

        conCrearVista.getTxtAuto().setText(
                reservaSeleccionada.getAuto()
        );

        conCrearVista.getTxtMatricula().setText(
                reservaSeleccionada.getMatricula()
        );

        conCrearVista.getTxtResAuto().setText(
                reservaSeleccionada.getAuto()
        );

        actualizarSubtotalAuto();
    }

    private void cargarServicios(){
        servicios = daoServicio.listarServicios();

        if (servicios == null || servicios.isEmpty()) {
            conCrearVista.mostrarMensajes(
                    "No existen servicios registrados"
            );
            return;
        }

        conCrearVista.cargarServicios(servicios);
    }

    private void seleccionarServicio(){
        if (servicios == null || servicios.isEmpty()) {
            return;
        }

        int indice = conCrearVista.getCbxServicios().getSelectedIndex();

        if (indice < 0 || indice >= servicios.size()) {
            return;
        }

        servicioSeleccionado = servicios.get(indice);

        conCrearVista.getTxtPrecioUnitario().setText(
                String.format(
                        "%.2f",
                        servicioSeleccionado.getSerPrecioUnitario()
                )
        );
    }

    private void agregarServicio(){
        if (servicioSeleccionado == null) {
            conCrearVista.mostrarMensajes(
                    "Seleccione un servicio"
            );
            return;
        }

        Object cantidadSeleccionada
                = conCrearVista.getCbxCantidad().getSelectedItem();

        if (cantidadSeleccionada == null) {
            conCrearVista.mostrarMensajes(
                    "Seleccione una cantidad"
            );
            return;
        }

        for (DetalleServicioDTO detalle : detallesServicios) {
            if (detalle.getCodigoServicio()
                    == servicioSeleccionado.getSerCodigo()) {

                conCrearVista.mostrarMensajes(
                        "El servicio ya fue agregado"
                );
                return;
            }
        }

        int cantidad = Integer.parseInt(
                cantidadSeleccionada.toString()
        );

        double precioUnitario
                = servicioSeleccionado.getSerPrecioUnitario();

        double subtotal = cantidad * precioUnitario;
        double iva = subtotal * 0.15;
        double total = subtotal + iva;

        DetalleServicioDTO detalle = new DetalleServicioDTO(
                servicioSeleccionado.getSerCodigo(),
                servicioSeleccionado.getSerNombre(),
                cantidad,
                precioUnitario,
                subtotal,
                iva,
                total
        );

        detallesServicios.add(detalle);

        conCrearVista.cargarDetallesServicios(detallesServicios);
        actualizarSubtotalServicios();
    }

    private void eliminarServicio(){
        int fila = conCrearVista.getTblServicios().getSelectedRow();

        if (fila < 0) {
            conCrearVista.mostrarMensajes(
                    "Seleccione un servicio de la tabla"
            );
            return;
        }

        detallesServicios.remove(fila);

        conCrearVista.cargarDetallesServicios(detallesServicios);
        actualizarSubtotalServicios();
    }

    private void actualizarSubtotalServicios(){
        double subtotalServicios = 0;

        for (DetalleServicioDTO detalle : detallesServicios) {
            subtotalServicios += detalle.getSubtotal();
        }

        conCrearVista.getTxtResServicios().setText(
                String.format("%.2f", subtotalServicios)
        );

        actualizarResumenContrato();
    }

    private void actualizarSubtotalAuto(){
        if (autoSeleccionado == null) {
            return;
        }

        Date fechaInicio
                = conCrearVista.getDtFechaIni().getDate();

        Date fechaFin
                = conCrearVista.getDtFechaFin().getDate();

        if (fechaInicio == null || fechaFin == null) {
            conCrearVista.getTxtSubAuto().setText("");
            actualizarResumenContrato();
            return;
        }

        LocalDate inicio = fechaInicio.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate fin = fechaFin.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        long dias = ChronoUnit.DAYS.between(inicio, fin);

        if (dias <= 0) {
            conCrearVista.getTxtSubAuto().setText("");
            actualizarResumenContrato();
            return;
        }

        double subtotalAuto
                = dias * autoSeleccionado.getPrecioDia();

        conCrearVista.getTxtSubAuto().setText(
                String.format("%.2f", subtotalAuto)
        );

        actualizarResumenContrato();
    }

    private void actualizarResumenContrato(){
        double subtotalAuto = obtenerValorCampo(
                conCrearVista.getTxtSubAuto().getText()
        );

        double subtotalServicios = obtenerValorCampo(
                conCrearVista.getTxtResServicios().getText()
        );

        double subtotal = subtotalAuto + subtotalServicios;
        double iva = subtotal * 0.15;
        double total = subtotal + iva;

        conCrearVista.getTxtSubtotal().setText(
                String.format("%.2f", subtotal)
        );

        conCrearVista.getTxtResIva().setText(
                String.format("%.2f", iva)
        );

        conCrearVista.getTxtResTotal().setText(
                String.format("%.2f", total)
        );
    }

    private void crearContrato(){
        if (reservaSeleccionada == null) {
            conCrearVista.mostrarMensajes(
                    "Seleccione una reserva"
            );
            return;
        }

        Date fechaInicioDate
                = conCrearVista.getDtFechaIni().getDate();

        Date fechaFinDate
                = conCrearVista.getDtFechaFin().getDate();

        if (fechaInicioDate == null || fechaFinDate == null) {
            conCrearVista.mostrarMensajes(
                    "Seleccione las fechas del contrato"
            );
            return;
        }

        LocalDate fechaInicio = fechaInicioDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate fechaFin = fechaFinDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        if (!fechaFin.isAfter(fechaInicio)) {
            conCrearVista.mostrarMensajes(
                    "La fecha final debe ser posterior a la fecha inicial"
            );
            return;
        }

        double subtotalAuto = obtenerValorCampo(
                conCrearVista.getTxtSubAuto().getText()
        );

        double subtotalServicios = obtenerValorCampo(
                conCrearVista.getTxtResServicios().getText()
        );

        double iva = obtenerValorCampo(
                conCrearVista.getTxtResIva().getText()
        );

        double total = obtenerValorCampo(
                conCrearVista.getTxtResTotal().getText()
        );

        if (subtotalAuto <= 0) {
            conCrearVista.mostrarMensajes(
                    "No se pudo calcular el subtotal del auto"
            );
            return;
        }

        Cliente cliente = new Cliente();

        cliente.setCliCedula(
                reservaSeleccionada.getCedulaCliente()
        );

        Auto auto = new Auto();

        auto.setAutMatricula(
                reservaSeleccionada.getMatricula()
        );

        Reserva reserva = new Reserva(
                reservaSeleccionada.getCodigo()
        );

        Usuario usuario
                = LoginControlador.getUsuarioAutenticado();

        if (usuario == null) {
            conCrearVista.mostrarMensajes(
                    "No se pudo obtener el usuario autenticado"
            );
            return;
        }

        Contrato contrato = new Contrato(
                fechaInicio,
                fechaFin,
                subtotalAuto,
                subtotalServicios,
                iva,
                total,
                cliente,
                auto,
                usuario,
                reserva
        );

        boolean creado = daoContrato.crearContrato(
                contrato,
                detallesServicios
        );

        if (creado) {
            conCrearVista.mostrarMensajes(
                    "Contrato creado correctamente"
            );

            limpiarContrato();
        } else {
            conCrearVista.mostrarMensajes(
                    "Error al crear el contrato"
            );
        }
    }

    private double obtenerValorCampo(String texto){
        if (texto == null || texto.trim().isEmpty()) {
            return 0;
        }

        return Double.parseDouble(
                texto.trim().replace(",", ".")
        );
    }

    private void limpiarContrato(){
        conCrearVista.getTxtBusqueda().setText("");
        conCrearVista.getTxtCliente().setText("");
        conCrearVista.getTxtResCliente().setText("");

        conCrearVista.getTxtAuto().setText("");
        conCrearVista.getTxtMatricula().setText("");
        conCrearVista.getTxtResAuto().setText("");

        conCrearVista.getTxtPrecioUnitario().setText("");

        conCrearVista.getTxtSubAuto().setText("");
        conCrearVista.getTxtResServicios().setText("");
        conCrearVista.getTxtSubtotal().setText("");
        conCrearVista.getTxtResIva().setText("");
        conCrearVista.getTxtResTotal().setText("");

        conCrearVista.getCbxReservas().removeAllItems();

        detallesServicios.clear();

        conCrearVista.cargarDetallesServicios(
                detallesServicios
        );

        reservasCliente = null;
        reservaSeleccionada = null;
        autoSeleccionado = null;
        servicioSeleccionado = null;

        conCrearVista.getDtFechaIni().setDate(new Date());
        conCrearVista.getDtFechaFin().setDate(null);

        conCrearVista.getTxtBusqueda().requestFocus();
    }
    
    private void buscarContrato(){
        String codigoTexto = conListarVista.getTxtBusqueda().getText().trim();

        if (codigoTexto.isEmpty()) {
            conListarVista.mostrarMensajes("Ingrese el código de la reserva");
            return;
        }

        if (!codigoTexto.matches("\\d+")) {
            conListarVista.mostrarMensajes("El código debe ser numérico");
            return;
        }

        int codigoReserva = Integer.parseInt(codigoTexto);

        contratosListados = daoContrato.buscarContratosPorReserva(codigoReserva);

        if (contratosListados == null || contratosListados.isEmpty()) {
            conListarVista.mostrarMensajes("No se encontró un contrato para esa reserva");
            conListarVista.limpiarTablas();
            return;
        }

        conListarVista.cargarContratos(contratosListados);
    }
    
    private void listarContratos(){
        contratosListados = daoContrato.listarContratos();

        if (contratosListados == null || contratosListados.isEmpty()) {
            conListarVista.mostrarMensajes("No existen contratos registrados");
            conListarVista.limpiarTablas();
            return;
        }

        conListarVista.cargarContratos(contratosListados);
    }
    
    private void seleccionarContratoListado(){
        int fila = conListarVista.getTblContrato().getSelectedRow();

        if (fila < 0 || contratosListados == null || fila >= contratosListados.size()) {
            return;
        }

        ContratoDTO contratoSeleccionado = contratosListados.get(fila);

        List<DetalleContratoDTO> detalles = daoContrato.listarDetallesContrato(
                contratoSeleccionado.getCodigoContrato()
        );

        conListarVista.cargarDetalles(detalles);
    }
    
    private void limpiarListado(){
        contratosListados = null;
        conListarVista.limpiarCampos();
    }
    
    
}