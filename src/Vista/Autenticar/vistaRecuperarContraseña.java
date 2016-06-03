package Vista.Autenticar;

import java.awt.Image;
import java.awt.Toolkit;

/*vista correspondiente al modulo de recuperar contraseña en la aplicación */

public class vistaRecuperarContraseña extends javax.swing.JFrame {

    public vistaRecuperarContraseña() {

        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png"));
        this.setIconImage(icon);
        this.setLocationRelativeTo(null);
        jlbMsjAdvertencia.setVisible(false);
        jlbEncabezado.setOpaque(true);
    }

    public void soloNumeros(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();
        if (jtxIdentificacion.getText().length() >= 20) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileSystemModel1 = new org.jdesktop.swingx.treetable.FileSystemModel();
        jlbAdvertencia = new javax.swing.JLabel();
        jlbIdentificacion = new javax.swing.JLabel();
        jtxIdentificacion = new javax.swing.JTextField();
        jlbMsjAdvertencia = new javax.swing.JLabel();
        btnaceptar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jlbTitulo = new javax.swing.JLabel();
        jlbAtras = new javax.swing.JLabel();
        jlbEncabezado = new javax.swing.JLabel();
        jlbAdvertencia2 = new javax.swing.JLabel();
        jlbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(550, 497));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbAdvertencia.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jlbAdvertencia.setText("le sera enviado . Una vez haya recibido el código de verificación podrá ingresar.");
        getContentPane().add(jlbAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 480, 20));

        jlbIdentificacion.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlbIdentificacion.setText("Identificación");
        getContentPane().add(jlbIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        jtxIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxIdentificacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxIdentificacionKeyTyped(evt);
            }
        });
        getContentPane().add(jtxIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 300, 20));
        jtxIdentificacion.setLayout(null);

        jlbMsjAdvertencia.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jlbMsjAdvertencia.setText("jLabel1");
        getContentPane().add(jlbMsjAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 460, 20));

        btnaceptar.setBackground(new java.awt.Color(153, 0, 0));
        btnaceptar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnaceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnaceptar.setText("Aceptar");
        btnaceptar.setAlignmentY(0.0F);
        getContentPane().add(btnaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 105, 30));

        btnlimpiar.setBackground(new java.awt.Color(153, 0, 0));
        btnlimpiar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnlimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar.setText("Limpiar");
        getContentPane().add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 110, 30));

        jlbTitulo.setBackground(new java.awt.Color(255, 0, 51));
        jlbTitulo.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jlbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlbTitulo.setText("       RECUPERACIÓN DE CONTRASEÑA ");
        getContentPane().add(jlbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jlbAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras1.png"))); // NOI18N
        getContentPane().add(jlbAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jlbEncabezado.setBackground(new java.awt.Color(153, 0, 0));
        getContentPane().add(jlbEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 90));

        jlbAdvertencia2.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jlbAdvertencia2.setText("Por favor ingrese el número de identificación de su cuenta. Un codigo de verficación");
        getContentPane().add(jlbAdvertencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 480, 20));

        jlbFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/blanco.jpg"))); // NOI18N
        getContentPane().add(jlbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxIdentificacionKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_jtxIdentificacionKeyTyped

    private void jtxIdentificacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxIdentificacionKeyPressed

    }//GEN-LAST:event_jtxIdentificacionKeyPressed

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
            java.util.logging.Logger.getLogger(vistaRecuperarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaRecuperarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaRecuperarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaRecuperarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    public javax.swing.JButton btnaceptar;
    public javax.swing.JButton btnlimpiar;
    private org.jdesktop.swingx.treetable.FileSystemModel fileSystemModel1;
    private javax.swing.JLabel jlbAdvertencia;
    private javax.swing.JLabel jlbAdvertencia2;
    public javax.swing.JLabel jlbAtras;
    private javax.swing.JLabel jlbEncabezado;
    private javax.swing.JLabel jlbFondo;
    private javax.swing.JLabel jlbIdentificacion;
    public javax.swing.JLabel jlbMsjAdvertencia;
    private javax.swing.JLabel jlbTitulo;
    public javax.swing.JTextField jtxIdentificacion;
    // End of variables declaration//GEN-END:variables
}
