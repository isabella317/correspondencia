package Vista.Autenticar;
import Modelo.Entidades.Usuario;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

/*JFRAME de Vista Login */
public class vistaLogin extends javax.swing.JFrame {

    Usuario UsEnLinea = new Usuario();



    public vistaLogin() {

        initComponents();
        this.setTitle("Login");
        this.setResizable(false);
        Dimension DmTamanoPantalla = Toolkit.getDefaultToolkit().getScreenSize();

        Image ImIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png"));
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
        jpasContrasena = new javax.swing.JPasswordField();
        jlbMsjContrasena = new javax.swing.JLabel();
        jlbRecuperar = new javax.swing.JLabel();
        jlblMsjAdvertencia = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbUsuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlbUsuario.setForeground(new java.awt.Color(204, 204, 204));
        jlbUsuario.setText("Usuario       :");
        getContentPane().add(jlbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        jtxLogin.setBackground(new java.awt.Color(102, 102, 102));
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
        jlbContrasena.setForeground(new java.awt.Color(204, 204, 204));
        jlbContrasena.setText("Contraseña :");
        getContentPane().add(jlbContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        jpasContrasena.setBackground(new java.awt.Color(102, 102, 102));
        jpasContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpasContrasenaMouseClicked(evt);
            }
        });
        jpasContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpasContrasenaActionPerformed(evt);
            }
        });
        getContentPane().add(jpasContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 130, 20));

        jlbMsjContrasena.setFont(new java.awt.Font("Verdana", 1, 9)); // NOI18N
        jlbMsjContrasena.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjContrasena.setText("jLabel1");
        getContentPane().add(jlbMsjContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 150, -1));

        jlbRecuperar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlbRecuperar.setForeground(new java.awt.Color(204, 204, 204));
        jlbRecuperar.setText("¿ Olvidó su contraseña ?");
        jlbRecuperar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(jlbRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        jlblMsjAdvertencia.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jlblMsjAdvertencia.setForeground(new java.awt.Color(51, 51, 51));
        jlblMsjAdvertencia.setText("jLabel1");
        getContentPane().add(jlblMsjAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 460, -1));

        btnIngresar.setBackground(new java.awt.Color(204, 204, 204));
        btnIngresar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setAlignmentY(0.0F);
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 100, 30));

        btnLimpiar.setBackground(new java.awt.Color(204, 204, 204));
        btnLimpiar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(null);
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 100, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/img.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 200, 190));

        btnSalir.setBackground(new java.awt.Color(204, 204, 204));
        btnSalir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setBorder(null);
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 70, 20));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gray2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpasContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpasContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpasContrasenaActionPerformed

    private void jpasContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpasContrasenaMouseClicked

    }//GEN-LAST:event_jpasContrasenaMouseClicked

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jlbContrasena;
    public javax.swing.JLabel jlbMsjContrasena;
    public javax.swing.JLabel jlbMsjUsuario;
    public javax.swing.JLabel jlbRecuperar;
    private javax.swing.JLabel jlbUsuario;
    public javax.swing.JLabel jlblMsjAdvertencia;
    public javax.swing.JPasswordField jpasContrasena;
    public javax.swing.JTextField jtxLogin;
    // End of variables declaration//GEN-END:variables
}
