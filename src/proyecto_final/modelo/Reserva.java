package proyecto_final.modelo;

import java.time.LocalDate;

class Reserva {
    private int resCodigo;
    private LocalDate resFechaInicio;
    private LocalDate resFechaFin;
    private Cliente resCliente;
    private Auto resAuto;
    private Empleado resEmpleado;

    public Reserva(int resCodigo, LocalDate resFechaInicio, LocalDate resFechaFin, Cliente resCliente, Auto resAuto, Empleado resEmpleado) {
        this.resCodigo = resCodigo;
        this.resFechaInicio = resFechaInicio;
        this.resFechaFin = resFechaFin;
        this.resCliente = resCliente;
        this.resAuto = resAuto;
        this.resEmpleado = resEmpleado;
    }

    public int getResCodigo() {
        return resCodigo;
    }

    public void setResCodigo(int resCodigo) {
        this.resCodigo = resCodigo;
    }

    public LocalDate getResFechaInicio() {
        return resFechaInicio;
    }

    public void setResFechaInicio(LocalDate resFechaInicio) {
        this.resFechaInicio = resFechaInicio;
    }

    public LocalDate getResFechaFin() {
        return resFechaFin;
    }

    public void setResFechaFin(LocalDate resFechaFin) {
        this.resFechaFin = resFechaFin;
    }

    public Cliente getResCliente() {
        return resCliente;
    }

    public void setResCliente(Cliente resCliente) {
        this.resCliente = resCliente;
    }

    public Auto getResAuto() {
        return resAuto;
    }

    public void setResAuto(Auto resAuto) {
        this.resAuto = resAuto;
    }

    public Empleado getResEmpleado() {
        return resEmpleado;
    }

    public void setResEmpleado(Empleado resEmpleado) {
        this.resEmpleado = resEmpleado;
    }
}