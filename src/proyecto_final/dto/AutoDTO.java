package proyecto_final.dto;

public class AutoDTO {
    private String matricula;
    private String marca;
    private String modelo;
    private String tipo;
    private int anio;
    private int capacidad;
    private double precioDia;
    private String color;
    private int kilometraje;
    private String estado;
    
    public AutoDTO(String matricula, String marca, String modelo, String tipo, 
                   int anio, int capacidad, double precioDia, String color, int kilometraje, String estado) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.anio = anio;
        this.capacidad = capacidad;
        this.precioDia = precioDia;
        this.color = color;
        this.kilometraje = kilometraje;
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAnio() {
        return anio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public String getColor() {
        return color;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public String getEstado() {
        return estado;
    }
}