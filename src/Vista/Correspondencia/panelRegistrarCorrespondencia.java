package Vista.Correspondencia;

import java.awt.Frame;


public class panelRegistrarCorrespondencia extends javax.swing.JPanel {

    public panelRegistrarCorrespondencia() {
        initComponents();
        jlbMsjAdvertencia.setVisible(false);

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
        jlbUsuario = new javax.swing.JLabel();
        jtxAsunto = new javax.swing.JTextField();
        jlbMsjAdvertencia2 = new javax.swing.JLabel();
        jlbTitulo = new javax.swing.JLabel();
        jlbMsjAdvertencia3 = new javax.swing.JLabel();
        jtxFecha = new javax.swing.JTextField();
        jlbMsjAdvertencia4 = new javax.swing.JLabel();
        cmbTipoOrigen = new javax.swing.JComboBox();
        jlbMsjAdvertencia5 = new javax.swing.JLabel();
        jtxtRutaDocumento = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jeditObservaciones = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jlbUsuario1 = new javax.swing.JLabel();
        cmbOrigen = new javax.swing.JComboBox();
        jlbUsuario2 = new javax.swing.JLabel();
        jtxtRutaRemitente = new javax.swing.JTextField();
        btnRemitente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlbUsuario3 = new javax.swing.JLabel();
        jlbUsuario4 = new javax.swing.JLabel();
        jtxtRutaDestinatario = new javax.swing.JTextField();
        btnDestinatario = new javax.swing.JButton();
        btnDocumento = new javax.swing.JButton();
        jlbMsjAdvertencia = new javax.swing.JLabel();
        jtxtDestino = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1400, 1000));

        jpnFondo.setBackground(new java.awt.Color(255, 255, 255));
        jpnFondo.setEnabled(false);
        jpnFondo.setPreferredSize(new java.awt.Dimension(5000, 1550));
        jpnFondo.setRequestFocusEnabled(false);
        jpnFondo.setVerifyInputWhenFocusTarget(false);
        jpnFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbUsuario.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbUsuario.setForeground(new java.awt.Color(51, 51, 51));
        jlbUsuario.setText("Persona Remitente");
        jpnFondo.add(jlbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 130, -1));

        jtxAsunto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxAsuntoKeyTyped(evt);
            }
        });
        jpnFondo.add(jtxAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 320, 20));

        jlbMsjAdvertencia2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbMsjAdvertencia2.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjAdvertencia2.setText("Tipo Origen Envio");
        jpnFondo.add(jlbMsjAdvertencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 140, -1));

        jlbTitulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jlbTitulo.setText("Registrar Correspondencia");
        jpnFondo.add(jlbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        jlbMsjAdvertencia3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbMsjAdvertencia3.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjAdvertencia3.setText("Fecha de registro  ");
        jpnFondo.add(jlbMsjAdvertencia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 140, -1));

        jtxFecha.setEditable(false);
        jtxFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxFechaKeyTyped(evt);
            }
        });
        jpnFondo.add(jtxFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 320, 20));

        jlbMsjAdvertencia4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbMsjAdvertencia4.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjAdvertencia4.setText("Asunto                      ");
        jpnFondo.add(jlbMsjAdvertencia4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 140, -1));

        cmbTipoOrigen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OFICINA CORREO", "DIRECTO" }));
        jpnFondo.add(cmbTipoOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 320, -1));

        jlbMsjAdvertencia5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbMsjAdvertencia5.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjAdvertencia5.setText("Observaciones");
        jpnFondo.add(jlbMsjAdvertencia5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 140, -1));

        jtxtRutaDocumento.setEditable(false);
        jpnFondo.add(jtxtRutaDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 320, -1));

        btnRegistrar.setBackground(new java.awt.Color(153, 0, 0));
        btnRegistrar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        jpnFondo.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 110, 30));

        jeditObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jeditObservacionesKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jeditObservaciones);

        jpnFondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 320, 50));

        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Básicos"));
        jpnFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 560, 290));

        jlbUsuario1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbUsuario1.setForeground(new java.awt.Color(51, 51, 51));
        jlbUsuario1.setText("Documento");
        jpnFondo.add(jlbUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 120, -1));

        cmbOrigen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INTERNO", "EXTERNO" }));
        cmbOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrigenActionPerformed(evt);
            }
        });
        jpnFondo.add(cmbOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 320, -1));

        jlbUsuario2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbUsuario2.setForeground(new java.awt.Color(51, 51, 51));
        jlbUsuario2.setText("Tipo Origen");
        jpnFondo.add(jlbUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 120, -1));

        jtxtRutaRemitente.setEditable(false);
        jpnFondo.add(jtxtRutaRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 170, 320, -1));

        btnRemitente.setBackground(new java.awt.Color(153, 0, 0));
        btnRemitente.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnRemitente.setForeground(new java.awt.Color(255, 255, 255));
        btnRemitente.setText("...");
        btnRemitente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemitenteActionPerformed(evt);
            }
        });
        jpnFondo.add(btnRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 170, -1, 20));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Remitente"));
        jpnFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 560, 110));

        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Destinatario"));
        jpnFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 560, 110));

        jlbUsuario3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbUsuario3.setForeground(new java.awt.Color(51, 51, 51));
        jlbUsuario3.setText("Tipo Destino");
        jpnFondo.add(jlbUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 120, -1));

        jlbUsuario4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbUsuario4.setForeground(new java.awt.Color(51, 51, 51));
        jlbUsuario4.setText("Persona Destinatario");
        jpnFondo.add(jlbUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 140, -1));

        jtxtRutaDestinatario.setEditable(false);
        jpnFondo.add(jtxtRutaDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, 290, -1));

        btnDestinatario.setBackground(new java.awt.Color(153, 0, 0));
        btnDestinatario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnDestinatario.setForeground(new java.awt.Color(255, 255, 255));
        btnDestinatario.setText("...");
        jpnFondo.add(btnDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 310, -1, 20));

        btnDocumento.setBackground(new java.awt.Color(153, 0, 0));
        btnDocumento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnDocumento.setForeground(new java.awt.Color(255, 255, 255));
        btnDocumento.setText("...");
        jpnFondo.add(btnDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, -1, -1));

        jlbMsjAdvertencia.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbMsjAdvertencia.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjAdvertencia.setText("jLabel1");
        jpnFondo.add(jlbMsjAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 410, 540, -1));

        jtxtDestino.setEditable(false);
        jpnFondo.add(jtxtDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, 290, -1));

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

    private void jtxFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxFechaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxFechaKeyTyped

    private void jtxAsuntoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxAsuntoKeyTyped
        validacionAsunto(evt);
    }//GEN-LAST:event_jtxAsuntoKeyTyped

    private void cmbOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOrigenActionPerformed

    private void jeditObservacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jeditObservacionesKeyTyped
        validacionObservaciones(evt);
    }//GEN-LAST:event_jeditObservacionesKeyTyped

    private void btnRemitenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemitenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemitenteActionPerformed
    public void validacionAsunto(java.awt.event.KeyEvent evt) {

        char car = evt.getKeyChar();
        int limite = 40;

        if (jtxAsunto.getText().length() == limite) {
            evt.consume();

        } else if ((((int) car >= 65 && (int) car <= 90)) || (((int) car >= 97 && (int) car <= 122)) || (int) car == 32) {

        } else {
            evt.consume();
        }
    }

    public void validacionObservaciones(java.awt.event.KeyEvent evt) {

        int limite = 120;

        if (jeditObservaciones.getText().length() == limite) {
            evt.consume();

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDestinatario;
    public javax.swing.JButton btnDocumento;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JButton btnRemitente;
    public javax.swing.JComboBox cmbOrigen;
    public javax.swing.JComboBox cmbTipoOrigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JEditorPane jeditObservaciones;
    public javax.swing.JLabel jlbMsjAdvertencia;
    public javax.swing.JLabel jlbMsjAdvertencia2;
    public javax.swing.JLabel jlbMsjAdvertencia3;
    public javax.swing.JLabel jlbMsjAdvertencia4;
    public javax.swing.JLabel jlbMsjAdvertencia5;
    private javax.swing.JLabel jlbTitulo;
    public javax.swing.JLabel jlbUsuario;
    public javax.swing.JLabel jlbUsuario1;
    public javax.swing.JLabel jlbUsuario2;
    public javax.swing.JLabel jlbUsuario3;
    public javax.swing.JLabel jlbUsuario4;
    private javax.swing.JPanel jpnFondo;
    public javax.swing.JTextField jtxAsunto;
    public javax.swing.JTextField jtxFecha;
    public javax.swing.JTextField jtxtDestino;
    public javax.swing.JTextField jtxtRutaDestinatario;
    public javax.swing.JTextField jtxtRutaDocumento;
    public javax.swing.JTextField jtxtRutaRemitente;
    // End of variables declaration//GEN-END:variables
}