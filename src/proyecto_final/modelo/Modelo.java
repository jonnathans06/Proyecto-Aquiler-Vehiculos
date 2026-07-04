package proyecto_final.modelo;

public class Modelo {
    private int modCodigo;
    private String modNombre;
    private Marca modMarca;

    // Constructor completo adaptado a la tabla ALQ_MODELOS
    public Modelo(int modCodigo, String modNombre, Marca modMarca) {
        this.modCodigo = modCodigo;
        this.modNombre = modNombre;
        this.modMarca = modMarca;
    }

    // Getters y Setters
    public int getModCodigo() {
        return modCodigo;
    }

    public void setModCodigo(int modCodigo) {
        this.modCodigo = modCodigo;
    }

    public String getModNombre() {
        return modNombre;
    }

    public void setModNombre(String modNombre) {
        this.modNombre = modNombre;
    }

    public Marca getModMarca() {
        return modMarca;
    }

    public void setModMarca(Marca modMarca) {
        this.modMarca = modMarca;
    }

    @Override
    public String toString() {
        return "Codigo: " + modCodigo + ", Modelo: " + modNombre + ", Marca: " + modMarca.getMarNombre();
    }
}