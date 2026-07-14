package proyecto_final.controlador;

import proyecto_final.dao.interfaces.DaoAuto;
import proyecto_final.dao.interfaces.DaoMarca;
import proyecto_final.dao.interfaces.DaoModelo;
import proyecto_final.dao.interfaces.DaoTipoAuto;
import proyecto_final.dto.AutoDTO;
import proyecto_final.modelo.Auto;
import proyecto_final.modelo.Modelo;
import proyecto_final.modelo.TipoAuto;
import proyecto_final.vista.autos.AutActualizarVista;
import proyecto_final.vista.autos.AutCrearVista;
import proyecto_final.vista.autos.AutEliminarVista;
import proyecto_final.vista.autos.AutListarVista;

public class AutoControlador {
    private AutCrearVista autoCrearVista;
    private AutListarVista autoListarVista;
    private AutActualizarVista autoActualizarVista;
    private AutEliminarVista autoEliminarVista;
    private DaoTipoAuto daoTipo;
    private DaoMarca daoMarca;
    private DaoModelo daoModelo ;
    private DaoAuto daoAuto;
    private AutoDTO autoDTO;

    public AutoControlador(AutCrearVista autoCrearVista, AutListarVista autoListarVista, AutActualizarVista autoActualizarVista, AutEliminarVista autoEliminarVista, DaoTipoAuto daoTipo,
                           DaoMarca daoMarca, DaoModelo daoModelo, DaoAuto daoAuto) {
        this.autoCrearVista = autoCrearVista;
        this.autoListarVista = autoListarVista;
        this.autoActualizarVista = autoActualizarVista;
        this.autoEliminarVista = autoEliminarVista;
        this.daoTipo = daoTipo;
        this.daoMarca = daoMarca;
        this.daoModelo = daoModelo;
        this.daoAuto = daoAuto;
        cargarDatosAutCrearVista();
        configurarAccionesBotones();
    }
    
    //Acciones botones
    private void configurarAccionesBotones(){
        //Crear auto
        autoCrearVista.getBtnRegistrar().addActionListener((e) -> {
            crearAuto();
        });
        
        //Listar Todos
        autoListarVista.getBtnListar().addActionListener((e) -> {
            listarTodos();
        });
        
        //Buscar Listar
        autoListarVista.getBtnBuscar().addActionListener((e) -> {
            buscarAutoListar();
            autoDTO = null;
        });
        
        //Buscar Auto Actualizar
        autoActualizarVista.getBtnBuscar().addActionListener((e) -> {
            buscarAutoActualizar();
        });
        
        //Actualizar Auto
        autoActualizarVista.getBtnRegistrar().addActionListener((e) -> {
            actualizarAuto();
        });
        
        //Buscar Auto Eliminar
        autoEliminarVista.getBtnBuscar().addActionListener((e) -> {
            buscarAutoEliminar();
        });
        
        //Eliminar Auto
        autoEliminarVista.getBtnRegistrar().addActionListener((e) -> {
            eliminarAuto();
        });
    }
    
    //Cargar datos AutCrearVista
    private void cargarDatosAutCrearVista(){
        //Cargar Marcas
        autoCrearVista.cargarMarca(daoMarca.listarMarcas());

        //Cargar Modelos cuando cambia la marca
        autoCrearVista.getCbxMarca().addActionListener((e) -> {
            autoCrearVista.cargarModelo(daoModelo.buscarModelosPorMarca(autoCrearVista.getCbxMarca().getSelectedItem().toString()));
        });

        //Cargar tipo de auto cuando cambia el modelo
        autoCrearVista.getCbxModelo().addActionListener((e) -> {
            try {
                Modelo modelo = daoModelo.buscarModeloPorNombre(autoCrearVista.getCbxModelo().getSelectedItem().toString());
                
                if (modelo != null) {
                    TipoAuto tipoAuto = daoTipo.buscarPorCodigo(modelo.getTipAuto());
                    autoCrearVista.getTxtTipo().setText(tipoAuto.getTipNombre());
                    
                    //Cargar capacidad
                    int capacidad = 0;
                    switch(tipoAuto.getTipNombre()) {
                        case "Económico":
                            capacidad = 4;
                            break;
                        case "Compacto":
                            capacidad = 5;
                            break;
                        case "Sedán":
                            capacidad = 5;
                            break;
                        case "SUV":
                            capacidad = 7;
                            break;
                        case "Camioneta":
                            capacidad = 5;
                            break;
                        default:
                            capacidad = 0;
                    }
                    autoCrearVista.getTxtCapacidad().setText(String.valueOf(capacidad));
                }
            } catch (NullPointerException eNull) {
                autoCrearVista.getTxtTipo().setText("Error Inesperado");
            }
        });
    }
    
