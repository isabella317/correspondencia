/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaGestionUsuario;

import static Controlador.ControladorInicioSesion.Conconexion;
import static Controlador.ControladorInicioSesion.DpDaoTabla;
import static Controlador.ControladorInicioSesion.DuDaodependencia;
import static Controlador.ControladorInicioSesion.UsValido;
import DAO.Funciones.DaoDependencia;
import Vista.vistaPanelPrincipal;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author ISABELLA
 */
public class panelFuncionario extends javax.swing.JPanel {

    /**
     * Creates new form panelFuncionario
     */
    public panelFuncionario() {
        initComponents();
        llenarDependencias();

    }

    int InDependenciaEscogida;

    public void llenarDependencias() {
        DuDaodependencia = new DaoDependencia(Conconexion.getConexion());
        DpDaoTabla = DuDaodependencia.findDependenciaEntities();
        String[] dependencias = new String[DpDaoTabla.size()];
        for (int i = 0; i < dependencias.length; i++) {
            dependencias[i] = DpDaoTabla.get(i).getNombre();
        }

        cmbDependencia.setModel(new javax.swing.DefaultComboBoxModel(dependencias));
    }

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelfondo = new javax.swing.JPanel();
        jlbNombres = new javax.swing.JLabel();
        jlbApellidos = new javax.swing.JLabel();
        jtxApellidos = new javax.swing.JTextField();
        jlbModificarFuncionario = new javax.swing.JLabel();
        jlbIdentificacion = new javax.swing.JLabel();
        jlbCorreo = new javax.swing.JLabel();
        jtxNombres = new javax.swing.JTextField();
        jtxTelefono = new javax.swing.JTextField();
        jtxIdentificacion = new javax.swing.JTextField();
        jtxtCorreo = new javax.swing.JTextField();
        jlbModificarFU = new javax.swing.JLabel();
        jlbTipoDoc = new javax.swing.JLabel();
        jlbRegistrarFU = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jlbDependencia = new javax.swing.JLabel();
        jlbTelefono = new javax.swing.JLabel();
        cmbTipoDoc = new javax.swing.JComboBox<>();
        jlbRegistrarFuncionario = new javax.swing.JLabel();
        jlbMsjAdvertencia = new javax.swing.JLabel();
        jtxConsulta = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        jlbSede = new javax.swing.JLabel();
        cmbSede = new javax.swing.JComboBox<>();
        jlbCargo = new javax.swing.JLabel();
        jtxCargo = new javax.swing.JTextField();
        cmbDependencia = new javax.swing.JComboBox<>();
        jlbMsjAdvertencia2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTablaUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1400, 1000));

        jpanelfondo.setBackground(new java.awt.Color(255, 255, 255));
        jpanelfondo.setEnabled(false);
        jpanelfondo.setPreferredSize(new java.awt.Dimension(5000, 1550));
        jpanelfondo.setRequestFocusEnabled(false);
        jpanelfondo.setVerifyInputWhenFocusTarget(false);
        jpanelfondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbNombres.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbNombres.setForeground(new java.awt.Color(51, 51, 51));
        jlbNombres.setText("Nombres");
        jpanelfondo.add(jlbNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 80, -1));

        jlbApellidos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbApellidos.setForeground(new java.awt.Color(51, 51, 51));
        jlbApellidos.setText("Apellidos ");
        jpanelfondo.add(jlbApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, -1, -1));

        jtxApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxApellidosKeyTyped(evt);
            }
        });
        jpanelfondo.add(jtxApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 170, -1));

        jlbModificarFuncionario.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbModificarFuncionario.setForeground(new java.awt.Color(51, 51, 51));
        jlbModificarFuncionario.setText("Modificar ");
        jpanelfondo.add(jlbModificarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 350, -1, -1));

        jlbIdentificacion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbIdentificacion.setForeground(new java.awt.Color(51, 51, 51));
        jlbIdentificacion.setText("Identificación ");
        jpanelfondo.add(jlbIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 120, -1));

        jlbCorreo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbCorreo.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreo.setText("Correo");
        jpanelfondo.add(jlbCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 100, -1));

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
        jpanelfondo.add(jtxNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 170, -1));

        jtxTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxTelefonoKeyTyped(evt);
            }
        });
        jpanelfondo.add(jtxTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 110, -1));

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
        jpanelfondo.add(jtxIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 110, -1));
        jpanelfondo.add(jtxtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, 170, -1));

        jlbModificarFU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar1.png"))); // NOI18N
        jpanelfondo.add(jlbModificarFU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 330, -1, -1));

        jlbTipoDoc.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbTipoDoc.setForeground(new java.awt.Color(51, 51, 51));
        jlbTipoDoc.setText("Tipo documento");
        jpanelfondo.add(jlbTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        jlbRegistrarFU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registrar1.png"))); // NOI18N
        jlbRegistrarFU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbRegistrarFU(evt);
            }
        });
        jpanelfondo.add(jlbRegistrarFU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 400, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(51, 51, 51));
        btnActualizar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        jpanelfondo.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, -1, -1));

        btnLimpiar.setBackground(new java.awt.Color(51, 51, 51));
        btnLimpiar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        jpanelfondo.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, 90, -1));

        jlbDependencia.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbDependencia.setForeground(new java.awt.Color(51, 51, 51));
        jlbDependencia.setText("Dependencia");
        jpanelfondo.add(jlbDependencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 110, -1));

        jlbTelefono.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbTelefono.setForeground(new java.awt.Color(51, 51, 51));
        jlbTelefono.setText("Telefono         ");
        jpanelfondo.add(jlbTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));

        cmbTipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TI", "CE", "CC" }));
        jpanelfondo.add(cmbTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 100, -1));

        jlbRegistrarFuncionario.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbRegistrarFuncionario.setForeground(new java.awt.Color(51, 51, 51));
        jlbRegistrarFuncionario.setText("Registrar");
        jpanelfondo.add(jlbRegistrarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 420, -1, -1));

        jlbMsjAdvertencia.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlbMsjAdvertencia.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjAdvertencia.setText("jLabel1");
        jpanelfondo.add(jlbMsjAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 540, -1));

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
        jpanelfondo.add(jtxConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 150, 30));

        btnConsulta.setBackground(new java.awt.Color(51, 51, 51));
        btnConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnConsulta.setText("Consultar");
        jpanelfondo.add(btnConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 90, 30));

        jlbSede.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbSede.setForeground(new java.awt.Color(51, 51, 51));
        jlbSede.setText("Sede");
        jpanelfondo.add(jlbSede, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 110, -1));

        cmbSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YUMBO", "MELENDÉZ", "PALMIRA", "NORTE DEL CAUCA", "SAN FERNANDO" }));
        jpanelfondo.add(cmbSede, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, 110, -1));

        jlbCargo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbCargo.setForeground(new java.awt.Color(51, 51, 51));
        jlbCargo.setText("Cargo");
        jpanelfondo.add(jlbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 110, -1));

        jtxCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxCargoKeyTyped(evt);
            }
        });
        jpanelfondo.add(jtxCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 110, -1));

        cmbDependencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jpanelfondo.add(cmbDependencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 210, -1));

        jlbMsjAdvertencia2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbMsjAdvertencia2.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjAdvertencia2.setText("jLabel1");
        jpanelfondo.add(jlbMsjAdvertencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 540, -1));

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

        jpanelfondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 1210, 150));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("Funcionarios");
        jpanelfondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5020, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpanelfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 5020, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpanelfondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtxApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxApellidosKeyTyped
        soloLetrasNombres(evt);  // TODO add your handling code here:
    }//GEN-LAST:event_jtxApellidosKeyTyped

    private void jtxNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxNombresActionPerformed

    private void jtxNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxNombresKeyTyped
        soloLetrasNombres(evt);
    }//GEN-LAST:event_jtxNombresKeyTyped

    private void jtxTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxTelefonoKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_jtxTelefonoKeyTyped

    private void jtxIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxIdentificacionActionPerformed

    }//GEN-LAST:event_jtxIdentificacionActionPerformed

    private void jtxIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxIdentificacionKeyTyped
        soloNumeros(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_jtxIdentificacionKeyTyped

    private void jlbRegistrarFU(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbRegistrarFU
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbRegistrarFU

    private void jtxConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxConsultaActionPerformed

    private void jtxConsultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxConsultaKeyTyped

        soloNumeros(evt);
    }//GEN-LAST:event_jtxConsultaKeyTyped

    private void jtxCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxCargoKeyTyped
        soloLetras(evt);
    }//GEN-LAST:event_jtxCargoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnConsulta;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JComboBox<String> cmbDependencia;
    public javax.swing.JComboBox<String> cmbSede;
    public javax.swing.JComboBox<String> cmbTipoDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbApellidos;
    private javax.swing.JLabel jlbCargo;
    private javax.swing.JLabel jlbCorreo;
    private javax.swing.JLabel jlbDependencia;
    public javax.swing.JLabel jlbIdentificacion;
    public javax.swing.JLabel jlbModificarFU;
    private javax.swing.JLabel jlbModificarFuncionario;
    public javax.swing.JLabel jlbMsjAdvertencia;
    public javax.swing.JLabel jlbMsjAdvertencia2;
    private javax.swing.JLabel jlbNombres;
    public javax.swing.JLabel jlbRegistrarFU;
    private javax.swing.JLabel jlbRegistrarFuncionario;
    private javax.swing.JLabel jlbSede;
    private javax.swing.JLabel jlbTelefono;
    public javax.swing.JLabel jlbTipoDoc;
    private javax.swing.JPanel jpanelfondo;
    public javax.swing.JTable jtbTablaUsuarios;
    public javax.swing.JTextField jtxApellidos;
    public javax.swing.JTextField jtxCargo;
    public javax.swing.JTextField jtxConsulta;
    public javax.swing.JTextField jtxIdentificacion;
    public javax.swing.JTextField jtxNombres;
    public javax.swing.JTextField jtxTelefono;
    public javax.swing.JTextField jtxtCorreo;
    // End of variables declaration//GEN-END:variables
}
