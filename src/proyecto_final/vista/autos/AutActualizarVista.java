package proyecto_final.vista.autos;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import proyecto_final.dto.AutoDTO;

public class AutActualizarVista extends javax.swing.JInternalFrame {

    public AutActualizarVista() {
        initComponents();
        setSize(1280, 730);
        setTitle("Actualizar Auto");
        setVisible(true);
        cargarColores();
        cargarEstados();
    }
    
    public void limpiar(){
        txtMarca.setText("");
        txtModelo.setText("");
        txtTipo.setText("");
        txtAnio.setText("");
        txtMatricula.setText("");
        txtCapacidad.setText("");
        txtPrecioDia.setText("");
        txtKilometraje.setText("");
    }
    
    public void mostrarMensaje(String m) {
        JOptionPane.showMessageDialog(rootPane, m);
    }
    
    public void cargarColores() {
        cbxColor.removeAllItems();
        cbxColor.addItem("Blanco");
        cbxColor.addItem("Rojo");
        cbxColor.addItem("Negro");
        cbxColor.addItem("Azul");
        cbxColor.addItem("Gris");
    }

    public void cargarEstados(){
        cbxEstado.removeAllItems();
        cbxEstado.addItem("DISPONIBLE");
        cbxEstado.addItem("MANTENIMIENTO");
        cbxEstado.addItem("ALQUILADO");
        cbxEstado.addItem("DESACTIVADO");
    }
    
    public void cargarDatosAuto(AutoDTO auto){
        txtMarca.setText(auto.getMarca());
        txtModelo.setText(auto.getModelo());
        txtTipo.setText(auto.getTipo());
        txtAnio.setText(String.valueOf(auto.getAnio()));
        txtMatricula.setText(auto.getMatricula());
        txtCapacidad.setText(String.valueOf(auto.getCapacidad()));
        txtPrecioDia.setText(String.valueOf(auto.getPrecioDia()));
        txtKilometraje.setText(String.valueOf(auto.getKilometraje()));
        
        cbxColor.setSelectedItem(auto.getColor());
        cbxEstado.setSelectedItem(auto.getEstado());
    }
    
    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JComboBox<String> getCbxColor() {
        return cbxColor;
    }
    
    public JTextField getTxtAnio() {
        return txtAnio;
    }

    public JTextField getTxtCapacidad() {
        return txtCapacidad;
    }

    public JTextField getTxtMarca() {
        return txtMarca;
    }

    public JTextField getTxtModelo() {
        return txtModelo;
    }

    public JTextField getTxtTipo() {
        return txtTipo;
    }

    public JTextField getTxtMatricula() {
        return txtMatricula;
    }

    public JTextField getTxtPrecioDia() {
        return txtPrecioDia;
    }

    public JTextField getTxtKilometraje() {
        return txtKilometraje;
    }
    
    public JTextField getTxtBusqueda() {
        return txtBusqueda;
    }

    public JComboBox<String> getCbxEstado() {
        return cbxEstado;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        panelPrincipal = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        panelInferior = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelCentral = new javax.swing.JPanel();
        panelDatos = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblDireccion = new javax.swing.JLabel();
        txtPrecioDia = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtCapacidad = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        lblDireccion1 = new javax.swing.JLabel();
        cbxColor = new javax.swing.JComboBox<>();
        txtKilometraje = new javax.swing.JTextField();
        lblTelefono1 = new javax.swing.JLabel();
        lblDireccion2 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();

        jPasswordField1.setText("jPasswordField1");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setTitle("Crear Usuario");

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        panelTitulo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(81, 98, 108));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Actualizar Auto");

        jSeparator2.setForeground(new java.awt.Color(81, 89, 108));

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInferior.setBackground(new java.awt.Color(255, 255, 255));

