package proyecto_final.modelo;

public class Marca {
    private int marCodigo;
    private String marNombre;
    
    public Marca(int marCodigo, String marNombre) {
        this.marCodigo = marCodigo;
        this.marNombre = marNombre;
    }
    
    public int getMarCodigo() {
        return marCodigo;
    }

    public void setMarCodigo(int marCodigo) {
        this.marCodigo = marCodigo;
    }

    public String getMarNombre() {
        return marNombre;
    }

    public void setMarNombre(String marNombre) {
        this.marNombre = marNombre;
    }

    @Override
    public String toString() {
        return "Codigo: " + marCodigo + ", Nombre: " + marNombre;
    }
}