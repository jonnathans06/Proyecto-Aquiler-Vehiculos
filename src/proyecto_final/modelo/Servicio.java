package proyecto_final.modelo;

public class Servicio {
    private int serCodigo;
    private String serNombre;
    private double serPrecioUnitario;

    public Servicio(int serCodigo, String serNombre, double serPrecioUnitario) {
        this.serCodigo = serCodigo;
        this.serNombre = serNombre;
        this.serPrecioUnitario = serPrecioUnitario;
    }

    public int getSerCodigo() {
        return serCodigo;
    }

    public void setSerCodigo(int serCodigo) {
        this.serCodigo = serCodigo;
    }

    public String getSerNombre() {
        return serNombre;
    }

    public void setSerNombre(String serNombre) {
        this.serNombre = serNombre;
    }

    public double getSerPrecioUnitario() {
        return serPrecioUnitario;
    }

    public void setSerPrecioUnitario(double serPrecioUnitario) {
        this.serPrecioUnitario = serPrecioUnitario;
    }

    @Override
    public String toString() {
        return "Codigo: " + serCodigo + ", Servicio: " + serNombre + ", Precio Unitario: $" + serPrecioUnitario;
    }
}