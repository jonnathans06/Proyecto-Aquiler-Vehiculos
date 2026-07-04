package proyecto_final.vista;

import javax.swing.JMenuItem;
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
import proyecto_final.vista.reservas.ResActualizarVista;
import proyecto_final.vista.reservas.ResCrearVista;
import proyecto_final.vista.reservas.ResEliminarVista;
import proyecto_final.vista.reservas.ResListarVista;

public class SistemaVista extends javax.swing.JFrame {

    private EmpCrearVista empCrearVista;
    private EmpListarVista empListarVista;
    private EmpActualizarVista empActVista;
    private EmpEliminarVista empEliVista;
    
    private CliCrearVista cliCrearVista;
    private CliListarVista cliListarVista;
    private CliActualizarVista cliActualizarVista;
    private CliEliminarVista cliEliminarVista;
    
    private AutCrearVista autCrearVista;
    private AutListarVista autListarVista;
    private AutActualizarVista autActualizarVista;
    private AutEliminarVista autEliminarVista;
    
    private ResCrearVista resCrearVista;
    private ResListarVista resListarVista;
    private ResActualizarVista resActualizarVista;
    private ResEliminarVista resEliminarVista;
    
    private ConCrearVista conCrearVista;
    private ConListarVista conListarVista;

            
    public SistemaVista(EmpCrearVista empCrearVista, EmpListarVista empListarVista, EmpActualizarVista empActVista, EmpEliminarVista empEliVista,
                        CliCrearVista cliCrearVista, CliListarVista cliListarVista, CliActualizarVista cliActualizarVista, CliEliminarVista cliEliminarVista,
                        AutCrearVista autCrearVista, AutListarVista autListarVista, AutActualizarVista autActualizarVista, AutEliminarVista autEliminarVista,
                        ResCrearVista resCrearVista, ResListarVista resListarVista, ResActualizarVista resActualizarVista, ResEliminarVista resEliminarVista, 
                        ConCrearVista conCrearVista, ConListarVista conListarVista) {
        this.empCrearVista = empCrearVista;
        this.empListarVista = empListarVista;
        this.empActVista = empActVista;
        this.empEliVista = empEliVista;
        this.cliCrearVista = cliCrearVista;
        this.cliListarVista = cliListarVista;
        this.cliActualizarVista = cliActualizarVista;
        this.cliEliminarVista = cliEliminarVista;
        this.autCrearVista = autCrearVista;
        this.autListarVista = autListarVista;
        this.autActualizarVista = autActualizarVista;
        this.autEliminarVista = autEliminarVista;
        this.resCrearVista = resCrearVista;
        this.resListarVista = resListarVista;
        this.resActualizarVista = resActualizarVista;
        this.resEliminarVista = resEliminarVista;
        this.conCrearVista = conCrearVista;
        this.conListarVista = conListarVista;
        initComponents();
        setTitle("Rent-a-car Cuenca");
        setLocationRelativeTo(null);
        cargarItemMenuEmpleados();
        cargarItemMenuClientes();
        cargarItemMenuAutos();
        cargarItemMenuReservas();
        cargarItemMenuContratos();
        setResizable(false);
    }

    private void cargarItemMenuEmpleados(){
        //Crear Empleados
        empCrearMenuItem.addActionListener((e) -> {
            desktopPane.add(empCrearVista);
            empCrearVista.toFront();
            empCrearVista.setVisible(true);
        });
        
        //Listar Empleados
        empListarMenuItem.addActionListener((e) -> {
            desktopPane.add(empListarVista);
            empListarVista.toFront();
            empListarVista.setVisible(true);
        });
        
        //Actualizar Empleado
        empActualizarMenuItem.addActionListener((e) -> {
            desktopPane.add(empActVista);
            empActVista.toFront();
            empActVista.setVisible(true);
        });
        
        //Eliminar Empleado
        empEliminarMenuItem.addActionListener((e) -> {
            desktopPane.add(empEliVista);
            empEliVista.toFront();
            empEliVista.setVisible(true);
        });
    }
    
    private void cargarItemMenuClientes(){
        //Crear Clientes
        cliCrearitemMenu.addActionListener((e) -> {
            desktopPane.add(cliCrearVista);
            cliCrearVista.toFront();
            cliCrearVista.setVisible(true);
        });
        
        //Listar Clientes
        cliListarItemMenu.addActionListener((e) -> {
            desktopPane.add(cliListarVista);
            cliListarVista.toFront();
            cliListarVista.setVisible(true);
        });
        
        //Actualizar Clientes
        cliActualizarItemMenu.addActionListener((e) -> {
            desktopPane.add(cliActualizarVista);
            cliActualizarVista.toFront();
            cliActualizarVista.setVisible(true);
        });
        
        //Eliminar Clientes
        cliEliminarItemMenu.addActionListener((e) -> {
            desktopPane.add(cliEliminarVista);
            cliEliminarVista.toFront();
            cliEliminarVista.setVisible(true);
        });
    }
    
