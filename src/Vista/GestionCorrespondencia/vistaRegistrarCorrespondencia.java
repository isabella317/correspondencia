/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.GestionCorrespondencia;

import static Controlador.ControladorInicioSesion.UsValido;
import Modelo.Entidades.Usuario;
import Vista.vistaPanelPrincipal;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author ISABELLA
 */
public class vistaRegistrarCorrespondencia extends javax.swing.JFrame {

   Usuario u= new Usuario();
   vistaPanelPrincipal vistaP = new vistaPanelPrincipal(UsValido);

    public vistaRegistrarCorrespondencia(DAO.Tablas.Usuario usuario) {
        initComponents();
        this.setTitle("Panel Correspodencia");
        this.setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png"));
        this.setIconImage(icon);
        this.setLocationRelativeTo(null);
    }

    public void setvistaP(vistaPanelPrincipal vistaP) {
        this.vistaP = vistaP;
    }

    public vistaPanelPrincipal getvistaP() {
        return vistaP;
    }
    
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtxtFecha = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcomboOrigen = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcomboDestino = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jcomboTipoOrigen = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jtxtRuta = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jcheckConfidencial = new javax.swing.JCheckBox();
        enviar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jeditObservaciones = new javax.swing.JEditorPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jeditAsunto = new javax.swing.JEditorPane();
        btnDocumento = new javax.swing.JButton();
        atras = new javax.swing.JLabel();
        jcomboDependencia = new javax.swing.JComboBox();
        jtxtRemitente = new javax.swing.JTextField();
        jcomboDestinatario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(600, 600));

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(255, 51, 51));
        jTextField7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setText("                                         Registrar Correspondencia");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7jTextField1ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(252, 79, 79));
        jTextField1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 0, 0));
        jTextField1.setText("                                                                 Información Básica");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel1.setText("Fecha de documento : ");

        jtxtFecha.setEditable(false);
        jtxtFecha.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(252, 79, 79));
        jTextField4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(153, 0, 0));
        jTextField4.setText("                                                                 Información Remitente");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel4.setText("Tipo Origen :");

        jcomboOrigen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INTERNO", "EXTERNO" }));
        jcomboOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboOrigenActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel5.setText("Dependencia Remitente :");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel6.setText("Persona Remitente :");

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(252, 79, 79));
        jTextField6.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(153, 0, 0));
        jTextField6.setText("                                                                 Información Destinatario");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel7.setText("Tipo Destino:");

        jcomboDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INTERNO", "EXTERNO" }));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel8.setText("Tipo de Destinatario :");

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(252, 79, 79));
        jTextField8.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(153, 0, 0));
        jTextField8.setText("                                                       Información de la Correspondencia");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel9.setText("Observaciones  : ");

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel10.setText("Asunto : ");

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel15.setText("Tipo Origen Envio :");

        jcomboTipoOrigen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OFICINA CORREO", "DIRECTO" }));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel11.setText("Documento :");

        jtxtRuta.setEditable(false);

        jButton10.setBackground(new java.awt.Color(255, 51, 0));
        jButton10.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jButton10.setText("...");

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel16.setText("Confidencial : ");

        enviar.setBackground(new java.awt.Color(255, 51, 0));
        enviar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        enviar.setText("Enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        limpiar.setBackground(new java.awt.Color(255, 51, 0));
        limpiar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jeditObservaciones);

        jScrollPane3.setViewportView(jeditAsunto);

        btnDocumento.setBackground(new java.awt.Color(255, 51, 0));
        btnDocumento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnDocumento.setText("...");

        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
        });

        jcomboDependencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcomboDestinatario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DEPENDENCIA", "LISTA DE DISTRIBUCIÓN" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(jtxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcomboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcomboDependencia, 0, 257, Short.MAX_VALUE)
                            .addComponent(jtxtRemitente)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcomboDestino, 0, 161, Short.MAX_VALUE)
                            .addComponent(jcomboDestinatario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel16))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcomboTipoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jtxtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDocumento))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcheckConfidencial)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(limpiar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(atras)
                                .addGap(99, 99, 99))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1))
                    .addComponent(jtxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcomboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcomboDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7))
                    .addComponent(jcomboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jcomboDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel15))
                            .addComponent(jcomboTipoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jButton10))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtxtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(btnDocumento))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel16))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jcheckConfidencial)))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(limpiar)
                            .addComponent(enviar)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(atras)))
                .addGap(57, 57, 57))
        );

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField7jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7jTextField1ActionPerformed

    private void jcomboOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboOrigenActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_limpiarActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enviarActionPerformed

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
           dispose();
    }//GEN-LAST:event_atrasMouseClicked

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
            java.util.logging.Logger.getLogger(vistaRegistrarCorrespondencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaRegistrarCorrespondencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaRegistrarCorrespondencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaRegistrarCorrespondencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel atras;
    public javax.swing.JButton btnDocumento;
    public javax.swing.JButton enviar;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    public javax.swing.JCheckBox jcheckConfidencial;
    public javax.swing.JComboBox jcomboDependencia;
    public javax.swing.JComboBox<String> jcomboDestinatario;
    public javax.swing.JComboBox jcomboDestino;
    public javax.swing.JComboBox jcomboOrigen;
    public javax.swing.JComboBox jcomboTipoOrigen;
    public javax.swing.JEditorPane jeditAsunto;
    public javax.swing.JEditorPane jeditObservaciones;
    public javax.swing.JTextField jtxtFecha;
    public javax.swing.JTextField jtxtRemitente;
    public javax.swing.JTextField jtxtRuta;
    public javax.swing.JButton limpiar;
    // End of variables declaration//GEN-END:variables


}