        btnRegistrar.setBackground(new java.awt.Color(81, 89, 108));
        btnRegistrar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(204, 204, 204));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnLimpiar.setBackground(new java.awt.Color(204, 204, 204));
        btnLimpiar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                .addContainerGap(847, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelDatos.setBackground(new java.awt.Color(255, 255, 255));

        lblCedula.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblCedula.setForeground(new java.awt.Color(81, 89, 108));
        lblCedula.setText("Marca:");

        lblNombre.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(81, 89, 108));
        lblNombre.setText("Modelo:");

        lblApellido.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(81, 89, 108));
        lblApellido.setText("Tipo:");

        lblTelefono.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(81, 89, 108));
        lblTelefono.setText("Capacidad:");

        lblCorreo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(81, 89, 108));
        lblCorreo.setText("Matricula:");

        txtMatricula.setEditable(false);
        txtMatricula.setBackground(new java.awt.Color(255, 255, 255));
        txtMatricula.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtMatricula.setForeground(new java.awt.Color(81, 89, 108));
        txtMatricula.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        jSeparator1.setForeground(new java.awt.Color(81, 89, 108));

        lblDireccion.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(81, 89, 108));
        lblDireccion.setText("Precio por dia:");

        txtPrecioDia.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPrecioDia.setForeground(new java.awt.Color(81, 89, 108));
        txtPrecioDia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        lblApellido1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblApellido1.setForeground(new java.awt.Color(81, 89, 108));
        lblApellido1.setText("Año:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(81, 89, 108));
        jLabel2.setText("Buscar auto por matricula");

        txtBusqueda.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtBusqueda.setForeground(new java.awt.Color(81, 89, 108));
        txtBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        btnBuscar.setBackground(new java.awt.Color(81, 89, 108));
        btnBuscar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel2)
                .addGap(130, 130, 130)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(181, 181, 181))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(37, 37, 37))
        );

        txtCapacidad.setEditable(false);
        txtCapacidad.setBackground(new java.awt.Color(255, 255, 255));
        txtCapacidad.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCapacidad.setForeground(new java.awt.Color(81, 89, 108));
        txtCapacidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        txtMarca.setEditable(false);
        txtMarca.setBackground(new java.awt.Color(255, 255, 255));
        txtMarca.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(81, 89, 108));
        txtMarca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        txtModelo.setEditable(false);
        txtModelo.setBackground(new java.awt.Color(255, 255, 255));
        txtModelo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(81, 89, 108));
        txtModelo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        txtTipo.setEditable(false);
        txtTipo.setBackground(new java.awt.Color(255, 255, 255));
        txtTipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtTipo.setForeground(new java.awt.Color(81, 89, 108));
        txtTipo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        txtAnio.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtAnio.setForeground(new java.awt.Color(81, 89, 108));
        txtAnio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        lblDireccion1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblDireccion1.setForeground(new java.awt.Color(81, 89, 108));
        lblDireccion1.setText("Color:");

        cbxColor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbxColor.setForeground(new java.awt.Color(81, 89, 108));
        cbxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxColor.addActionListener(this::cbxColorActionPerformed);

        txtKilometraje.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtKilometraje.setForeground(new java.awt.Color(81, 89, 108));
        txtKilometraje.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        lblTelefono1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblTelefono1.setForeground(new java.awt.Color(81, 89, 108));
        lblTelefono1.setText("Kilometraje:");

        lblDireccion2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblDireccion2.setForeground(new java.awt.Color(81, 89, 108));
        lblDireccion2.setText("Estado:");

        cbxEstado.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbxEstado.setForeground(new java.awt.Color(81, 89, 108));
        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxEstado.addActionListener(this::cbxEstadoActionPerformed);

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jSeparator1))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblApellido1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(143, 143, 143))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(lblDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(139, 139, 139)))
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(lblDireccion2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                                .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(48, 48, 48)
                                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTelefono1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPrecioDia, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(txtKilometraje, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))))
                        .addGap(195, 195, 195))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCorreo)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCedula)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono1))
                .addGap(31, 31, 31)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDireccion2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(81, 81, 81))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        mostrarMensaje("Campos Limpiados");
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxColorActionPerformed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxColor;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccion1;
    private javax.swing.JLabel lblDireccion2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtKilometraje;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPrecioDia;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

}