    private void cargarItemMenuAutos(){
        //Crear Autos
        autCrearItemMenu.addActionListener((e) -> {
            desktopPane.add(autCrearVista);
            autCrearVista.toFront();
            autCrearVista.setVisible(true);
        });
        
        //Listar Autos
        autListarItemMenu.addActionListener((e) -> {
            desktopPane.add(autListarVista);
            autListarVista.toFront();
            autListarVista.setVisible(true);
        });
        
        //Actualizar Autos
        autActualizarItemMenu.addActionListener((e) -> {
            desktopPane.add(autActualizarVista);
            autActualizarVista.toFront();
            autActualizarVista.setVisible(true);
        });
        
        //Eliminar Autos
        autEliminarItemMenu.addActionListener((e) -> {
            desktopPane.add(autEliminarVista);
            autEliminarVista.toFront();
            autEliminarVista.setVisible(true);
        });
    }
    
    private void cargarItemMenuReservas(){
        //Crear Reservas
        resCrearItemMenu.addActionListener((e) -> {
            desktopPane.add(resCrearVista);
            resCrearVista.toFront();
            resCrearVista.setVisible(true);
        });

        //Listar Reservas
        resListarItemMenu.addActionListener((e) -> {
            desktopPane.add(resListarVista);
            resListarVista.toFront();
            resListarVista.setVisible(true);
        });

        //Actualizar Reservas
        resActualizarItemMenu.addActionListener((e) -> {
            desktopPane.add(resActualizarVista);
            resActualizarVista.toFront();
            resActualizarVista.setVisible(true);
        });

        //Eliminar Reservas
        resEliminarItemMenu.addActionListener((e) -> {
            desktopPane.add(resEliminarVista);
            resEliminarVista.toFront();
            resEliminarVista.setVisible(true);
        });
    }
    
    private void cargarItemMenuContratos(){
        //Crear Reservas
        conCrearItemMenu.addActionListener((e) -> {
            desktopPane.add(conCrearVista);
            conCrearVista.toFront();
            conCrearVista.setVisible(true);
        });
        
        //Listar Reservas
        conListarItemMenu.addActionListener((e) -> {
            desktopPane.add(conListarVista);
            conListarVista.toFront();
            conListarVista.setVisible(true);
        });
    }

