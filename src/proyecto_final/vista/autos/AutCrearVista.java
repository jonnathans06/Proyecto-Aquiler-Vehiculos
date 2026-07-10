package proyecto_final.vista.autos;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import proyecto_final.modelo.Marca;
import proyecto_final.modelo.Modelo;

public class AutCrearVista extends javax.swing.JInternalFrame {

    public AutCrearVista() {
        initComponents();
        setSize(1280, 730);
        setTitle("Registrar Auto");
        setVisible(true);
        cbxMarca.removeAllItems();
        cbxModelo.removeAllItems();
    }
    
    public void limpiar(){
        txtMatricula.setText("");
        txtPrecioDia.setText("");
        txtAnio.setText("");
    }
    
    public void mostrarMensaje(String m) {
        JOptionPane.showMessageDialog(rootPane, m);
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

    public JTextField getTxtAnio() {
        return txtAnio;
    }
    
    public JComboBox<String> getCbxModelo() {
        return cbxModelo;
    }

    public JComboBox<String> getCbxMarca() {
        return cbxMarca;
    }

    public JTextField getTxtMatricula() {
        return txtMatricula;
    }

    public JTextField getTxtCapacidad() {
        return txtCapacidad;
    }
    
    public JTextField getTxtPrecioDia() {
        return txtPrecioDia;
    }

    public JTextField getTxtTipo() {
        return txtTipo;
    }
    
    public void cargarMarca(List<Marca> marcas){
        cbxMarca.removeAllItems();
        for(Marca m : marcas) {
            cbxMarca.addItem(m.getMarNombre());
        }
    }
    
    public void cargarModelo(List<Modelo> modelos){
        cbxModelo.removeAllItems();
        for(Modelo md : modelos) {
            cbxModelo.addItem(md.getModNombre());
        }
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
        cbxMarca = new javax.swing.JComboBox<>();
        lblApellido1 = new javax.swing.JLabel();
        cbxModelo = new javax.swing.JComboBox<>();
        txtAnio = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtCapacidad = new javax.swing.JTextField();

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
        jLabel1.setText("Registo de Nuevo Auto");

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

        cbxMarca.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbxMarca.setForeground(new java.awt.Color(81, 89, 108));
        cbxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblApellido1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblApellido1.setForeground(new java.awt.Color(81, 89, 108));
        lblApellido1.setText("Año:");

        cbxModelo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbxModelo.setForeground(new java.awt.Color(81, 89, 108));
        cbxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtAnio.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtAnio.setForeground(new java.awt.Color(81, 89, 108));
        txtAnio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        txtTipo.setEditable(false);
        txtTipo.setBackground(new java.awt.Color(255, 255, 255));
        txtTipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtTipo.setForeground(new java.awt.Color(81, 89, 108));
        txtTipo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        txtCapacidad.setEditable(false);
        txtCapacidad.setBackground(new java.awt.Color(255, 255, 255));
        txtCapacidad.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCapacidad.setForeground(new java.awt.Color(81, 89, 108));
        txtCapacidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

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
                        .addGap(202, 202, 202)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelDatosLayout.createSequentialGroup()
                                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelDatosLayout.createSequentialGroup()
                                    .addComponent(lblApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelDatosLayout.createSequentialGroup()
                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                                .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(48, 48, 48)
                                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                                .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecioDia, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(195, 195, 195)))
                .addContainerGap())
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula)
                    .addComponent(cbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(lblNombre)
                    .addComponent(cbxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxMarca;
    private javax.swing.JComboBox<String> cbxModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtPrecioDia;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

}
