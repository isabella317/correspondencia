package Vista.GestionInformes;

import static Controlador.controladorInicioSesion.UsValido;
import Vista.*;
import java.awt.Image;
import java.awt.Toolkit;



public class vistaConsecutivos extends javax.swing.JFrame {

    
    vistaPanelPrincipal  vistapanelprincipalinformes = new vistaPanelPrincipal(UsValido);
    vistaPanelPrincipal va;
   
    
    
    public vistaConsecutivos(DAO.Tablas.Usuario usuario) {
        initComponents();
        String nombres = usuario.getIdFuncionario().getNombre() + " " + usuario.getIdFuncionario().getApellido();
        n.setText(nombres);
        this.setTitle("Panel Correspodencia");
        this.setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png"));
        this.setIconImage(icon);
        this.setLocationRelativeTo(null);
        
    }

   

   

   
   

   public void setvistapanelprincipalinformes (vistaPanelPrincipal vistapanelprincipalinformes){
       
 this.vistapanelprincipalinformes= vistapanelprincipalinformes ;
  }

   public vistaPanelPrincipal getvistapanelprincipalinformes (){
   return vistapanelprincipalinformes;
   }
  


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        fechafinal = new datechooser.beans.DateChooserCombo();
        filtro = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fechainicial = new datechooser.beans.DateChooserCombo();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAnulada = new javax.swing.JTable();
        n = new javax.swing.JLabel();
        atras = new javax.swing.JLabel();
        fecha = new javax.swing.JButton();
        filtroconsecutivo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

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
        jTextField7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setText("                                                              Informe de Consecutivos/Anulados");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7jTextField1ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 20, 2000, 54));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 1020, 10));
        jPanel4.add(fechafinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));

        filtro.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        filtro.setText("Filtrar por :");
        jPanel4.add(filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, -1, 20));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel4.setText("Fecha Inicial  :");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, 20));
        jPanel4.add(fechainicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        tablaAnulada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Destinatario", "Asunto", "Número Correspondencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAnulada);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 870, 340));

        n.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        n.setText("Jpanel");
        jPanel4.add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 210, 30));

        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        jPanel4.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 470, -1, -1));

        fecha.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        fecha.setText("Aceptar");
        fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanel4.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, 60, 30));

        filtroconsecutivo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        filtroconsecutivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONSECUTIVO", "ANULADA" }));
        jPanel4.add(filtroconsecutivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 140, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel5.setText("Fecha Final  :");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, 20));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1000, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField7jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(vistaConsecutivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaConsecutivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaConsecutivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaConsecutivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    public javax.swing.JButton fecha;
    public datechooser.beans.DateChooserCombo fechafinal;
    public datechooser.beans.DateChooserCombo fechainicial;
    private javax.swing.JLabel filtro;
    public javax.swing.JComboBox<String> filtroconsecutivo;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField7;
    public javax.swing.JLabel n;
    public javax.swing.JTable tablaAnulada;
    // End of variables declaration//GEN-END:variables
}
