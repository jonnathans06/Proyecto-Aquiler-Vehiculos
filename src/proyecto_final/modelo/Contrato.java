package proyecto_final.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Contrato {
    private int conCodigo;
    private LocalDate conFechaInicio;
    private LocalDate conFechaFin;
    private int conDias;
    private double conSubtotalAuto;
    private double conSubtotalServicios;
    private double conIva;
    private double conTotal;
    private Cliente conCliente;
    private Auto conAuto;
    private Usuario conUsuario;
    private Reserva conReserva;

    public Contrato(int conCodigo, LocalDate conFechaInicio, LocalDate conFechaFin, int conDias,
            double conSubtotalAuto, double conSubtotalServicios, double conIva, double conTotal,
            Cliente conCliente, Auto conAuto, Usuario conUsuario, Reserva conReserva) {
        this.conCodigo = conCodigo;
        this.conFechaInicio = conFechaInicio;
        this.conFechaFin = conFechaFin;
        this.conDias = conDias;
        this.conSubtotalAuto = conSubtotalAuto;
        this.conSubtotalServicios = conSubtotalServicios;
        this.conIva = conIva;
        this.conTotal = conTotal;
        this.conCliente = conCliente;
        this.conUsuario = conUsuario;
        this.conAuto = conAuto;
        this.conReserva = conReserva;
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

    public int getConDias() {
        return conDias;
    }

    public double getConSubtotalAuto() {
        return conSubtotalAuto;
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

    public double getConTotal() {
        return conTotal;
    }

    public Cliente getConCliente() {
        return conCliente;
    }

    public void setConCliente(Cliente conCliente) {
        this.conCliente = conCliente;
    }

    public Usuario getConUsuario() {
        return conUsuario;
    }

    public void setConUsuario(Usuario conUsuario) {
        this.conUsuario = conUsuario;
    }

    public Auto getConAuto() {
        return conAuto;
    }

    public void setConAuto(Auto conAuto) {
        this.conAuto = conAuto;
    }

    @Override
    public String toString() {
        return "Contrato N°: " + conCodigo 
                + ", Dias: " + conDias 
                + ", Total: $" + conTotal 
                + ", Cliente: " + conCliente.getCliNombre() + " " + conCliente.getCliApellido()
                + ", Auto: " + conAuto.getAutMatricula();
    }
}