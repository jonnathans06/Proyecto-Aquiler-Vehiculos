package proyecto_final.modelo;

public class Usuario {
    private String usuUsername;
    private String usuPassword;
    private Empleado usuEmpleado;

    public Usuario(String usuUsername, String usuPassword, Empleado usuEmpleado) {
        this.usuUsername = usuUsername;
        this.usuPassword = usuPassword;
        this.usuEmpleado = usuEmpleado;
        this.usuEmpleado.setEmpUsuario(null);
    }
    
    public Usuario(String usuUsername, String usuPassword) {
        this.usuUsername = usuUsername;
        this.usuPassword = usuPassword;
    }

    public String getUsuUsername() {
        return usuUsername;
    }

    public void setUsuUsername(String usuUsername) {
        this.usuUsername = usuUsername;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public Empleado getUsuEmpleado() {
        return usuEmpleado;
    }

    public void setUsuEmpleado(Empleado usuEmpleado) {
        this.usuEmpleado = usuEmpleado;
    }
    
    public String mostrarEmpleado(){
        return ("Nombre de usuario: " + this.getUsuUsername() + " Contrasenia: " + this.getUsuPassword());
    }

    @Override
    public String toString() {
        return "Empleado: " + usuEmpleado.getEmpNombre() + ", Username: " + usuUsername + ", Passwors: " + usuPassword;
    }
}