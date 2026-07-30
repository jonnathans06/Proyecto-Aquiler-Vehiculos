package proyecto_final.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Contrato {

    private int conCodigo;
    private LocalDate conFechaInicio;
    private LocalDate conFechaFin;
    private double conSubtotalAuto;
    private double conSubtotalServicios;
    private double conIva;
    private double conTotal;
    private Cliente conCliente;
    private Auto conAuto;
    private Usuario conUsuario;
    private Reserva conReserva;
    private String conEstado;

    public Contrato(int conCodigo, LocalDate conFechaInicio, LocalDate conFechaFin,
            double conSubtotalAuto, double conSubtotalServicios, double conIva,
            double conTotal, Cliente conCliente, Auto conAuto, Usuario conUsuario,
            Reserva conReserva, String conEstado) {

        this.conCodigo = conCodigo;
        this.conFechaInicio = conFechaInicio;
        this.conFechaFin = conFechaFin;
        this.conSubtotalAuto = conSubtotalAuto;
        this.conSubtotalServicios = conSubtotalServicios;
        this.conIva = conIva;
        this.conTotal = conTotal;
        this.conCliente = conCliente;
        this.conAuto = conAuto;
        this.conUsuario = conUsuario;
        this.conReserva = conReserva;
        this.conEstado = conEstado;
    }

    public Contrato(LocalDate conFechaInicio, LocalDate conFechaFin,
            double conSubtotalAuto, double conSubtotalServicios, double conIva,
            double conTotal, Cliente conCliente, Auto conAuto, Usuario conUsuario,
            Reserva conReserva) {

        this.conFechaInicio = conFechaInicio;
        this.conFechaFin = conFechaFin;
        this.conSubtotalAuto = conSubtotalAuto;
        this.conSubtotalServicios = conSubtotalServicios;
        this.conIva = conIva;
        this.conTotal = conTotal;
        this.conCliente = conCliente;
        this.conAuto = conAuto;
        this.conUsuario = conUsuario;
        this.conReserva = conReserva;
        this.conEstado = "ACTIVO";
    }

    public int getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(int conCodigo) {
        this.conCodigo = conCodigo;
    }

    public LocalDate getConFechaInicio() {
        return conFechaInicio;
    }

    public void setConFechaInicio(LocalDate conFechaInicio) {
        this.conFechaInicio = conFechaInicio;
    }

    public LocalDate getConFechaFin() {
        return conFechaFin;
    }

    public void setConFechaFin(LocalDate conFechaFin) {
        this.conFechaFin = conFechaFin;
    }

    public long getConDias() {
        if (conFechaInicio == null || conFechaFin == null) {
            return 0;
        }

        return ChronoUnit.DAYS.between(conFechaInicio, conFechaFin);
    }

    public double getConSubtotalAuto() {
        return conSubtotalAuto;
    }

    public void setConSubtotalAuto(double conSubtotalAuto) {
        this.conSubtotalAuto = conSubtotalAuto;
    }

    public double getConSubtotalServicios() {
        return conSubtotalServicios;
    }

    public void setConSubtotalServicios(double conSubtotalServicios) {
        this.conSubtotalServicios = conSubtotalServicios;
    }

    public double getConIva() {
        return conIva;
    }

    public void setConIva(double conIva) {
        this.conIva = conIva;
    }

    public double getConTotal() {
        return conTotal;
    }

    public void setConTotal(double conTotal) {
        this.conTotal = conTotal;
    }

    public Cliente getConCliente() {
        return conCliente;
    }

    public void setConCliente(Cliente conCliente) {
        this.conCliente = conCliente;
    }

    public Auto getConAuto() {
        return conAuto;
    }

    public void setConAuto(Auto conAuto) {
        this.conAuto = conAuto;
    }

    public Usuario getConUsuario() {
        return conUsuario;
    }

    public void setConUsuario(Usuario conUsuario) {
        this.conUsuario = conUsuario;
    }

    public Reserva getConReserva() {
        return conReserva;
    }

    public void setConReserva(Reserva conReserva) {
        this.conReserva = conReserva;
    }

    public String getConEstado() {
        return conEstado;
    }

    public void setConEstado(String conEstado) {
        this.conEstado = conEstado;
    }

    @Override
    public String toString() {
        return "Contrato N°: " + conCodigo
                + ", Días: " + getConDias()
                + ", Total: $" + conTotal
                + ", Cliente: " + conCliente.getCliNombre() + " "
                + conCliente.getCliApellido()
                + ", Auto: " + conAuto.getAutMatricula()
                + ", Estado: " + conEstado;
    }
}