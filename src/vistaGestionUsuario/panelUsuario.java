/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaGestionUsuario;

/**
 *
 * @author ISABELLA
 */
public class panelUsuario extends javax.swing.JPanel {

    /**
     * Creates new form panelUsuario
     */
    public panelUsuario() {
        initComponents();
    }
    
     public void soloNumeros(java.awt.event.KeyEvent KyEvt) {
        char ChCar = KyEvt.getKeyChar();
        if (jtxIdentificacion.getText().length() >= 20) {
            KyEvt.consume();
        }
        if ((ChCar < '0' || ChCar > '9')) {
            KyEvt.consume();
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

        jpnFondo = new javax.swing.JPanel();
        jlbRol = new javax.swing.JLabel();
        jlbEstado = new javax.swing.JLabel();
        jlbModificarUsuario = new javax.swing.JLabel();
        jlbUsuario = new javax.swing.JLabel();
        jtxIdentificacion = new javax.swing.JTextField();
        jlbModificarUs = new javax.swing.JLabel();
        jlbContrasena2 = new javax.swing.JLabel();
        jlbRegistrarUs = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jlbRegistrarUsuario = new javax.swing.JLabel();
        jlbMsjAdvertencia = new javax.swing.JLabel();
        jtxConsulta = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbFuncionario = new javax.swing.JComboBox<>();
        cmbRol = new javax.swing.JComboBox<>();
        jlbFuncionario = new javax.swing.JLabel();
        jpasContrasena = new javax.swing.JPasswordField();
        jlbContrasena1 = new javax.swing.JLabel();
        jpasContrasena2 = new javax.swing.JPasswordField();
        jlbMsjAdvertencia2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTablaUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1400, 1000));

