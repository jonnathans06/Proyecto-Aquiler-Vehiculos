package proyecto_final.modelo;

public class Auto {
    private String autMatricula;
    private int autAnio;
    private int autCapacidadPasajeros;
    private double autPrecioDia;
    private String autEstado;
    private Modelo autModelo;
    private TipoAuto autTipo;

    public Auto(String autMatricula, int autAnio, int autCapacidadPasajeros, double autPrecioDia, String autEstado, Modelo autModelo, TipoAuto autTipo) {
        this.autMatricula = autMatricula;
        this.autAnio = autAnio;
        this.autCapacidadPasajeros = autCapacidadPasajeros;
        this.autPrecioDia = autPrecioDia;
        this.autEstado = autEstado;
        this.autModelo = autModelo;
        this.autTipo = autTipo;
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

    public int getAutCapacidadPasajeros() {
        return autCapacidadPasajeros;
    }

    public void setAutCapacidadPasajeros(int autCapacidadPasajeros) {
        this.autCapacidadPasajeros = autCapacidadPasajeros;
    }

    public double getAutPrecioDia() {
        return autPrecioDia;
    }

    public void setAutPrecioDia(double autPrecioDia) {
        this.autPrecioDia = autPrecioDia;
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

    public TipoAuto getAutTipo() {
        return autTipo;
    }

    public void setAutTipo(TipoAuto autTipo) {
        this.autTipo = autTipo;
    }

    @Override
    public String toString() {
        return "Matricula: " + autMatricula 
                + ", Año: " + autAnio 
                + ", Capacidad: " + autCapacidadPasajeros + " pasajeros"
                + ", Precio/Dia: $" + autPrecioDia 
                + ", Estado: " + autEstado 
                + ", Modelo: " + autModelo.getModNombre() 
                + ", Tipo: " + autTipo.getTipNombre();
    }
}