    public JMenuItem getCerrarSesionMenuItem() {
        return cerrarSesionMenuItem;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        lblPrincipal = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        empCrearMenuItem = new javax.swing.JMenuItem();
        empListarMenuItem = new javax.swing.JMenuItem();
        empActualizarMenuItem = new javax.swing.JMenuItem();
        empEliminarMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        cliCrearitemMenu = new javax.swing.JMenuItem();
        cliListarItemMenu = new javax.swing.JMenuItem();
        cliActualizarItemMenu = new javax.swing.JMenuItem();
        cliEliminarItemMenu = new javax.swing.JMenuItem();
        jAutos = new javax.swing.JMenu();
        autCrearItemMenu = new javax.swing.JMenuItem();
        autListarItemMenu = new javax.swing.JMenuItem();
        autActualizarItemMenu = new javax.swing.JMenuItem();
        autEliminarItemMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        resCrearItemMenu = new javax.swing.JMenuItem();
        resListarItemMenu = new javax.swing.JMenuItem();
        resActualizarItemMenu = new javax.swing.JMenuItem();
        resEliminarItemMenu = new javax.swing.JMenuItem();
        jmqnu2 = new javax.swing.JMenu();
        conCrearItemMenu = new javax.swing.JMenuItem();
        conListarItemMenu = new javax.swing.JMenuItem();
        cerrarSesionMenu = new javax.swing.JMenu();
        cerrarSesionMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_final/imagenes/Logo_empresa.png"))); // NOI18N
        desktopPane.add(lblPrincipal);
        lblPrincipal.setBounds(0, 0, 1280, 730);

        menuBar.setBorder(null);
        menuBar.setBorderPainted(false);

        fileMenu.setBorder(null);
        fileMenu.setForeground(new java.awt.Color(81, 89, 108));
        fileMenu.setMnemonic('f');
        fileMenu.setText("Empleados");

        empCrearMenuItem.setMnemonic('o');
        empCrearMenuItem.setText("Crear");
        empCrearMenuItem.addActionListener(this::empCrearMenuItemActionPerformed);
        fileMenu.add(empCrearMenuItem);

        empListarMenuItem.setMnemonic('s');
        empListarMenuItem.setText("Listar");
        fileMenu.add(empListarMenuItem);

        empActualizarMenuItem.setMnemonic('a');
        empActualizarMenuItem.setText("Actualizar");
        fileMenu.add(empActualizarMenuItem);

        empEliminarMenuItem.setMnemonic('x');
        empEliminarMenuItem.setText("Eliminar");
        empEliminarMenuItem.addActionListener(this::empEliminarMenuItemActionPerformed);
        fileMenu.add(empEliminarMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setForeground(new java.awt.Color(81, 89, 108));
        jMenu1.setText("Clientes");

        cliCrearitemMenu.setText("Crear");
        jMenu1.add(cliCrearitemMenu);

        cliListarItemMenu.setText("Listar");
        jMenu1.add(cliListarItemMenu);

        cliActualizarItemMenu.setText("Actualizar");
        jMenu1.add(cliActualizarItemMenu);

        cliEliminarItemMenu.setText("Eliminar");
        jMenu1.add(cliEliminarItemMenu);

        menuBar.add(jMenu1);

        jAutos.setForeground(new java.awt.Color(81, 89, 108));
        jAutos.setText("Autos");

        autCrearItemMenu.setText("Crear");
        jAutos.add(autCrearItemMenu);

        autListarItemMenu.setText("Listar");
        jAutos.add(autListarItemMenu);

        autActualizarItemMenu.setText("Actualizar");
        jAutos.add(autActualizarItemMenu);

        autEliminarItemMenu.setText("Eliminar");
        jAutos.add(autEliminarItemMenu);

        menuBar.add(jAutos);

        jMenu2.setForeground(new java.awt.Color(81, 89, 108));
        jMenu2.setText("Reservas");

        resCrearItemMenu.setText("Crear");
        jMenu2.add(resCrearItemMenu);

        resListarItemMenu.setText("Listar");
        jMenu2.add(resListarItemMenu);

        resActualizarItemMenu.setText("Actualizar");
        resActualizarItemMenu.addActionListener(this::resActualizarItemMenuActionPerformed);
        jMenu2.add(resActualizarItemMenu);

        resEliminarItemMenu.setText("Eliminar");
        jMenu2.add(resEliminarItemMenu);

        menuBar.add(jMenu2);

        jmqnu2.setForeground(new java.awt.Color(81, 89, 108));
        jmqnu2.setText("Contratos");

        conCrearItemMenu.setText("Crear");
        jmqnu2.add(conCrearItemMenu);

        conListarItemMenu.setText("Listar");
        jmqnu2.add(conListarItemMenu);

        menuBar.add(jmqnu2);

        cerrarSesionMenu.setForeground(new java.awt.Color(81, 89, 108));
        cerrarSesionMenu.setText("Salir");
        cerrarSesionMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarSesionMenuMouseClicked(evt);
            }
        });

        cerrarSesionMenuItem.setText("Cerrar Sesión");
        cerrarSesionMenuItem.addActionListener(this::cerrarSesionMenuItemActionPerformed);
        cerrarSesionMenu.add(cerrarSesionMenuItem);

        menuBar.add(cerrarSesionMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void empEliminarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empEliminarMenuItemActionPerformed

    }//GEN-LAST:event_empEliminarMenuItemActionPerformed

    private void empCrearMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empCrearMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empCrearMenuItemActionPerformed

    private void cerrarSesionMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionMenuMouseClicked
        
    }//GEN-LAST:event_cerrarSesionMenuMouseClicked

    private void cerrarSesionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarSesionMenuItemActionPerformed

    private void resActualizarItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resActualizarItemMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resActualizarItemMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem autActualizarItemMenu;
    private javax.swing.JMenuItem autCrearItemMenu;
    private javax.swing.JMenuItem autEliminarItemMenu;
    private javax.swing.JMenuItem autListarItemMenu;
    private javax.swing.JMenu cerrarSesionMenu;
    private javax.swing.JMenuItem cerrarSesionMenuItem;
    private javax.swing.JMenuItem cliActualizarItemMenu;
    private javax.swing.JMenuItem cliCrearitemMenu;
    private javax.swing.JMenuItem cliEliminarItemMenu;
    private javax.swing.JMenuItem cliListarItemMenu;
    private javax.swing.JMenuItem conCrearItemMenu;
    private javax.swing.JMenuItem conListarItemMenu;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem empActualizarMenuItem;
    private javax.swing.JMenuItem empCrearMenuItem;
    private javax.swing.JMenuItem empEliminarMenuItem;
    private javax.swing.JMenuItem empListarMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu jAutos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jmqnu2;
    private javax.swing.JLabel lblPrincipal;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem resActualizarItemMenu;
    private javax.swing.JMenuItem resCrearItemMenu;
    private javax.swing.JMenuItem resEliminarItemMenu;
    private javax.swing.JMenuItem resListarItemMenu;
    // End of variables declaration//GEN-END:variables
}