        jpnFondo.setBackground(new java.awt.Color(255, 255, 255));
        jpnFondo.setEnabled(false);
        jpnFondo.setPreferredSize(new java.awt.Dimension(5000, 1550));
        jpnFondo.setRequestFocusEnabled(false);
        jpnFondo.setVerifyInputWhenFocusTarget(false);
        jpnFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbRol.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbRol.setForeground(new java.awt.Color(51, 51, 51));
        jlbRol.setText("Rol");
        jpnFondo.add(jlbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 80, -1));

        jlbEstado.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbEstado.setForeground(new java.awt.Color(51, 51, 51));
        jlbEstado.setText("Estado");
        jpnFondo.add(jlbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, -1, -1));

        jlbModificarUsuario.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbModificarUsuario.setForeground(new java.awt.Color(51, 51, 51));
        jlbModificarUsuario.setText("Modificar ");
        jpnFondo.add(jlbModificarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 350, -1, -1));

        jlbUsuario.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbUsuario.setForeground(new java.awt.Color(51, 51, 51));
        jlbUsuario.setText("Usuario");
        jpnFondo.add(jlbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 120, -1));

        jtxIdentificacion.setEditable(false);
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
        jpnFondo.add(jtxIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 210, -1));

        jlbModificarUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar1.png"))); // NOI18N
        jpnFondo.add(jlbModificarUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 330, -1, -1));

        jlbContrasena2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbContrasena2.setForeground(new java.awt.Color(51, 51, 51));
        jlbContrasena2.setText("Confirmación");
        jpnFondo.add(jlbContrasena2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, -1, -1));

        jlbRegistrarUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registrar1.png"))); // NOI18N
        jlbRegistrarUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbRegistrarUs(evt);
            }
        });
        jpnFondo.add(jlbRegistrarUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 400, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(51, 51, 51));
        btnActualizar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        jpnFondo.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, -1, -1));

        btnlimpiar.setBackground(new java.awt.Color(51, 51, 51));
        btnlimpiar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnlimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar.setText("Limpiar");
        jpnFondo.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, 90, -1));

        jlbRegistrarUsuario.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbRegistrarUsuario.setForeground(new java.awt.Color(51, 51, 51));
        jlbRegistrarUsuario.setText("Registrar ");
        jpnFondo.add(jlbRegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 420, -1, -1));

        jlbMsjAdvertencia.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbMsjAdvertencia.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjAdvertencia.setText("jLabel1");
        jpnFondo.add(jlbMsjAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 540, -1));
        jpnFondo.add(jtxConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 150, 30));

        btnConsulta.setBackground(new java.awt.Color(51, 51, 51));
        btnConsulta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnConsulta.setText("Consultar");
        jpnFondo.add(btnConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 100, 30));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));
        jpnFondo.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 110, -1));

        jpnFondo.add(cmbFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 210, -1));

        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SECRETARIO", "INVITADO" }));
        cmbRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRolActionPerformed(evt);
            }
        });
        jpnFondo.add(cmbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 110, -1));

        jlbFuncionario.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbFuncionario.setForeground(new java.awt.Color(51, 51, 51));
        jlbFuncionario.setText("Funcionario");
        jpnFondo.add(jlbFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

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
        jpnFondo.add(jpasContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 130, 20));

        jlbContrasena1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbContrasena1.setForeground(new java.awt.Color(51, 51, 51));
        jlbContrasena1.setText("Contraseña nueva ");
        jpnFondo.add(jlbContrasena1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, -1, -1));

        jpasContrasena2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpasContrasena2MouseClicked(evt);
            }
        });
        jpasContrasena2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpasContrasena2ActionPerformed(evt);
            }
        });
        jpnFondo.add(jpasContrasena2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 130, 20));

        jlbMsjAdvertencia2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbMsjAdvertencia2.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjAdvertencia2.setText("jLabel1");
        jpnFondo.add(jlbMsjAdvertencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 540, -1));

        jtbTablaUsuarios.setBackground(new java.awt.Color(204, 204, 204));
        jtbTablaUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jtbTablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificación", "Nombres", "Apellidos", "Telefono", "Correo", "Sede"
            }
        ));
        jScrollPane1.setViewportView(jtbTablaUsuarios);

        jpnFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 1210, 120));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("Usuarios");
        jpnFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5020, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpnFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 5020, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpnFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jpasContrasena2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpasContrasena2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpasContrasena2ActionPerformed

    private void jpasContrasena2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpasContrasena2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpasContrasena2MouseClicked

    private void jpasContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpasContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpasContrasenaActionPerformed

    private void jpasContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpasContrasenaMouseClicked

    }//GEN-LAST:event_jpasContrasenaMouseClicked

    private void cmbRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRolActionPerformed

    private void jlbRegistrarUs(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbRegistrarUs
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbRegistrarUs

    private void jtxIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxIdentificacionKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_jtxIdentificacionKeyTyped

    private void jtxIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxIdentificacionActionPerformed

    }//GEN-LAST:event_jtxIdentificacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnConsulta;
    public javax.swing.JButton btnlimpiar;
    public javax.swing.JComboBox<String> cmbEstado;
    public javax.swing.JComboBox<String> cmbFuncionario;
    public javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbContrasena1;
    private javax.swing.JLabel jlbContrasena2;
    private javax.swing.JLabel jlbEstado;
    private javax.swing.JLabel jlbFuncionario;
    public javax.swing.JLabel jlbModificarUs;
    private javax.swing.JLabel jlbModificarUsuario;
    public javax.swing.JLabel jlbMsjAdvertencia;
    public javax.swing.JLabel jlbMsjAdvertencia2;
    public javax.swing.JLabel jlbRegistrarUs;
    private javax.swing.JLabel jlbRegistrarUsuario;
    private javax.swing.JLabel jlbRol;
    private javax.swing.JLabel jlbUsuario;
    public javax.swing.JPasswordField jpasContrasena;
    public javax.swing.JPasswordField jpasContrasena2;
    private javax.swing.JPanel jpnFondo;
    public javax.swing.JTable jtbTablaUsuarios;
    public javax.swing.JTextField jtxConsulta;
    public javax.swing.JTextField jtxIdentificacion;
    // End of variables declaration//GEN-END:variables
}
