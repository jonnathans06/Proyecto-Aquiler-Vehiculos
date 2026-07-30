package proyecto_final.dto;

import java.time.LocalDateTime;

public class ReservaDTO {
    private int codigo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String cedulaCliente;
    private String cliente;
    private String matricula;
    private String auto;
    private String empleado;
    private String estado;

    public ReservaDTO(int codigo, LocalDateTime fechaInicio, LocalDateTime fechaFin, String cedulaCliente, String cliente, String matricula, String auto, String empleado, String estado) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cedulaCliente = cedulaCliente;
        this.cliente = cliente;
        this.matricula = matricula;
        this.auto = auto;
        this.empleado = empleado;
        this.estado = estado;
    }
    
    public ReservaDTO(int codigo, LocalDateTime fechaInicio, LocalDateTime fechaFin, String cliente, String matricula,String empleado, String estado) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
        this.matricula = matricula;
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

    public String getMatricula() {
        return matricula;
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
    
    @Override
    public String toString() {
        return "Reserva " + codigo + " - " + auto + " - " + matricula;
    }
}