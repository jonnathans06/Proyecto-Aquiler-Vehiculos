package proyecto_final.modelo;

public class TipoAuto {
    private int tipCodigo;
    private String tipNombre;
    
    public TipoAuto(int tipCodigo, String tipNombre) {
        this.tipCodigo = tipCodigo;
        this.tipNombre = tipNombre;
    }
    
    public int getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(int tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getTipNombre() {
        return tipNombre;
    }

    public void setTipNombre(String tipNombre) {
        this.tipNombre = tipNombre;
    }

    @Override
    public String toString() {
        return "Codigo: " + tipCodigo + ", Tipo: " + tipNombre;
    }
}