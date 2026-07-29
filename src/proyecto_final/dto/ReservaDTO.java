package proyecto_final.dto;

import java.time.LocalDateTime;

public class ReservaDTO {
    private int codigo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String cedulaCliente;
    private String cliente;
    private String auto;
    private String empleado;
    private String estado;

    public ReservaDTO(int codigo, LocalDateTime fechaInicio, LocalDateTime fechaFin, String cedulaCliente, String cliente, String auto, String empleado, String estado) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cedulaCliente = cedulaCliente;
        this.cliente = cliente;
        this.auto = auto;
        this.empleado = empleado;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public String getAuto() {
        return auto;
    }

    public String getEmpleado() {
        return empleado;
    }

    public String getEstado() {
        return estado;
    }
}