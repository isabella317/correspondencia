/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Correspondencia;

import static Controlador.controladorInicioSesion.Conconexion;
import static Controlador.controladorInicioSesion.DuDaodependencia;
import static Controlador.controladorInicioSesion.listaDpDaoTabla;
import DAO.Funciones.DaoDependencia;

/**
 *
 * @author ISABELLA
 */
public class InternoModal extends javax.swing.JDialog {

    /**
     * Creates new form remitenteModal
     */
    public InternoModal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenarDependencias();
        jLabel3.setOpaque(true);
        jlbMsjAdvertencia2.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jtxConsulta = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        jlbMsjAdvertencia2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlbTipoDoc = new javax.swing.JLabel();
        jlbIdentificacion = new javax.swing.JLabel();
        jtxIdentificacion = new javax.swing.JTextField();
        cmbTipoDoc = new javax.swing.JComboBox<>();
        jlbNombres = new javax.swing.JLabel();
        jtxNombres = new javax.swing.JTextField();
        jlbApellidos = new javax.swing.JLabel();
        jtxApellidos = new javax.swing.JTextField();
        jtxtCorreo = new javax.swing.JTextField();
        jlbCorreo = new javax.swing.JLabel();
        jlbTelefono = new javax.swing.JLabel();
        jtxTelefono = new javax.swing.JTextField();
        jlbDependencia = new javax.swing.JLabel();
        cmbDependencia = new javax.swing.JComboBox<>();
        jlbSede = new javax.swing.JLabel();
        cmbSede = new javax.swing.JComboBox<>();
        jlbCargo = new javax.swing.JLabel();
        jtxCargo = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        scrFuncionarios = new javax.swing.JScrollPane();
        jtbTablaUsuarios = new javax.swing.JTable();
        jlbMsjAdvertencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(10, 10, 0, 0));
        setLocation(new java.awt.Point(0, 20));
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setAlignmentY(20.5F);
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 550));
        jPanel4.setRequestFocusEnabled(false);
        jPanel4.setVerifyInputWhenFocusTarget(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxConsultaActionPerformed(evt);
            }
        });
        jtxConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxConsultaKeyTyped(evt);
            }
        });
        jPanel4.add(jtxConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, 30));

        btnConsulta.setBackground(new java.awt.Color(153, 0, 0));
        btnConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnConsulta.setText("Consultar");
        jPanel4.add(btnConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 90, 30));

        jlbMsjAdvertencia2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbMsjAdvertencia2.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjAdvertencia2.setText("jLabel1");
        jPanel4.add(jlbMsjAdvertencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 540, -1));

        jLabel3.setBackground(new java.awt.Color(153, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("                                                FUNCIONARIOS INTERNOS");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 80));

        jlbTipoDoc.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbTipoDoc.setForeground(new java.awt.Color(51, 51, 51));
        jlbTipoDoc.setText("Tipo documento");
        jPanel4.add(jlbTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        jlbIdentificacion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbIdentificacion.setForeground(new java.awt.Color(51, 51, 51));
        jlbIdentificacion.setText("Identificación ");
        jPanel4.add(jlbIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 120, -1));

        jtxIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxIdentificacionActionPerformed(evt);
            }
        });
        jtxIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxIdentificacionKeyTyped(evt);
            }
        });
        jPanel4.add(jtxIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 170, -1));

        cmbTipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TI", "CE", "CC" }));
        jPanel4.add(cmbTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 170, -1));

        jlbNombres.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbNombres.setForeground(new java.awt.Color(51, 51, 51));
        jlbNombres.setText("Nombres");
        jPanel4.add(jlbNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 80, -1));

        jtxNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxNombresActionPerformed(evt);
            }
        });
        jtxNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxNombresKeyTyped(evt);
            }
        });
        jPanel4.add(jtxNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 170, -1));

        jlbApellidos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbApellidos.setForeground(new java.awt.Color(51, 51, 51));
        jlbApellidos.setText("Apellidos ");
        jPanel4.add(jlbApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, -1, -1));

        jtxApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxApellidosKeyTyped(evt);
            }
        });
        jPanel4.add(jtxApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, 170, -1));
        jPanel4.add(jtxtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 520, 170, -1));

        jlbCorreo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbCorreo.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreo.setText("Correo");
        jPanel4.add(jlbCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 100, -1));

        jlbTelefono.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbTelefono.setForeground(new java.awt.Color(51, 51, 51));
        jlbTelefono.setText("Telefono         ");
        jPanel4.add(jlbTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, -1, -1));

        jtxTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxTelefonoKeyTyped(evt);
            }
        });
        jPanel4.add(jtxTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 210, -1));

        jlbDependencia.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbDependencia.setForeground(new java.awt.Color(51, 51, 51));
        jlbDependencia.setText("Dependencia");
        jPanel4.add(jlbDependencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 110, -1));

        cmbDependencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cmbDependencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, 210, -1));

        jlbSede.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbSede.setForeground(new java.awt.Color(51, 51, 51));
        jlbSede.setText("Sede");
        jPanel4.add(jlbSede, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 110, -1));

        cmbSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YUMBO", "MELENDÉZ", "PALMIRA", "NORTE DEL CAUCA", "SAN FERNANDO" }));
        jPanel4.add(cmbSede, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, 210, -1));

        jlbCargo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbCargo.setForeground(new java.awt.Color(51, 51, 51));
        jlbCargo.setText("Cargo");
        jPanel4.add(jlbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, 110, -1));

        jtxCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxCargoKeyTyped(evt);
            }
        });
        jPanel4.add(jtxCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 480, 210, -1));

        btnAceptar.setBackground(new java.awt.Color(153, 0, 0));
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Registrar");
        jPanel4.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 530, 90, 30));

        jtbTablaUsuarios.setBackground(new java.awt.Color(204, 204, 204));
        jtbTablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificación", "Nombres", "Apellidos", "Telefono", "Correo", ""
            }
        ));
        jtbTablaUsuarios.setRowSelectionAllowed(false);
        scrFuncionarios.setViewportView(jtbTablaUsuarios);

        jPanel4.add(scrFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 910, 180));

        jlbMsjAdvertencia.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbMsjAdvertencia.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjAdvertencia.setText("jLabel1");
        jPanel4.add(jlbMsjAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 540, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxConsultaActionPerformed

    private void jtxConsultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxConsultaKeyTyped

    }//GEN-LAST:event_jtxConsultaKeyTyped

    private void jtxIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxIdentificacionActionPerformed

    }//GEN-LAST:event_jtxIdentificacionActionPerformed

    private void jtxIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxIdentificacionKeyTyped
        soloNumeros(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_jtxIdentificacionKeyTyped

    private void jtxNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxNombresActionPerformed

    private void jtxNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxNombresKeyTyped
        soloLetrasNombres(evt);
    }//GEN-LAST:event_jtxNombresKeyTyped

    private void jtxApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxApellidosKeyTyped
        soloLetrasNombres(evt);  // TODO add your handling code here:
    }//GEN-LAST:event_jtxApellidosKeyTyped

    private void jtxTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxTelefonoKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_jtxTelefonoKeyTyped

    private void jtxCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxCargoKeyTyped
        soloLetras(evt);
    }//GEN-LAST:event_jtxCargoKeyTyped

    public void soloNumeros(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();
        if (jtxTelefono.getText().length() >= 20 || jtxIdentificacion.getText().length() >= 20) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }

    public void soloLetras(java.awt.event.KeyEvent evt) {

        char car = evt.getKeyChar();
        System.out.println((int) car);
        if (jtxNombres.getText().length() >= 20 || jtxApellidos.getText().length() >= 20) {
            evt.consume();
        }
        if ((((int) car >= 65 && (int) car <= 90)) || (((int) car >= 97 && (int) car <= 122))) {

        } else {
            evt.consume();
        }

    }

    public void soloLetrasNombres(java.awt.event.KeyEvent evt) {

        char car = evt.getKeyChar();
        System.out.println((int) car);
        if (jtxNombres.getText().length() >= 20 || jtxApellidos.getText().length() >= 20) {
            evt.consume();
        }
        if ((((int) car >= 65 && (int) car <= 90)) || (((int) car >= 97 && (int) car <= 122)) || (int) car == 32) {

        } else {
            evt.consume();
        }

    }

    public void llenarDependencias() {
        DuDaodependencia = new DaoDependencia(Conconexion.getConexion());
        listaDpDaoTabla = DuDaodependencia.findDependenciaEntities();
        String[] dependencias = new String[listaDpDaoTabla.size()];
        for (int i = 0; i < dependencias.length; i++) {
            dependencias[i] = listaDpDaoTabla.get(i).getNombre();
        }

        cmbDependencia.setModel(new javax.swing.DefaultComboBoxModel(dependencias));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InternoModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InternoModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InternoModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InternoModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InternoModal dialog = new InternoModal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptar;
    public javax.swing.JButton btnConsulta;
    public javax.swing.JComboBox<String> cmbDependencia;
    public javax.swing.JComboBox<String> cmbSede;
    public javax.swing.JComboBox<String> cmbTipoDoc;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlbApellidos;
    private javax.swing.JLabel jlbCargo;
    private javax.swing.JLabel jlbCorreo;
    private javax.swing.JLabel jlbDependencia;
    public javax.swing.JLabel jlbIdentificacion;
    public javax.swing.JLabel jlbMsjAdvertencia;
    public javax.swing.JLabel jlbMsjAdvertencia2;
    private javax.swing.JLabel jlbNombres;
    private javax.swing.JLabel jlbSede;
    private javax.swing.JLabel jlbTelefono;
    public javax.swing.JLabel jlbTipoDoc;
    public javax.swing.JTable jtbTablaUsuarios;
    public javax.swing.JTextField jtxApellidos;
    public javax.swing.JTextField jtxCargo;
    public javax.swing.JTextField jtxConsulta;
    public javax.swing.JTextField jtxIdentificacion;
    public javax.swing.JTextField jtxNombres;
    public javax.swing.JTextField jtxTelefono;
    public javax.swing.JTextField jtxtCorreo;
    private javax.swing.JScrollPane scrFuncionarios;
    // End of variables declaration//GEN-END:variables
}