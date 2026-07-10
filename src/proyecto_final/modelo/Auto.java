package proyecto_final.modelo;

public class Auto {
    private String autMatricula;
    private int autAnio;
    private Modelo autModelo;
    private String autEstado;

    public Auto(String autMatricula, int autAnio, Modelo autModelo, String autEstado) {
        this.autMatricula = autMatricula;
        this.autAnio = autAnio;
        this.autModelo = autModelo;
        this.autEstado = autEstado;
    }
    
    public String getAutMatricula() {
        return autMatricula;
    }

    public void setAutMatricula(String autMatricula) {
        this.autMatricula = autMatricula;
    }

    public int getAutAnio() {
        return autAnio;
    }

    public void setAutAnio(int autAnio) {
        this.autAnio = autAnio;
    }

    public String getAutEstado() {
        return autEstado;
    }

    public void setAutEstado(String autEstado) {
        this.autEstado = autEstado;
    }

    public Modelo getAutModelo() {
        return autModelo;
    }

    public void setAutModelo(Modelo autModelo) {
        this.autModelo = autModelo;
    }

    @Override
    public String toString() {
        return "Matricula: " + autMatricula 
                + ", Año: " + autAnio 
                + ", Estado: " + autEstado 
                + ", Modelo: " + autModelo.getModNombre();
    }
}