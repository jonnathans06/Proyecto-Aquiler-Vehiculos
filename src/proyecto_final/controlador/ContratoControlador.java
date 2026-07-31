package proyecto_final.controlador;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
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
import proyecto_final.vista.contratos.ConActualizarVista;
import proyecto_final.vista.contratos.ConCrearVista;
import proyecto_final.vista.contratos.ConEliminarVista;
import proyecto_final.vista.contratos.ConListarVista;

public class ContratoControlador {

    private ConCrearVista conCrearVista;
    private ConListarVista conListarVista;
    private ConActualizarVista conActualizarVista;
    private ConEliminarVista conEliminarVista;

    private DaoCliente daoCliente;
    private DaoReserva daoReserva;
    private DaoServicio daoServicio;
    private DaoAuto daoAuto;
    private DaoContrato daoContrato;

    private List<ContratoDTO> contratosListados;

    private List<Servicio> servicios;
    private Servicio servicioSeleccionado;
    private Servicio servicioSeleccionadoActualizar;

    private List<ReservaDTO> reservasCliente;
    private ReservaDTO reservaSeleccionada;

    private List<DetalleServicioDTO> detallesServicios = new ArrayList<>();
    private List<DetalleServicioDTO> detallesServiciosActualizar = new ArrayList<>();

    private AutoDTO autoSeleccionado;
    private ContratoDTO contratoActualizar;
    
    private ContratoDTO contratoEliminar;   

    public ContratoControlador(ConCrearVista conCrearVista, ConListarVista conListarVista, ConActualizarVista conActualizarVista, ConEliminarVista conEliminarVista, DaoCliente daoCliente, DaoReserva daoReserva, DaoServicio daoServicio, DaoAuto daoAuto, DaoContrato daoContrato) {
        this.conCrearVista = conCrearVista;
        this.conListarVista = conListarVista;
        this.conActualizarVista = conActualizarVista;
        this.conEliminarVista = conEliminarVista;
        this.daoCliente = daoCliente;
        this.daoReserva = daoReserva;
        this.daoServicio = daoServicio;
        this.daoAuto = daoAuto;
        this.daoContrato = daoContrato;

        configurarAcciones();
        cargarServicios();
    }

