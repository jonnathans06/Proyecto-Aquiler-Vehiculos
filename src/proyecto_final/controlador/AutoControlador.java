package proyecto_final.controlador;

import java.util.List;
import proyecto_final.dao.interfaces.DaoMarca;
import proyecto_final.dao.interfaces.DaoModelo;
import proyecto_final.dao.interfaces.DaoTipoAuto;
import proyecto_final.modelo.Marca;
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

    public AutoControlador(AutCrearVista autoCrearVista, AutListarVista autoListarVista, AutActualizarVista autoActualizarVista, AutEliminarVista autoEliminarVista, DaoTipoAuto daoAuto,
                           DaoMarca daoMarca, DaoModelo daoModelo) {
        this.autoCrearVista = autoCrearVista;
        this.autoListarVista = autoListarVista;
        this.autoActualizarVista = autoActualizarVista;
        this.autoEliminarVista = autoEliminarVista;
        this.daoTipo = daoAuto;
        this.daoMarca = daoMarca;
        this.daoModelo = daoModelo;
        cargarDatosAutCrearVista();
    }
    
    //Acciones botones
    private void configurarAccionesBotones(){
        
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
    
    //Autos
    private void crearAuto(){
        
    }
}