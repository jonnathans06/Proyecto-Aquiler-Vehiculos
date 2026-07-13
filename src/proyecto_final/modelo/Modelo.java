package proyecto_final.modelo;

public class Modelo {
    private int modCodigo;
    private String modNombre;
    private int modMarca;
    private int tipAuto;
    private int modCapacidad;
    private double modPrecioDia;
    private String Estado;

    public Modelo(int modCodigo, String modNombre, int modMarca, int tipAuto, int modCapacidad, double modPrecioDia, String Estado) {
        this.modCodigo = modCodigo;
        this.modNombre = modNombre;
        this.modMarca = modMarca;
        this.tipAuto = tipAuto;
        this.modCapacidad = modCapacidad;
        this.modPrecioDia = modPrecioDia;
        this.Estado = Estado;
    }

    public int getModCodigo() {
        return modCodigo;
    }

    public String getModNombre() {
        return modNombre;
    }

    public int getModMarca() {
        return modMarca;
    }

    public int getTipAuto() {
        return tipAuto;
    }

    public int getModCapacidad() {
        return modCapacidad;
    }

    public double getModPrecioDia() {
        return modPrecioDia;
    }

    public String getEstado() {
        return Estado;
    }
}