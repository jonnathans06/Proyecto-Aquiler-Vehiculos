package proyecto_final.vista.reservas;

import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_final.dao.DaoDatosTablas;
import proyecto_final.dto.AutoDTO;
import proyecto_final.modelo.Cliente;

public class ResCrearVista extends javax.swing.JInternalFrame {

    public ResCrearVista() {
        initComponents();
        setSize(1280, 730);
        setTitle("Crear Reserva");
        setVisible(true);
        cargarMarcaTipo();
        
        spHoraIni.setEditor(
            new javax.swing.JSpinner.DateEditor(spHoraIni, "HH:mm")
        );

        spHoraFin.setEditor(
            new javax.swing.JSpinner.DateEditor(spHoraFin, "HH:mm")
        );
        
        dtFechaIni.setDate(new Date());
        dtFechaIni.setEnabled(false);
    }
    
    public void mostrarMensajes(String m){
        JOptionPane.showMessageDialog(rootPane, m);
    }

    public JButton getBtnAgrCliente() {
        return btnAgrCliente;
    }

    public JButton getBtnBscCliente() {
        return btnBscCliente;
    }

    public JTextField getTxtApeCliente() {
        return txtApeCliente;
    }

    public JTextField getTxtBusqCliente() {
        return txtBusqCliente;
    }

    public JTextField getTxtNomCliente() {
        return txtNomCliente;
    }

    public JComboBox<String> getCbxTipo() {
        return cbxTipo;
    }

    public JTable getTblDatos() {
        return tblDatos;
    }
    
