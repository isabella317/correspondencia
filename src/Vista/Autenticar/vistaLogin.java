package Vista.Autenticar;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

/*vista correspondiente al modulo de login en la aplicación */
public class vistaLogin extends javax.swing.JFrame {


    public vistaLogin() {

        initComponents();

        Dimension DmTamanoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Image ImIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/img.png"));
        this.setIconImage(ImIcon);
        this.setLocationRelativeTo(null);
        jlbMsjUsuario.setVisible(false);
        jlbMsjContrasena.setVisible(false);
        jlblMsjAdvertencia.setVisible(false);

    }

    public void soloNumeros(java.awt.event.KeyEvent Kyevt) {
        char ChCar = Kyevt.getKeyChar();
        if (jtxLogin.getText().length() >= 20) {
            Kyevt.consume();
        }
        if ((ChCar < '0' || ChCar > '9')) {
            Kyevt.consume();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileSystemModel1 = new org.jdesktop.swingx.treetable.FileSystemModel();
        jlbUsuario = new javax.swing.JLabel();
        jtxLogin = new javax.swing.JTextField();
        jlbMsjUsuario = new javax.swing.JLabel();
        jlbContrasena = new javax.swing.JLabel();
        jpsContrasena = new javax.swing.JPasswordField();
        jlbMsjContrasena = new javax.swing.JLabel();
        jlbRecuperar = new javax.swing.JLabel();
        jlblMsjAdvertencia = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jlbImgUsuario = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jlbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbUsuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlbUsuario.setText("Usuario       :");
        getContentPane().add(jlbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        jtxLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxLoginKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxLoginKeyTyped(evt);
            }
        });
        getContentPane().add(jtxLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 130, 20));
        jtxLogin.setLayout(null);

        jlbMsjUsuario.setFont(new java.awt.Font("Verdana", 1, 9)); // NOI18N
        jlbMsjUsuario.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjUsuario.setText("jLabel1");
        getContentPane().add(jlbMsjUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 150, -1));

        jlbContrasena.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlbContrasena.setText("Contraseña :");
        getContentPane().add(jlbContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        jpsContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpsContrasenaMouseClicked(evt);
            }
        });
        jpsContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpsContrasenaActionPerformed(evt);
            }
        });
        getContentPane().add(jpsContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 130, 20));

        jlbMsjContrasena.setFont(new java.awt.Font("Verdana", 1, 9)); // NOI18N
        jlbMsjContrasena.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjContrasena.setText("jLabel1");
        getContentPane().add(jlbMsjContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 150, -1));

        jlbRecuperar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlbRecuperar.setText("¿ Olvidó su contraseña ?");
        jlbRecuperar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(jlbRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        jlblMsjAdvertencia.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jlblMsjAdvertencia.setForeground(new java.awt.Color(51, 51, 51));
        jlblMsjAdvertencia.setText("jLabel1");
        getContentPane().add(jlblMsjAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 460, -1));

        btnIngresar.setBackground(new java.awt.Color(153, 0, 0));
        btnIngresar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setAlignmentY(0.0F);
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 100, 30));

        btnLimpiar.setBackground(new java.awt.Color(153, 0, 0));
        btnLimpiar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(null);
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 100, 30));

        jlbImgUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/img.png"))); // NOI18N
        getContentPane().add(jlbImgUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 200, 190));

        btnSalir.setBackground(new java.awt.Color(153, 0, 0));
        btnSalir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setBorder(null);
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 70, 20));

        jlbFondo.setBackground(new java.awt.Color(255, 255, 255));
        jlbFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/blanco.jpg"))); // NOI18N
        getContentPane().add(jlbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpsContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpsContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpsContrasenaActionPerformed

    private void jpsContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpsContrasenaMouseClicked

    }//GEN-LAST:event_jpsContrasenaMouseClicked

    private void jtxLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxLoginKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_jtxLoginKeyTyped

    private void jtxLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxLoginKeyPressed

    }//GEN-LAST:event_jtxLoginKeyPressed

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
            java.util.logging.Logger.getLogger(vistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    public javax.swing.JButton btnIngresar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnSalir;
    private org.jdesktop.swingx.treetable.FileSystemModel fileSystemModel1;
    private javax.swing.JLabel jlbContrasena;
    private javax.swing.JLabel jlbFondo;
    private javax.swing.JLabel jlbImgUsuario;
    public javax.swing.JLabel jlbMsjContrasena;
    public javax.swing.JLabel jlbMsjUsuario;
    public javax.swing.JLabel jlbRecuperar;
    private javax.swing.JLabel jlbUsuario;
    public javax.swing.JLabel jlblMsjAdvertencia;
    public javax.swing.JPasswordField jpsContrasena;
    public javax.swing.JTextField jtxLogin;
    // End of variables declaration//GEN-END:variables
}
