package proyecto_final.dto;

public class DetalleContratoDTO {

    private int codigoDetalle;
    private int codigoServicio;
    private String servicio;
    private double precioUnitario;
    private int cantidad;
    private double iva;
    private double subtotal;
    private double total;

    public DetalleContratoDTO(int codigoDetalle, int codigoServicio, String servicio, double precioUnitario, int cantidad, double iva, double subtotal, double total) {
        this.codigoDetalle = codigoDetalle;
        this.codigoServicio = codigoServicio;
        this.servicio = servicio;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.iva = iva;
        this.subtotal = subtotal;
        this.total = total;
    }

    public int getCodigoDetalle() {
        return codigoDetalle;
    }

    public int getCodigoServicio() {
        return codigoServicio;
    }

    public String getServicio() {
        return servicio;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getIva() {
        return iva;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }
}