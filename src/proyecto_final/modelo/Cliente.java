package proyecto_final.modelo;

public class Cliente {
    private String cliCedula;
    private String cliNombre;
    private String cliApellido;
    private String cliDireccion;
    private String cliTelefono;
    private String cliCorreo;
    private String cliEstado;
    
    public Cliente(String cliCedula, String cliNombre, String cliApellido, String cliDireccion, String cliTelefono, String cliCorreo) {
        this.cliCedula = cliCedula;
        this.cliNombre = cliNombre;
        this.cliApellido = cliApellido;
        this.cliDireccion = cliDireccion;
        this.cliTelefono = cliTelefono;
        this.cliCorreo = cliCorreo;
        this.cliEstado = "ACTIVO";
    }

    public String getCliCedula() {
        return cliCedula;
    }
    public void setCliCedula(String cliCedula) {
        this.cliCedula = cliCedula;
    }
    public String getCliNombre() {
        return cliNombre;
    }
    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }
    public String getCliApellido() {
        return cliApellido;
    }
    public void setCliApellido(String cliApellido) {
        this.cliApellido = cliApellido;
    }
    public String getCliDireccion() {
        return cliDireccion;
    }
    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }
    public String getCliTelefono() {
        return cliTelefono;
    }
    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }
    public String getCliCorreo() {
        return cliCorreo;
    }
    public void setCliCorreo(String cliCorreo) {
        this.cliCorreo = cliCorreo;
    }
    public String getCliEstado() {
        return cliEstado;
    }
    public void setCliEstado(String cliEstado) {
        this.cliEstado = cliEstado;
    }

    @Override
    public String toString() {
        return "Cedula: " + cliCedula
                + ", Nombre: " + cliNombre
                + ", Apellido: " + cliApellido
                + ", Direccion: " + cliDireccion
                + ", Telefono: " + cliTelefono
                + ", Correo: " + cliCorreo
                + ", Estado: " + cliEstado;
    }
}