    public void cargarDatosCliente(Cliente c){
        txtNomCliente.setText(c.getCliNombre());
        txtApeCliente.setText(c.getCliApellido());
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

    public JTextField getTxtMatricula() {
        return txtMatricula;
    }

    public JTextField getTxtModelo() {
        return txtModelo;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public JDateChooser getDtFechaFin() {
        return dtFechaFin;
    }

    public JDateChooser getDtFechaIni() {
        return dtFechaIni;
    }

    public JSpinner getSpHoraFin() {
        return spHoraFin;
    }

    public JSpinner getSpHoraIni() {
        return spHoraIni;
    }

    public JButton getBtnConfirmar() {
        return btnConfirmar;
    }
    
    public void cargarMarcaTipo(){
        cbxTipo.removeAllItems();
        List<String> tipos = DaoDatosTablas.obtenerDatos("tipos_autos", "tip_nombre");
        
        for(String t : tipos){
            cbxTipo.addItem(t);
        }
    }
    
    public void mostrarDatosAuto(List<AutoDTO> autos) {
        DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.setNumRows(0);
        
        if (!autos.isEmpty()) {
            for(AutoDTO auto : autos){
                Object[] fila = {
                    auto.getMatricula(),
                    auto.getMarca(),
                    auto.getModelo(),
                    auto.getAnio(),
                    auto.getCapacidad(),
                    auto.getPrecioDia(),
                };
                modelo.addRow(fila);
            }
        }
        tblDatos.setModel(modelo);
    }
    private void seleccionarAuto() {
        int filaSeleccionada = tblDatos.getSelectedRow();

        if (filaSeleccionada == -1) {
            mostrarMensajes("Selecciona una fila");
            return;
        }

        String matricula = tblDatos.getValueAt(filaSeleccionada, 0).toString();
        String marca = tblDatos.getValueAt(filaSeleccionada, 1).toString();
        String modelo = tblDatos.getValueAt(filaSeleccionada, 2).toString();
        String anio = tblDatos.getValueAt(filaSeleccionada, 3).toString();
        String capacidad = tblDatos.getValueAt(filaSeleccionada, 4).toString();
        String precio = tblDatos.getValueAt(filaSeleccionada, 5).toString();
        
        txtMatricula.setText(matricula);
        txtMarca.setText(marca);
        txtModelo.setText(modelo);
        txtAnio.setText(anio);
        txtCapacidad.setText(capacidad);
        txtPrecio.setText(precio);
    }
    
    public void limpiarCampos() {
        txtBusqCliente.setText("");
        txtNomCliente.setText("");
        txtApeCliente.setText("");

        txtMatricula.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtAnio.setText("");
        txtCapacidad.setText("");
        txtPrecio.setText("");

        dtFechaIni.setDate(new Date());
        dtFechaFin.setDate(null);

        spHoraIni.setValue(new Date());
        spHoraFin.setValue(new Date());

        cbxTipo.setSelectedIndex(0);

        DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.setRowCount(0);

        txtBusqCliente.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        panelPrincipal = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        panelInferior = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtApeCliente = new javax.swing.JTextField();
        txtNomCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBusqCliente = new javax.swing.JTextField();
        btnBscCliente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnAgrCliente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        dtFechaIni = new com.toedter.calendar.JDateChooser();
        dtFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        spHoraIni = new javax.swing.JSpinner();
        spHoraFin = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setClosable(true);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        panelSuperior.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(81, 89, 108));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(81, 89, 108));
        jLabel1.setText("REGISTRAR RESERVA");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        panelInferior.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la reserva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(81, 89, 108))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(81, 89, 108));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(81, 89, 108));
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(81, 89, 108));
        jLabel5.setText("Apellido:");

        txtApeCliente.setEditable(false);
        txtApeCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtApeCliente.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtApeCliente.setForeground(new java.awt.Color(81, 89, 108));
        txtApeCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApeCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        txtNomCliente.setEditable(false);
        txtNomCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtNomCliente.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNomCliente.setForeground(new java.awt.Color(81, 89, 108));
        txtNomCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNomCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(81, 89, 108));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Buscar Cliente");

        txtBusqCliente.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtBusqCliente.setForeground(new java.awt.Color(81, 89, 108));
        txtBusqCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBusqCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));
        txtBusqCliente.addActionListener(this::txtBusqClienteActionPerformed);

        btnBscCliente.setBackground(new java.awt.Color(204, 204, 204));
        btnBscCliente.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnBscCliente.setForeground(new java.awt.Color(81, 89, 108));
        btnBscCliente.setText("Buscar");
        btnBscCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        jSeparator2.setForeground(new java.awt.Color(81, 89, 108));

        btnAgrCliente.setBackground(new java.awt.Color(81, 89, 108));
        btnAgrCliente.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnAgrCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnAgrCliente.setText("Agregar");
        btnAgrCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusqCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBscCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnAgrCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApeCliente))
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBusqCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBscCliente)
                    .addComponent(btnAgrCliente))
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtApeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrado de vehiculo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), new java.awt.Color(81, 89, 108))); // NOI18N

        cbxTipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbxTipo.setForeground(new java.awt.Color(81, 89, 108));
        cbxTipo.setMaximumRowCount(5);
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTipo.setBorder(null);

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(81, 89, 108));
        jLabel16.setText("Tipo:");

        tblDatos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblDatos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblDatos.setForeground(new java.awt.Color(81, 89, 108));
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Marca", "Modelo", "Año", "Capacidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDatos.setGridColor(new java.awt.Color(255, 255, 255));
        tblDatos.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resumen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(81, 89, 108))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(81, 89, 108));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(81, 89, 108));
        jLabel2.setText("Matricula:");

        txtMatricula.setEditable(false);
        txtMatricula.setBackground(new java.awt.Color(255, 255, 255));
        txtMatricula.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtMatricula.setForeground(new java.awt.Color(81, 89, 108));
        txtMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMatricula.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(81, 89, 108));
        jLabel3.setText("Marca:");

        txtMarca.setEditable(false);
        txtMarca.setBackground(new java.awt.Color(255, 255, 255));
        txtMarca.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(81, 89, 108));
        txtMarca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMarca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(81, 89, 108));
        jLabel6.setText("Modelo:");

        txtModelo.setEditable(false);
        txtModelo.setBackground(new java.awt.Color(255, 255, 255));
        txtModelo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(81, 89, 108));
        txtModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtModelo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(81, 89, 108));
        jLabel7.setText("Capacidad:");

        txtCapacidad.setEditable(false);
        txtCapacidad.setBackground(new java.awt.Color(255, 255, 255));
        txtCapacidad.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCapacidad.setForeground(new java.awt.Color(81, 89, 108));
        txtCapacidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCapacidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(81, 89, 108));
        jLabel10.setText("Precio:");

        txtPrecio.setEditable(false);
        txtPrecio.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecio.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(81, 89, 108));
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(81, 89, 108));
        jLabel11.setText("Año:");

        txtAnio.setEditable(false);
        txtAnio.setBackground(new java.awt.Color(255, 255, 255));
        txtAnio.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtAnio.setForeground(new java.awt.Color(81, 89, 108));
        txtAnio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAnio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(81, 89, 108));
        jLabel13.setText("Datos vehiculo Seleccionado");

        jSeparator3.setForeground(new java.awt.Color(81, 89, 108));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(81, 89, 108));
        jLabel14.setText("Datos Generales");

        jSeparator4.setForeground(new java.awt.Color(81, 89, 108));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(81, 89, 108));
        jLabel15.setText("Fecha Inicio:");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(81, 89, 108));
        jLabel17.setText("Fecha Fin:");

        dtFechaIni.setBackground(new java.awt.Color(255, 255, 255));
        dtFechaIni.setForeground(new java.awt.Color(81, 89, 108));
        dtFechaIni.setDateFormatString("dd/MM/yy");
        dtFechaIni.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        dtFechaFin.setBackground(new java.awt.Color(255, 255, 255));
        dtFechaFin.setForeground(new java.awt.Color(81, 89, 108));
        dtFechaFin.setDateFormatString("dd/MM/yy");
        dtFechaFin.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(81, 89, 108));
        jLabel8.setText("Hora:");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(81, 89, 108));
        jLabel18.setText("Hora:");

        spHoraIni.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        spHoraIni.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));

        spHoraFin.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        spHoraFin.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(dtFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(spHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(dtFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(spHoraIni, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(spHoraIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dtFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel17)
                        .addComponent(dtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(spHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrecio))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jSeparator4))
                        .addGap(56, 56, 56))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(3, 3, 3)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(81, 89, 108));
        jButton5.setText("Limpiar");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));

        btnConfirmar.setBackground(new java.awt.Color(81, 89, 108));
        btnConfirmar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(81, 89, 108), 1, true));
        btnConfirmar.addActionListener(this::btnConfirmarActionPerformed);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(768, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusqClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusqClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusqClienteActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        try {
            seleccionarAuto();
        } catch (NullPointerException e) {
            mostrarMensajes("Debe seleccionar un auto");
        }
    }//GEN-LAST:event_tblDatosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgrCliente;
    private javax.swing.JButton btnBscCliente;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cbxTipo;
    private com.toedter.calendar.JDateChooser dtFechaFin;
    private com.toedter.calendar.JDateChooser dtFechaIni;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JSpinner spHoraFin;
    private javax.swing.JSpinner spHoraIni;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtApeCliente;
    private javax.swing.JTextField txtBusqCliente;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNomCliente;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
