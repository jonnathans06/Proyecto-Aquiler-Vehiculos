package proyecto_final.modelo;

import java.time.LocalDateTime;

public class Reserva {

    private int resCodigo;
    private LocalDateTime resFechaHoraInicio;
    private LocalDateTime resFechaHoraFin;
    private Cliente resCliente;
    private Auto resAuto;
    private String resUsuario;
    private String resEstado;

    public Reserva(int resCodigo, LocalDateTime resFechaHoraInicio, LocalDateTime resFechaHoraFin, Cliente resCliente, Auto resAuto, String resUsuario, String resEstado) {
        this.resCodigo = resCodigo;
        this.resFechaHoraInicio = resFechaHoraInicio;
        this.resFechaHoraFin = resFechaHoraFin;
        this.resCliente = resCliente;
        this.resAuto = resAuto;
        this.resUsuario = resUsuario;
        this.resEstado = resEstado;
    }

    public Reserva(LocalDateTime resFechaHoraInicio, LocalDateTime resFechaHoraFin, Cliente resCliente, Auto resAuto, String resUsuario) {
        this.resFechaHoraInicio = resFechaHoraInicio;
        this.resFechaHoraFin = resFechaHoraFin;
        this.resCliente = resCliente;
        this.resAuto = resAuto;
        this.resUsuario = resUsuario;
        this.resEstado = "ACTIVA";
    }

    public int getResCodigo() {
        return resCodigo;
    }

    public void setResCodigo(int resCodigo) {
        this.resCodigo = resCodigo;
    }

    public LocalDateTime getResFechaHoraInicio() {
        return resFechaHoraInicio;
    }

    public void setResFechaHoraInicio(LocalDateTime resFechaHoraInicio) {
        this.resFechaHoraInicio = resFechaHoraInicio;
    }

    public LocalDateTime getResFechaHoraFin() {
        return resFechaHoraFin;
    }

    public void setResFechaHoraFin(LocalDateTime resFechaHoraFin) {
        this.resFechaHoraFin = resFechaHoraFin;
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

    public String getResUsuario() {
        return resUsuario;
    }

    public void setResUsuario(String resUsuario) {
        this.resUsuario = resUsuario;
    }

    public String getResEstado() {
        return resEstado;
    }

    public void setResEstado(String resEstado) {
        this.resEstado = resEstado;
    }
}