    //Crear Autos
    private void crearAuto(){
        boolean inserto = false;
        
        String matricula = autoCrearVista.getTxtMatricula().getText().trim().toUpperCase();
        String color = autoCrearVista.getCbxColor().getSelectedItem().toString();
        int kilometraje = Integer.valueOf(autoCrearVista.getTxtKilometraje().getText().trim());
        int anio = Integer.valueOf(autoCrearVista.getTxtAnio().getText().trim());
        int modelo = daoModelo.obtenerCodigo(autoCrearVista.getCbxModelo().getSelectedItem().toString());
        
        
        if (matricula.isEmpty() || color.isEmpty()) {
            autoCrearVista.mostrarMensaje("Datos no validos");
        } else if (matricula.length() != 7) {
            autoCrearVista.mostrarMensaje("Matricula no valida");
        } else if (anio < 1990 || anio > 2026) {
            autoCrearVista.mostrarMensaje("Año no valida");
        } else {
            inserto = daoAuto.crearAuto(new Auto(matricula, color, kilometraje, anio, modelo, "DISPONIBLE"));
        }
        
        if (inserto) {
            autoCrearVista.mostrarMensaje("Se Ingreso Correctamente el Auto");
            autoCrearVista.limpiar();
        } else {
            autoCrearVista.mostrarMensaje("Error al ingresar el auto");
        }   
    }
    
    //Listar todos
    private void listarTodos() {
        autoListarVista.mostrarDatosAuto(daoAuto.listarTodos());
    }
    
    //Buscar Auto Listar
    private void buscarAutoListar() {
        autoDTO = null;
        if (autoListarVista.getTxtBusqueda().getText().isEmpty()) {
            autoListarVista.mostrarMensajes("Debe colocar una placa para buscar");
            return;
        }
        
        if (autoDTO == null) {
            autoDTO = daoAuto.buscarAutoPorPlaca(autoListarVista.getTxtBusqueda().getText().toUpperCase().trim());
        }
        
        if (autoDTO != null) {
            autoListarVista.mostrarDatosAuto(autoDTO);
        } else {
            autoListarVista.mostrarMensajes("Error al encontrar el auto");
        }
    }
    
    //Buscar Auto Actualizar
    private void buscarAutoActualizar(){
        autoDTO = null;
        if (autoActualizarVista.getTxtBusqueda().getText().toUpperCase().trim().isEmpty()) {
            autoActualizarVista.mostrarMensaje("Debe colocar una placa para buscar");
            return;
        }
        
        if (autoDTO == null) {
            autoDTO = daoAuto.buscarAutoPorPlaca(autoActualizarVista.getTxtBusqueda().getText().toUpperCase().trim());
        }
        
        if (autoDTO != null) {
            autoActualizarVista.cargarDatosAuto(autoDTO);
        } else {
            autoListarVista.mostrarMensajes("Error al encontrar el auto");
        }
    }
    
    // Buscar Auto Eliminar
    private void buscarAutoEliminar(){
        autoDTO = null;
        if (autoEliminarVista.getTxtBusqueda().getText().toUpperCase().trim().isEmpty()) {
            autoEliminarVista.mostrarMensaje("Debe colocar una placa para buscar");
            return;
        }
        
        if (autoDTO == null) {
            autoDTO = daoAuto.buscarAutoPorPlaca(autoEliminarVista.getTxtBusqueda().getText().toUpperCase().trim());
        }
        
        if (autoDTO != null) {
            autoEliminarVista.mostrarDatosAuto(autoDTO);
        } else {
            autoEliminarVista.mostrarMensaje("Error al encontrar el auto");
        }
    }
    
    //Actualizar Auto
    private void actualizarAuto(){
        boolean actualizo = false;
        
        String matricula = autoActualizarVista.getTxtMatricula().getText().trim();
        String color = autoActualizarVista.getCbxColor().getSelectedItem().toString();
        int kilometraje = Integer.valueOf(autoActualizarVista.getTxtKilometraje().getText().trim());
        int anio = Integer.valueOf(autoActualizarVista.getTxtAnio().getText().trim());
        int modelo = daoModelo.obtenerCodigo(autoActualizarVista.getTxtModelo().getText().trim());
        String estado = autoActualizarVista.getCbxEstado().getSelectedItem().toString();
        
        if (color.equals(autoDTO.getColor()) && anio == autoDTO.getAnio() && kilometraje == autoDTO.getKilometraje() && estado.equals(autoDTO.getEstado())) {
            autoActualizarVista.mostrarMensaje("Debe hacer cambios para actualizar");
            return;
        }
        
        actualizo = daoAuto.actualizarAuto(new Auto(matricula, color, kilometraje, anio, modelo, estado));
        
        if (actualizo) {
            autoActualizarVista.mostrarMensaje("Se Actualizó Correctamente el Auto");
            autoActualizarVista.limpiar();
            autoDTO = null;
        } else {
            autoActualizarVista.mostrarMensaje("Error al Actualizar el Auto");
        }
    }
    
    //Eliminar Auto
    private void eliminarAuto() {
        String matricula = autoEliminarVista.getTxtMatricula().getText().trim();
        String color = autoEliminarVista.getTxtColor().getText().trim();
        int kilometraje = Integer.valueOf(autoEliminarVista.getTxtKilometraje().getText().trim());
        int anio = Integer.valueOf(autoEliminarVista.getTxtAnio().getText().trim());
        int modelo = daoModelo.obtenerCodigo(autoEliminarVista.getTxtModelo().getText().trim());
        String estado = autoEliminarVista.getTxtEstado().getText().trim();

        boolean eliminado = daoAuto.eliminarAuto(new Auto(matricula, color, kilometraje, anio, modelo, estado));

        if (eliminado) {
            autoEliminarVista.mostrarMensaje("Auto Desactivado Exitosamente");
            autoEliminarVista.limpiar();
        } else {
            autoEliminarVista.mostrarMensaje("Error al Desactivar Auto");
        }
    }
}