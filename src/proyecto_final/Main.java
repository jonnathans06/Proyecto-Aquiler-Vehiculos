package proyecto_final;

import proyecto_final.controlador.ClienteControlador;
import proyecto_final.controlador.EmpleadoControlador;
import proyecto_final.controlador.LoginControlador;
import proyecto_final.dao.DaoClienteImp;
import proyecto_final.dao.DaoEmpleadoImp;
import proyecto_final.dao.DaoUsuarioImp;
import proyecto_final.dao.interfaces.DaoCliente;
import proyecto_final.dao.interfaces.DaoEmpleado;
import proyecto_final.dao.interfaces.DaoUsuario;
import proyecto_final.vista.SistemaVista;
import proyecto_final.vista.autos.AutActualizarVista;
import proyecto_final.vista.autos.AutCrearVista;
import proyecto_final.vista.autos.AutEliminarVista;
import proyecto_final.vista.autos.AutListarVista;
import proyecto_final.vista.clientes.CliActualizarVista;
import proyecto_final.vista.clientes.CliCrearVista;
import proyecto_final.vista.clientes.CliEliminarVista;
import proyecto_final.vista.clientes.CliListarVista;
import proyecto_final.vista.contratos.ConCrearVista;
import proyecto_final.vista.contratos.ConListarVista;
import proyecto_final.vista.empleados.EmpActualizarVista;
import proyecto_final.vista.empleados.EmpCrearVista;
import proyecto_final.vista.empleados.EmpEliminarVista;
import proyecto_final.vista.empleados.EmpListarVista;
import proyecto_final.vista.login.LoginVista;
import proyecto_final.vista.reservas.ResActualizarVista;
import proyecto_final.vista.reservas.ResCrearVista;
import proyecto_final.vista.reservas.ResEliminarVista;
import proyecto_final.vista.reservas.ResListarVista;

public class Main {

    public static void main(String[] args) {
        //Vistas Empleados
        LoginVista loginVista = new LoginVista();
        EmpCrearVista empCrearVista = new EmpCrearVista();
        EmpListarVista empListarVista = new EmpListarVista();
        EmpActualizarVista empActVista = new EmpActualizarVista();
        EmpEliminarVista empEliVista = new EmpEliminarVista();
        
        //Vistas Clientes
        CliCrearVista cliCrearVista = new CliCrearVista();
        CliListarVista cliListarVista = new CliListarVista();
        CliActualizarVista cliActualizarVista = new CliActualizarVista();
        CliEliminarVista cliEliminarVista = new CliEliminarVista();
        
        //Vistas Autos
        AutCrearVista autCrearVista = new AutCrearVista();
        AutListarVista autListarVista = new AutListarVista();
        AutActualizarVista autActualizarVista = new AutActualizarVista();
        AutEliminarVista autEliminarVista = new AutEliminarVista();
        
        //Vistas Reservas
        ResCrearVista resCrearVista = new ResCrearVista();
        ResListarVista resListarVista = new ResListarVista();
        ResActualizarVista resActualizarVista = new ResActualizarVista();
        ResEliminarVista resEliminarVista = new ResEliminarVista();
        
        //Vistas Contratos
        ConCrearVista conCrearVista = new ConCrearVista();
        ConListarVista conListarVista = new ConListarVista();
        
        //Vista General
        SistemaVista principalVista = new SistemaVista(empCrearVista, empListarVista, empActVista, empEliVista, 
                                                       cliCrearVista, cliListarVista, cliActualizarVista, cliEliminarVista,
                                                       autCrearVista, autListarVista, autActualizarVista, autEliminarVista,
                                                       resCrearVista, resListarVista, resActualizarVista, resEliminarVista,
                                                       conCrearVista, conListarVista);
        
        // Daos
        DaoEmpleado daoEmpleado = new DaoEmpleadoImp();
        DaoUsuario daoUsuario = new DaoUsuarioImp();
        DaoCliente daoCliente = new DaoClienteImp();
        
        //Controladores
        LoginControlador loginControlador = new LoginControlador(daoUsuario, loginVista, principalVista);
        EmpleadoControlador empControlador = new EmpleadoControlador(empCrearVista, empListarVista, empActVista, empEliVista, daoEmpleado, daoUsuario);
        ClienteControlador cliControlador = new ClienteControlador(cliCrearVista, cliListarVista, cliActualizarVista, cliEliminarVista, daoCliente);
    }
    
}