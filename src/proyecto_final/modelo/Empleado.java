package proyecto_final.modelo;

public class Empleado {
    private String empCedula;
    private String empNombre;
    private String empApellido;
    private String empDireccion;
    private String empTelefono;
    private String empCorreo;
    private String empTipoPersonal;
    private String empCargo;
    private Usuario empUsuario;

    public Empleado(String empCedula, String empNombre, String empApellido, String empDireccion, String empTelefono, 
                    String empCorreo, String empTipoPersonal, String empCargo) {
        this.empCedula = empCedula;
        this.empNombre = empNombre;
        this.empApellido = empApellido;
        this.empDireccion = empDireccion;
        this.empTelefono = empTelefono;
        this.empCorreo = empCorreo;
        this.empTipoPersonal = empTipoPersonal;
        this.empCargo = empCargo;
        this.empUsuario = null;
    }

    public String getEmpCedula() {
        return empCedula;
    }

    public void setEmpCedula(String empCedula) {
        this.empCedula = empCedula;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpApellido() {
        return empApellido;
    }

    public void setEmpApellido(String empApellido) {
        this.empApellido = empApellido;
    }

    public String getEmpDireccion() {
        return empDireccion;
    }

    public void setEmpDireccion(String empDireccion) {
        this.empDireccion = empDireccion;
    }

    public String getEmpTelefono() {
        return empTelefono;
    }

    public void setEmpTelefono(String empTelefono) {
        this.empTelefono = empTelefono;
    }

    public String getEmpCorreo() {
        return empCorreo;
    }

    public void setEmpCorreo(String empCorreo) {
        this.empCorreo = empCorreo;
    }

    public String getEmpTipoPersonal() {
        return empTipoPersonal;
    }

    public void setEmpTipoPersonal(String empTipoPersonal) {
        this.empTipoPersonal = empTipoPersonal;
    }

    public String getEmpCargo() {
        return empCargo;
    }

    public void setEmpCargo(String empCargo) {
        this.empCargo = empCargo;
    }

    public Usuario getEmpUsuario() {
        return empUsuario;
    }

    public void setEmpUsuario(Usuario empUsuario) {
        this.empUsuario = empUsuario;
    }
    
    @Override
    public String toString() {
        return "Cedula: " + empCedula 
                + ", Nombres: " + empNombre
                + ", Apellidos: " + empApellido 
                + ", Direccion: " + empDireccion 
                + ", Telefono: " + empTelefono 
                + ", Correo: " + empCorreo
                + ", Tipo Personal: " + empTipoPersonal
                + ", Cargo: " + empCargo;
    }
}