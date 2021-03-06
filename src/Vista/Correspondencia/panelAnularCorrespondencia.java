package Vista.Correspondencia;

public class panelAnularCorrespondencia extends javax.swing.JPanel {

    public panelAnularCorrespondencia() {
        initComponents();
        jlbMsjAdvertencia.setVisible(false);

    }

    public void soloNumeros(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();

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

        jpnFondo = new javax.swing.JPanel();
        jlbHasta = new javax.swing.JLabel();
        jlbTitulo = new javax.swing.JLabel();
        jlbTituloAnulacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTablaUsuarios = new javax.swing.JTable();
        calendarioHasta = new datechooser.beans.DateChooserCombo();
        jlbContAnulacion = new javax.swing.JLabel();
        calendarioDesde = new datechooser.beans.DateChooserCombo();
        btnAceptar = new javax.swing.JButton();
        jlbDesde = new javax.swing.JLabel();
        jtxConsulta = new javax.swing.JTextField();
        jlbMsjAdvertencia = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        jlbContConsulta = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1400, 1000));

        jpnFondo.setBackground(new java.awt.Color(255, 255, 255));
        jpnFondo.setEnabled(false);
        jpnFondo.setPreferredSize(new java.awt.Dimension(5000, 1550));
        jpnFondo.setRequestFocusEnabled(false);
        jpnFondo.setVerifyInputWhenFocusTarget(false);
        jpnFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbHasta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbHasta.setForeground(new java.awt.Color(51, 51, 51));
        jlbHasta.setText("Hasta");
        jpnFondo.add(jlbHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 130, -1));

        jlbTitulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jlbTitulo.setText("Anular Correspondencia");
        jpnFondo.add(jlbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        jlbTituloAnulacion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbTituloAnulacion.setForeground(new java.awt.Color(51, 51, 51));
        jlbTituloAnulacion.setText("Ingrese no. de correspondencia a cancelar");
        jpnFondo.add(jlbTituloAnulacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 300, -1));

        jtbTablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Encargado Documento", "Destinatario", "Número Correspondencia", "Asunto", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbTablaUsuarios.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jtbTablaUsuarios);

        jpnFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 1190, 170));
        jpnFondo.add(calendarioHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, -1, -1));

        jlbContAnulacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Anulación de Consecutivo"));
        jpnFondo.add(jlbContAnulacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 640, 90));
        jpnFondo.add(calendarioDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        btnAceptar.setBackground(new java.awt.Color(153, 0, 0));
        btnAceptar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("ACEPTAR");
        jpnFondo.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 110, 30));

        jlbDesde.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbDesde.setForeground(new java.awt.Color(51, 51, 51));
        jlbDesde.setText("Desde");
        jpnFondo.add(jlbDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 120, -1));

        jtxConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxConsultaKeyTyped(evt);
            }
        });
        jpnFondo.add(jtxConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 170, 20));

        jlbMsjAdvertencia.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlbMsjAdvertencia.setForeground(new java.awt.Color(51, 51, 51));
        jlbMsjAdvertencia.setText("jLabel1");
        jpnFondo.add(jlbMsjAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 540, -1));

        btnConsultar.setBackground(new java.awt.Color(153, 0, 0));
        btnConsultar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("CONSULTAR");
        jpnFondo.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, 110, 30));

        jlbContConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta por Fechas"));
        jpnFondo.add(jlbContConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 640, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpnFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 5020, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpnFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtxConsultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxConsultaKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_jtxConsultaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptar;
    public javax.swing.JButton btnConsultar;
    public datechooser.beans.DateChooserCombo calendarioDesde;
    public datechooser.beans.DateChooserCombo calendarioHasta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbContAnulacion;
    private javax.swing.JLabel jlbContConsulta;
    public javax.swing.JLabel jlbDesde;
    public javax.swing.JLabel jlbHasta;
    public javax.swing.JLabel jlbMsjAdvertencia;
    private javax.swing.JLabel jlbTitulo;
    public javax.swing.JLabel jlbTituloAnulacion;
    private javax.swing.JPanel jpnFondo;
    public javax.swing.JTable jtbTablaUsuarios;
    public javax.swing.JTextField jtxConsulta;
    // End of variables declaration//GEN-END:variables
}
