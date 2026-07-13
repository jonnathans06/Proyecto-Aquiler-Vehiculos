package proyecto_final.modelo;

public class Auto {
    private String autMatricula;
    private String autColor;
    private int autKilometraje;
    private int autAnio;
    private int autModelo;
    private String autEstado;

    public Auto(String autMatricula, String autColor, int autKilometraje, int autAnio, int autModelo, String autEstado) {
        this.autMatricula = autMatricula;
        this.autColor = autColor;
        this.autKilometraje = autKilometraje;
        this.autAnio = autAnio;
        this.autModelo = autModelo;
        this.autEstado = autEstado;
    }

    public String getAutMatricula() {
        return autMatricula;
    }

    public String getAutColor() {
        return autColor;
    }

    public int getAutKilometraje() {
        return autKilometraje;
    }

    public int getAutAnio() {
        return autAnio;
    }

    public int getAutModelo() {
        return autModelo;
    }

    public String getAutEstado() {
        return autEstado;
    }
    
    @Override
    public String toString() {
        return "Matricula: " + autMatricula 
                + ", Año: " + autAnio 
                + ", Estado: " + autEstado 
                + ", Modelo: " + autModelo;
    }
}