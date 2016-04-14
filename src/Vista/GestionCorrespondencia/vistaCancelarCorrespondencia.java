package Vista.GestionCorrespondencia;

import static Controlador.ControladorInicioSesion.UsValido;
import Modelo.Entidades.Usuario;
import Vista.*;
import java.awt.Image;
import java.awt.Toolkit;

public class vistaCancelarCorrespondencia extends javax.swing.JFrame {

    Usuario u = new Usuario();
    vistaPanelPrincipal vistaR = new vistaPanelPrincipal(UsValido);
    vistaPanelPrincipal vc;

    public vistaCancelarCorrespondencia(DAO.Tablas.Usuario usuario) {
        initComponents();
        String nombres = usuario.getIdFuncionario().getNombre() + " " + usuario.getIdFuncionario().getApellido();
        n.setText(nombres);
        this.setTitle("Cancelar Correspodencia");
        this.setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png"));
        this.setIconImage(icon);
        this.setLocationRelativeTo(null);

    }

    public void setvistaR(vistaPanelPrincipal vistaR) {
        this.vistaR = vistaR;
    }

    public vistaPanelPrincipal getvistaR() {
        return vistaR;
    }
    
     public void soloNumeros(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();
        if (numero_consecutivo.getText().length() >= 20 ) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        calendario = new datechooser.beans.DateChooserCombo();
        numero_correspondencia = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        numero_consecutivo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cancelar = new javax.swing.JTable();
        atras = new javax.swing.JLabel();
        n = new javax.swing.JLabel();
        fecha1 = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 550));
        jPanel4.setRequestFocusEnabled(false);
        jPanel4.setVerifyInputWhenFocusTarget(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(255, 51, 51));
        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setText("                                                                         Cancelar Correspondencia");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7jTextField1ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 20, 2000, 54));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 512, 1020, 10));
        jPanel4.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        numero_correspondencia.setText("Aceptar");
        jPanel4.add(numero_correspondencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, -1, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel1.setText("Escoger fecha de la correspondencia a Cancelar :");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        numero_consecutivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numero_consecutivoKeyTyped(evt);
            }
        });
        jPanel4.add(numero_consecutivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 150, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel2.setText("Ingresar Número de Correspondencia a Cancelar :");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, -1, -1));
        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, -1, -1));

        tabla_cancelar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Encargado Documento", "Destinatario", "Tipo", "Número Correspondencia", "Asunto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_cancelar);

        jScrollPane3.setViewportView(jScrollPane1);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 910, 270));

        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        jPanel4.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 460, -1, -1));

        n.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        n.setText("Jpanel");
        jPanel4.add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 470, 210, 30));

        fecha1.setText("Aceptar");
        jPanel4.add(fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1000, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField7jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7jTextField1ActionPerformed

    private void numero_consecutivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numero_consecutivoKeyTyped
       soloNumeros(evt);
    }//GEN-LAST:event_numero_consecutivoKeyTyped

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
            java.util.logging.Logger.getLogger(vistaCancelarCorrespondencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaCancelarCorrespondencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaCancelarCorrespondencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaCancelarCorrespondencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
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
    public datechooser.beans.DateChooserCombo calendario;
    public javax.swing.JButton fecha1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField7;
    public javax.swing.JLabel n;
    public javax.swing.JTextField numero_consecutivo;
    public javax.swing.JButton numero_correspondencia;
    public javax.swing.JTable tabla_cancelar;
    // End of variables declaration//GEN-END:variables
}
