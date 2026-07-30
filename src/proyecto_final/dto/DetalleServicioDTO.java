package proyecto_final.dto;

public class DetalleServicioDTO {

    private int codigoServicio;
    private String nombreServicio;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    private double iva;
    private double total;

    public DetalleServicioDTO(int codigoServicio, String nombreServicio, int cantidad,
            double precioUnitario, double subtotal, double iva, double total) {

        this.codigoServicio = codigoServicio;
        this.nombreServicio = nombreServicio;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public int getCodigoServicio() {
        return codigoServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getIva() {
        return iva;
    }

    public double getTotal() {
        return total;
    }
}