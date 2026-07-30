package proyecto_final.dto;

import java.time.LocalDate;

public class ContratoDTO {

    private int codigoContrato;
    private int codigoReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String vehiculo;
    private String matricula;
    private String cliente;
    private String usuario;
    private double subtotalAuto;
    private double subtotalServicios;
    private double subtotalTotal;
    private double iva;
    private double total;
    private String estado;

    public ContratoDTO(int codigoContrato, int codigoReserva, LocalDate fechaInicio,
            LocalDate fechaFin, String vehiculo, String matricula, String cliente,
            String usuario, double subtotalAuto, double subtotalServicios,
            double subtotalTotal, double iva, double total, String estado) {

        this.codigoContrato = codigoContrato;
        this.codigoReserva = codigoReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.vehiculo = vehiculo;
        this.matricula = matricula;
        this.cliente = cliente;
        this.usuario = usuario;
        this.subtotalAuto = subtotalAuto;
        this.subtotalServicios = subtotalServicios;
        this.subtotalTotal = subtotalTotal;
        this.iva = iva;
        this.total = total;
        this.estado = estado;
    }

    public int getCodigoContrato() {
        return codigoContrato;
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCliente() {
        return cliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public double getSubtotalAuto() {
        return subtotalAuto;
    }

    public double getSubtotalServicios() {
        return subtotalServicios;
    }

    public double getSubtotalTotal() {
        return subtotalTotal;
    }

    public double getIva() {
        return iva;
    }

    public double getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }
}