    private void configurarAcciones() {
        conCrearVista.getBtnBuscar().addActionListener(e -> buscarClienteContrato());
        conCrearVista.getBtnSeleccionar().addActionListener(e -> seleccionarReserva());
        conCrearVista.getCbxServicios().addActionListener(e -> seleccionarServicio());
        conCrearVista.getBtnAgregarServicio().addActionListener(e -> agregarServicio());
        conCrearVista.getBtnEliminarServicios().addActionListener(e -> eliminarServicio());
        conCrearVista.getBtnConfirmar().addActionListener(e -> crearContrato());
        conCrearVista.getDtFechaFin().getDateEditor().addPropertyChangeListener("date", e -> actualizarSubtotalAuto());

        conListarVista.getBtnBuscar().addActionListener(e -> buscarContrato());
        conListarVista.getBtnListar().addActionListener(e -> listarContratos());
        conListarVista.getBtnLimpiar().addActionListener(e -> limpiarListado());

        conListarVista.getTblContrato().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarContratoListado();
            }
        });

        conActualizarVista.getBtnBuscar().addActionListener(e -> buscarContratoActualizar());
        conActualizarVista.getCbxServicios().addActionListener(e -> seleccionarServicioActualizar());
        conActualizarVista.getBtnAgregarServicio().addActionListener(e -> agregarServicioActualizar());
        conActualizarVista.getBtnEliminarServicios().addActionListener(e -> eliminarServicioActualizar());
        conActualizarVista.getBtnConfirmar().addActionListener(e -> confirmarActualizacionContrato());
        
        conEliminarVista.getBtnBuscar().addActionListener(e -> buscarContratoEliminar());
        conEliminarVista.getBtnLimpiar().addActionListener(e -> limpiarEliminarContrato());
        conEliminarVista.getBtnEliminar().addActionListener(e -> cancelarContrato());

        conEliminarVista.getTblContrato().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarContratoEliminar();
            }
        });
    }

    private void buscarClienteContrato() {
        String cedula = conCrearVista.getTxtBusqueda().getText().trim();

        if (cedula.isEmpty()) {
            conCrearVista.mostrarMensajes("Ingrese la cédula del cliente");
            return;
        }

        Cliente cliente = daoCliente.buscarClientePorCedula(cedula);

        if (cliente == null) {
            conCrearVista.mostrarMensajes("Cliente no encontrado");
            return;
        }

        reservasCliente = daoReserva.buscarReservasActivasCliente(cedula);

        if (reservasCliente == null || reservasCliente.isEmpty()) {
            conCrearVista.mostrarMensajes("El cliente no tiene reservas activas");
            conCrearVista.getCbxReservas().removeAllItems();
            return;
        }

        String nombreCliente = cliente.getCliNombre() + " " + cliente.getCliApellido();

        conCrearVista.getTxtCliente().setText(nombreCliente);
        conCrearVista.getTxtResCliente().setText(nombreCliente);
        conCrearVista.cargarReservas(reservasCliente);
    }

    private void seleccionarReserva() {
        if (reservasCliente == null || reservasCliente.isEmpty()) {
            conCrearVista.mostrarMensajes("Primero busque las reservas del cliente");
            return;
        }

        int indice = conCrearVista.getCbxReservas().getSelectedIndex();

        if (indice < 0 || indice >= reservasCliente.size()) {
            conCrearVista.mostrarMensajes("Seleccione una reserva");
            return;
        }

        reservaSeleccionada = reservasCliente.get(indice);
        autoSeleccionado = daoAuto.buscarAutoPorPlaca(reservaSeleccionada.getMatricula());

        if (autoSeleccionado == null) {
            conCrearVista.mostrarMensajes("No se pudo obtener el auto");
            return;
        }

        conCrearVista.getTxtAuto().setText(reservaSeleccionada.getAuto());
        conCrearVista.getTxtMatricula().setText(reservaSeleccionada.getMatricula());
        conCrearVista.getTxtResAuto().setText(reservaSeleccionada.getAuto());

        actualizarSubtotalAuto();
    }

    private void cargarServicios() {
        servicios = daoServicio.listarServicios();

        if (servicios == null || servicios.isEmpty()) {
            conCrearVista.mostrarMensajes("No existen servicios registrados");
            return;
        }

        conCrearVista.cargarServicios(servicios);
        conActualizarVista.cargarComboServicios(servicios);
    }

    private void seleccionarServicio() {
        if (servicios == null || servicios.isEmpty()) {
            return;
        }

        int indice = conCrearVista.getCbxServicios().getSelectedIndex();

        if (indice < 0 || indice >= servicios.size()) {
            return;
        }

        servicioSeleccionado = servicios.get(indice);
        conCrearVista.getTxtPrecioUnitario().setText(String.format("%.2f", servicioSeleccionado.getSerPrecioUnitario()));
    }

    private void seleccionarServicioActualizar() {
        if (servicios == null || servicios.isEmpty()) {
            return;
        }

        int indice = conActualizarVista.getCbxServicios().getSelectedIndex();

        if (indice < 0 || indice >= servicios.size()) {
            return;
        }

        servicioSeleccionadoActualizar = servicios.get(indice);
        conActualizarVista.getTxtPrecioUnitario().setText(String.format("%.2f", servicioSeleccionadoActualizar.getSerPrecioUnitario()));
    }

    private void agregarServicio() {
        if (servicioSeleccionado == null) {
            conCrearVista.mostrarMensajes("Seleccione un servicio");
            return;
        }

        Object cantidadSeleccionada = conCrearVista.getCbxCantidad().getSelectedItem();

        if (cantidadSeleccionada == null) {
            conCrearVista.mostrarMensajes("Seleccione una cantidad");
            return;
        }

        for (DetalleServicioDTO detalle : detallesServicios) {
            if (detalle.getCodigoServicio() == servicioSeleccionado.getSerCodigo()) {
                conCrearVista.mostrarMensajes("El servicio ya fue agregado");
                return;
            }
        }

        int cantidad = Integer.parseInt(cantidadSeleccionada.toString());
        double precioUnitario = servicioSeleccionado.getSerPrecioUnitario();
        double subtotal = cantidad * precioUnitario;
        double iva = subtotal * 0.15;
        double total = subtotal + iva;

        DetalleServicioDTO detalle = new DetalleServicioDTO(servicioSeleccionado.getSerCodigo(), servicioSeleccionado.getSerNombre(), cantidad, precioUnitario, subtotal, iva, total);

        detallesServicios.add(detalle);
        conCrearVista.cargarDetallesServicios(detallesServicios);
        actualizarSubtotalServicios();
    }

    private void eliminarServicio() {
        int filaVista = conCrearVista.getTblServicios().getSelectedRow();

        if (filaVista < 0) {
            conCrearVista.mostrarMensajes("Seleccione un servicio de la tabla");
            return;
        }

        int filaModelo = conCrearVista.getTblServicios().convertRowIndexToModel(filaVista);

        if (filaModelo < 0 || filaModelo >= detallesServicios.size()) {
            return;
        }

        detallesServicios.remove(filaModelo);
        conCrearVista.cargarDetallesServicios(detallesServicios);
        actualizarSubtotalServicios();
    }

    private void agregarServicioActualizar() {
        if (contratoActualizar == null) {
            conActualizarVista.mostrarMensajes("Primero busque un contrato");
            return;
        }

        if (servicioSeleccionadoActualizar == null) {
            conActualizarVista.mostrarMensajes("Seleccione un servicio");
            return;
        }

        Object cantidadSeleccionada = conActualizarVista.getCbxCantidad().getSelectedItem();

        if (cantidadSeleccionada == null) {
            conActualizarVista.mostrarMensajes("Seleccione una cantidad");
            return;
        }

        for (DetalleServicioDTO detalle : detallesServiciosActualizar) {
            if (detalle.getCodigoServicio() == servicioSeleccionadoActualizar.getSerCodigo()) {
                conActualizarVista.mostrarMensajes("El servicio ya fue agregado");
                return;
            }
        }

        int cantidad;

        try {
            cantidad = Integer.parseInt(cantidadSeleccionada.toString());
        } catch (NumberFormatException e) {
            conActualizarVista.mostrarMensajes("La cantidad seleccionada no es válida");
            return;
        }

        if (cantidad <= 0) {
            conActualizarVista.mostrarMensajes("La cantidad debe ser mayor que cero");
            return;
        }

        double precioUnitario = servicioSeleccionadoActualizar.getSerPrecioUnitario();
        double subtotal = cantidad * precioUnitario;
        double iva = subtotal * 0.15;
        double total = subtotal + iva;

        DetalleServicioDTO detalle = new DetalleServicioDTO(servicioSeleccionadoActualizar.getSerCodigo(), servicioSeleccionadoActualizar.getSerNombre(), cantidad, precioUnitario, subtotal, iva, total);

        detallesServiciosActualizar.add(detalle);
        conActualizarVista.cargarDetallesServicios(detallesServiciosActualizar);
        actualizarResumenActualizar();
    }

    private void eliminarServicioActualizar() {
        if (contratoActualizar == null) {
            conActualizarVista.mostrarMensajes("Primero busque un contrato");
            return;
        }

        int filaVista = conActualizarVista.getTblServicios().getSelectedRow();

        if (filaVista < 0) {
            conActualizarVista.mostrarMensajes("Seleccione un servicio de la tabla");
            return;
        }

        int filaModelo = conActualizarVista.getTblServicios().convertRowIndexToModel(filaVista);

        if (filaModelo < 0 || filaModelo >= detallesServiciosActualizar.size()) {
            return;
        }

        detallesServiciosActualizar.remove(filaModelo);
        conActualizarVista.cargarDetallesServicios(detallesServiciosActualizar);
        actualizarResumenActualizar();
    }

    private void actualizarSubtotalServicios() {
        double subtotalServicios = 0;

        for (DetalleServicioDTO detalle : detallesServicios) {
            subtotalServicios += detalle.getSubtotal();
        }

        conCrearVista.getTxtResServicios().setText(String.format("%.2f", subtotalServicios));
        actualizarResumenContrato();
    }

    private void actualizarSubtotalAuto() {
        if (autoSeleccionado == null) {
            return;
        }

        Date fechaInicio = conCrearVista.getDtFechaIni().getDate();
        Date fechaFin = conCrearVista.getDtFechaFin().getDate();

        if (fechaInicio == null || fechaFin == null) {
            conCrearVista.getTxtSubAuto().setText("");
            actualizarResumenContrato();
            return;
        }

        LocalDate inicio = fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fin = fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long dias = ChronoUnit.DAYS.between(inicio, fin);

        if (dias <= 0) {
            conCrearVista.getTxtSubAuto().setText("");
            actualizarResumenContrato();
            return;
        }

        double subtotalAuto = dias * autoSeleccionado.getPrecioDia();

        conCrearVista.getTxtSubAuto().setText(String.format("%.2f", subtotalAuto));
        actualizarResumenContrato();
    }

    private void actualizarResumenContrato() {
        double subtotalAuto = obtenerValorCampo(conCrearVista.getTxtSubAuto().getText());
        double subtotalServicios = obtenerValorCampo(conCrearVista.getTxtResServicios().getText());
        double subtotal = subtotalAuto + subtotalServicios;
        double iva = subtotal * 0.15;
        double total = subtotal + iva;

        conCrearVista.getTxtSubtotal().setText(String.format("%.2f", subtotal));
        conCrearVista.getTxtResIva().setText(String.format("%.2f", iva));
        conCrearVista.getTxtResTotal().setText(String.format("%.2f", total));
    }

    private void actualizarResumenActualizar() {
        double subtotalAuto = obtenerValorCampo(conActualizarVista.getTxtSubAuto().getText());
        double subtotalServicios = 0;

        for (DetalleServicioDTO detalle : detallesServiciosActualizar) {
            subtotalServicios += detalle.getSubtotal();
        }

        double subtotal = subtotalAuto + subtotalServicios;
        double iva = subtotal * 0.15;
        double total = subtotal + iva;

        conActualizarVista.getTxtResServicios().setText(String.format("%.2f", subtotalServicios));
        conActualizarVista.getTxtSubtotal().setText(String.format("%.2f", subtotal));
        conActualizarVista.getTxtResIva().setText(String.format("%.2f", iva));
        conActualizarVista.getTxtResTotal().setText(String.format("%.2f", total));
    }

    private void crearContrato() {
        if (reservaSeleccionada == null) {
            conCrearVista.mostrarMensajes("Seleccione una reserva");
            return;
        }

        Date fechaInicioDate = conCrearVista.getDtFechaIni().getDate();
        Date fechaFinDate = conCrearVista.getDtFechaFin().getDate();

        if (fechaInicioDate == null || fechaFinDate == null) {
            conCrearVista.mostrarMensajes("Seleccione las fechas del contrato");
            return;
        }

        LocalDate fechaInicio = fechaInicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaFin = fechaFinDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (!fechaFin.isAfter(fechaInicio)) {
            conCrearVista.mostrarMensajes("La fecha final debe ser posterior a la fecha inicial");
            return;
        }

        double subtotalAuto = obtenerValorCampo(conCrearVista.getTxtSubAuto().getText());
        double subtotalServicios = obtenerValorCampo(conCrearVista.getTxtResServicios().getText());
        double iva = obtenerValorCampo(conCrearVista.getTxtResIva().getText());
        double total = obtenerValorCampo(conCrearVista.getTxtResTotal().getText());

        if (subtotalAuto <= 0) {
            conCrearVista.mostrarMensajes("No se pudo calcular el subtotal del auto");
            return;
        }

        Cliente cliente = new Cliente();
        cliente.setCliCedula(reservaSeleccionada.getCedulaCliente());

        Auto auto = new Auto();
        auto.setAutMatricula(reservaSeleccionada.getMatricula());

        Reserva reserva = new Reserva(reservaSeleccionada.getCodigo());
        Usuario usuario = LoginControlador.getUsuarioAutenticado();

        if (usuario == null) {
            conCrearVista.mostrarMensajes("No se pudo obtener el usuario autenticado");
            return;
        }

        Contrato contrato = new Contrato(fechaInicio, fechaFin, subtotalAuto, subtotalServicios, iva, total, cliente, auto, usuario, reserva);
        boolean creado = daoContrato.crearContrato(contrato, detallesServicios);

        if (creado) {
            conCrearVista.mostrarMensajes("Contrato creado correctamente");
            limpiarContrato();
        } else {
            conCrearVista.mostrarMensajes("Error al crear el contrato");
        }
    }

    private double obtenerValorCampo(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return 0;
        }

        try {
            return Double.parseDouble(texto.trim().replace(",", "."));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void limpiarContrato() {
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
        conCrearVista.cargarDetallesServicios(detallesServicios);

        reservasCliente = null;
        reservaSeleccionada = null;
        autoSeleccionado = null;
        servicioSeleccionado = null;

        conCrearVista.getDtFechaIni().setDate(new Date());
        conCrearVista.getDtFechaFin().setDate(null);
        conCrearVista.getTxtBusqueda().requestFocus();
    }

    private void buscarContrato() {
        String codigoTexto = conListarVista.getTxtBusqueda().getText().trim();

        if (codigoTexto.isEmpty()) {
            conListarVista.mostrarMensajes("Ingrese el código del contrato");
            return;
        }

        if (!codigoTexto.matches("\\d+")) {
            conListarVista.mostrarMensajes("El código del contrato debe ser numérico");
            return;
        }

        int codigoContrato = Integer.parseInt(codigoTexto);
        ContratoDTO contrato = daoContrato.buscarContratoPorCodigo(codigoContrato);

        if (contrato == null) {
            conListarVista.mostrarMensajes("No se encontró el contrato");
            conListarVista.limpiarTablas();
            contratosListados = null;
            return;
        }

        contratosListados = new ArrayList<>();
        contratosListados.add(contrato);
        conListarVista.cargarContratos(contratosListados);
    }

    private void listarContratos() {
        contratosListados = daoContrato.listarContratos();

        if (contratosListados == null || contratosListados.isEmpty()) {
            conListarVista.mostrarMensajes("No existen contratos registrados");
            conListarVista.limpiarTablas();
            return;
        }

        conListarVista.cargarContratos(contratosListados);
    }

    private void seleccionarContratoListado() {
        int filaVista = conListarVista.getTblContrato().getSelectedRow();

        if (filaVista < 0 || contratosListados == null) {
            return;
        }

        int filaModelo = conListarVista.getTblContrato().convertRowIndexToModel(filaVista);

        if (filaModelo < 0 || filaModelo >= contratosListados.size()) {
            return;
        }

        ContratoDTO contratoSeleccionado = contratosListados.get(filaModelo);
        List<DetalleContratoDTO> detalles = daoContrato.listarDetallesContrato(contratoSeleccionado.getCodigoContrato());

        conListarVista.cargarDetalles(detalles);
    }

    private void limpiarListado() {
        contratosListados = null;
        conListarVista.limpiarCampos();
    }

    private void buscarContratoActualizar() {
        String codigoTexto = conActualizarVista.getTxtBusqueda().getText().trim();

        if (codigoTexto.isEmpty()) {
            conActualizarVista.mostrarMensajes("Ingrese el código del contrato");
            return;
        }

        if (!codigoTexto.matches("\\d+")) {
            conActualizarVista.mostrarMensajes("El código del contrato debe ser numérico");
            return;
        }

        int codigoContrato = Integer.parseInt(codigoTexto);
        ContratoDTO contrato = daoContrato.buscarContratoPorCodigo(codigoContrato);

        if (contrato == null) {
            conActualizarVista.mostrarMensajes("No se encontró el contrato");
            contratoActualizar = null;
            detallesServiciosActualizar.clear();
            conActualizarVista.cargarDetallesServicios(detallesServiciosActualizar);
            return;
        }

        contratoActualizar = contrato;

        conActualizarVista.getTxtCliente().setText(contrato.getCliente());

        if (contrato.getCodigoReserva() == 0) {
            conActualizarVista.getTxtReserva().setText("Sin reserva");
        } else {
            conActualizarVista.getTxtReserva().setText(String.valueOf(contrato.getCodigoReserva()));
        }

        conActualizarVista.getTxtAuto().setText(contrato.getVehiculo());
        conActualizarVista.getTxtMatricula().setText(contrato.getMatricula());
        conActualizarVista.getTxtResAuto().setText(contrato.getVehiculo());
        conActualizarVista.getTxtResCliente().setText(contrato.getCliente());

        Date fechaInicio = Date.from(contrato.getFechaInicio().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFin = Date.from(contrato.getFechaFin().atStartOfDay(ZoneId.systemDefault()).toInstant());

        conActualizarVista.getDtFechaIni().setDate(fechaInicio);
        conActualizarVista.getDtFechaFin().setDate(fechaFin);
        conActualizarVista.getTxtSubAuto().setText(String.format("%.2f", contrato.getSubtotalAuto()));
        conActualizarVista.getTxtResServicios().setText(String.format("%.2f", contrato.getSubtotalServicios()));
        conActualizarVista.getTxtSubtotal().setText(String.format("%.2f", contrato.getSubtotalTotal()));
        conActualizarVista.getTxtResIva().setText(String.format("%.2f", contrato.getIva()));
        conActualizarVista.getTxtResTotal().setText(String.format("%.2f", contrato.getTotal()));

        List<DetalleContratoDTO> detalles = daoContrato.listarDetallesContrato(codigoContrato);

        detallesServiciosActualizar.clear();

        if (detalles != null) {
            for (DetalleContratoDTO detalle : detalles) {
                detallesServiciosActualizar.add(new DetalleServicioDTO(
                        detalle.getCodigoServicio(),
                        detalle.getServicio(),
                        detalle.getCantidad(),
                        detalle.getPrecioUnitario(),
                        detalle.getSubtotal(),
                        detalle.getIva(),
                        detalle.getTotal()
                ));
            }
        }

        conActualizarVista.cargarDetallesServicios(detallesServiciosActualizar);
    }
    
    private void confirmarActualizacionContrato() {
        if (contratoActualizar == null) {
            conActualizarVista.mostrarMensajes("Primero busque un contrato");
            return;
        }

        Date fechaInicioDate = conActualizarVista.getDtFechaIni().getDate();
        Date fechaFinDate = conActualizarVista.getDtFechaFin().getDate();

        if (fechaInicioDate == null || fechaFinDate == null) {
            conActualizarVista.mostrarMensajes("Seleccione las fechas del contrato");
            return;
        }

        LocalDate fechaInicio = fechaInicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaFin = fechaFinDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (!fechaFin.isAfter(fechaInicio)) {
            conActualizarVista.mostrarMensajes("La fecha final debe ser posterior a la fecha inicial");
            return;
        }

        double subtotalAuto = obtenerValorCampo(conActualizarVista.getTxtSubAuto().getText());
        double subtotalServicios = obtenerValorCampo(conActualizarVista.getTxtResServicios().getText());
        double iva = obtenerValorCampo(conActualizarVista.getTxtResIva().getText());
        double total = obtenerValorCampo(conActualizarVista.getTxtResTotal().getText());

        if (subtotalAuto <= 0) {
            conActualizarVista.mostrarMensajes("El subtotal del auto no es válido");
            return;
        }

        if (subtotalServicios < 0 || iva < 0 || total <= 0) {
            conActualizarVista.mostrarMensajes("Los valores del contrato no son válidos");
            return;
        }

        boolean actualizado = daoContrato.actualizarContrato(
                contratoActualizar.getCodigoContrato(),
                fechaInicio,
                fechaFin,
                subtotalAuto,
                subtotalServicios,
                iva,
                total,
                detallesServiciosActualizar
        );

        if (actualizado) {
            conActualizarVista.mostrarMensajes("Contrato actualizado correctamente");
            limpiarContratoActualizar();
        } else {
            conActualizarVista.mostrarMensajes("No se pudo actualizar el contrato");
        }
    }
    
    private void limpiarContratoActualizar() {
        conActualizarVista.getTxtBusqueda().setText("");
        conActualizarVista.getTxtCliente().setText("");
        conActualizarVista.getTxtReserva().setText("");
        conActualizarVista.getTxtAuto().setText("");
        conActualizarVista.getTxtMatricula().setText("");
        conActualizarVista.getTxtPrecioUnitario().setText("");
        conActualizarVista.getTxtResAuto().setText("");
        conActualizarVista.getTxtResCliente().setText("");
        conActualizarVista.getTxtSubAuto().setText("");
        conActualizarVista.getTxtResServicios().setText("");
        conActualizarVista.getTxtSubtotal().setText("");
        conActualizarVista.getTxtResIva().setText("");
        conActualizarVista.getTxtResTotal().setText("");

        conActualizarVista.getDtFechaIni().setDate(null);
        conActualizarVista.getDtFechaFin().setDate(null);

        detallesServiciosActualizar.clear();
        conActualizarVista.cargarDetallesServicios(detallesServiciosActualizar);

        contratoActualizar = null;
        servicioSeleccionadoActualizar = null;

        conActualizarVista.getTxtBusqueda().requestFocus();
    }
    
    private void buscarContratoEliminar() {
        String codigoTexto = conEliminarVista.getTxtBusqueda().getText().trim();

        if (codigoTexto.isEmpty()) {
            conEliminarVista.mostrarMensajes("Ingrese el código del contrato");
            return;
        }

        if (!codigoTexto.matches("\\d+")) {
            conEliminarVista.mostrarMensajes("El código del contrato debe ser numérico");
            return;
        }

        int codigoContrato = Integer.parseInt(codigoTexto);
        ContratoDTO contrato = daoContrato.buscarContratoPorCodigo(codigoContrato);

        if (contrato == null) {
            conEliminarVista.mostrarMensajes("No se encontró el contrato");
            conEliminarVista.limpiarTablas();
            contratoEliminar = null;
            return;
        }

        contratoEliminar = contrato;

        List<ContratoDTO> contratos = new ArrayList<>();
        contratos.add(contrato);

        conEliminarVista.cargarContratos(contratos);

        List<DetalleContratoDTO> detalles = daoContrato.listarDetallesContrato(codigoContrato);
        conEliminarVista.cargarDetalles(detalles);

        conEliminarVista.getTblContrato().setRowSelectionInterval(0, 0);
    }
    
    private void seleccionarContratoEliminar() {
        int fila = conEliminarVista.getTblContrato().getSelectedRow();

        if (fila < 0 || contratoEliminar == null) {
            return;
        }

        List<DetalleContratoDTO> detalles = daoContrato.listarDetallesContrato(
                contratoEliminar.getCodigoContrato()
        );

        conEliminarVista.cargarDetalles(detalles);
    }
    
    private void limpiarEliminarContrato() {
        contratoEliminar = null;
        conEliminarVista.limpiarCampos();
    }
    
    private void cancelarContrato() {
        if (contratoEliminar == null) {
            conEliminarVista.mostrarMensajes("Primero busque un contrato");
            return;
        }

        if (!contratoEliminar.getEstado().equalsIgnoreCase("ACTIVO")) {
            conEliminarVista.mostrarMensajes("El contrato ya se encuentra inactivo");
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(
                conEliminarVista,
                "¿Está seguro de cancelar el contrato?",
                "Confirmar cancelación",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }

        boolean cancelado = daoContrato.cancelarContrato(
                contratoEliminar.getCodigoContrato(),
                contratoEliminar.getMatricula()
        );

        if (cancelado) {
            conEliminarVista.mostrarMensajes("Contrato cancelado correctamente");
            contratoEliminar = null;
            conEliminarVista.limpiarCampos();
        } else {
            conEliminarVista.mostrarMensajes("No se pudo cancelar el contrato");
        }
    }
}