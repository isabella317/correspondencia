package Controlador.GestionCorrespondencia;

//import static Controlador.ControladorInicioSesion.conexion;
import static Controlador.ControladorInicioSesion.UsValido;
import Controlador.controladorPanelPrincipal;
//import Modelo.ConexionBase;
//import static Modelo.ConexionBase.cargos;
//import static Modelo.ConexionBase.encargados;
import Modelo.Entidades.ManejoArchivo;
import Vista.GestionCorrespondencia.vistaRegistrarCorrespondencia;
import Vista.vistaPanelPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.*;
import javax.swing.SwingConstants;

public class controladorRegistrarCorrespondencia implements ActionListener, MouseListener, ItemListener {

    vistaRegistrarCorrespondencia vistaregistrar = new vistaRegistrarCorrespondencia(UsValido);
    vistaPanelPrincipal panelprincipal;
    
    
    private String ruta;
    public static Calendar fecha = new GregorianCalendar();
    public static Date d = fecha.getTime();
    ManejoArchivo manejo = new ManejoArchivo();
    public static int anio = fecha.get(Calendar.YEAR);
    public static int mes = (fecha.get(Calendar.MONTH)) + 1;
    public static int dia = fecha.get(Calendar.DAY_OF_MONTH);
    
    /*INICIALIZACION VARIABLES*/
    String estado = "INTERNO";
    File documento;
    String f = "";
    String origen = "";
    int depen;
    String remitente = "";
    String destino = "";
    String tdestinatario = "";
    String asun = "";
    String obs = "";
    String torigen = "";
    String path = "";
    Boolean confidencial = false;
    FileInputStream fileInputStream = null;

    public controladorRegistrarCorrespondencia(vistaRegistrarCorrespondencia vistaregistrar) throws SQLException {

        this.vistaregistrar = vistaregistrar;
        agregarItemsDependencia();
//        vistaregistrar.encargado.setText(encargados.get(0));
        vistaregistrar.jtxtRemitente.setEditable(false);
        vistaregistrar.jtxtFecha.setText(anio + "-" + (mes) + "-" + dia);
        vistaregistrar.jtxtFecha.setHorizontalAlignment(SwingConstants.CENTER);
        vistaregistrar.jcomboOrigen.addItemListener(this);
        vistaregistrar.jcomboDependencia.addItemListener(this);
        vistaregistrar.jtxtRemitente.addActionListener(this);
        vistaregistrar.enviar.addActionListener(this);
        vistaregistrar.btnDocumento.addActionListener(this);
        vistaregistrar.jcomboDestino.addItemListener(this);
        vistaregistrar.jcomboDestinatario.addItemListener(this);
        vistaregistrar.jcomboTipoOrigen.addItemListener(this);
        vistaregistrar.limpiar.addActionListener(this);
        vistaregistrar.atras.addMouseListener(this);

        ruta = "";

    }

    void agregarItemsDependencia() throws SQLException {
        // conexion.anadirDependencia();
        // vistaregistrar.dependencia.setModel(new DefaultComboBoxModel(cargos.toArray()));

    }

    void limpiar() {
        vistaregistrar.jcomboOrigen.setSelectedIndex(0);
        vistaregistrar.jcomboDestino.setSelectedIndex(0);
        vistaregistrar.jcomboDestinatario.setSelectedIndex(0);
        vistaregistrar.jeditAsunto.setText("");
        vistaregistrar.jeditObservaciones.setText("");
        vistaregistrar.jcomboTipoOrigen.setSelectedIndex(0);
        vistaregistrar.jcheckConfidencial.setSelected(false);
        vistaregistrar.jtxtRuta.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaregistrar.limpiar) {

            limpiar();

        } else if (e.getSource() == vistaregistrar.btnDocumento) {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("PDF", "pdf");
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(filtro);
            chooser.setDialogTitle("Archivo PDF");

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                String archivo = chooser.getSelectedFile().getAbsolutePath();
                path = chooser.getSelectedFile().toString();
                documento = chooser.getSelectedFile();
                String PATH = documento.getAbsolutePath();

            }
        } else if (e.getSource() == vistaregistrar.enviar) {

            if (vistaregistrar.jeditAsunto.getText().equals("") || vistaregistrar.jtxtRemitente.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el campo asunto y remitente");
            } else if (vistaregistrar.jcomboOrigen.getSelectedItem().toString() == "INTERNO") {
               
                    //correspondencia entrante

                    f = anio + "-" + mes + "-" + dia;
                    origen = "INTERNO";
                    depen = vistaregistrar.jcomboDependencia.getSelectedIndex() + 1;
                    remitente = vistaregistrar.jtxtRemitente.getText().toUpperCase();
                    destino = vistaregistrar.jcomboDestino.getSelectedItem().toString();
                    tdestinatario = vistaregistrar.jcomboDestinatario.getSelectedItem().toString();
                    asun = vistaregistrar.jeditAsunto.getText();
                    obs = vistaregistrar.jeditObservaciones.getText();
                    torigen = vistaregistrar.jcomboTipoOrigen.getSelectedItem().toString();
                    confidencial = vistaregistrar.jcheckConfidencial.isSelected();

//                    CorrespondenciaEntrante c1 = new CorrespondenciaEntrante(f, origen, remitente, destino, tdestinatario, asun, obs, torigen, documento, confidencial, usuarioautenticado.getNombre1() + " " + usuarioautenticado.getApellido1());
//                    conexion.ingresarCorrespondencia(origen, c1, depen, confidencial, remitente, f);
                    JOptionPane.showMessageDialog(null, "Guardado exitoso!", "Guardado", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    if (documento != null) {
                        File folder = new File("C:\\Users\\Public\\Downloads\\CORRESPONDENCIA");
                        folder.mkdirs();
//                        String doc = conexion.ConsultaDocumento();
//                      System.out.println(Integer.parseInt(doc));
                       
                      //     manejo.copiarArchivo(path, "C:\\Users\\Public\\Downloads\\CORRESPONDENCIA\\" + doc + "(" + f + ").pdf");
                        
                    }

                    documento = null;
                
            } else if (vistaregistrar.jtxtRemitente.equals("")) {
                JOptionPane.showMessageDialog(panelprincipal, "Debe ingresar nombre del encargado");
            } else {
                //correspondencia saliente
                f = anio + "-" + mes + "-" + dia;
                origen = "EXTERNO";
                remitente = vistaregistrar.jtxtRemitente.getText().toUpperCase();
                destino = vistaregistrar.jcomboDestino.getSelectedItem().toString();
                tdestinatario = vistaregistrar.jcomboDestinatario.getSelectedItem().toString();
                asun = vistaregistrar.jeditAsunto.getText();
                obs = vistaregistrar.jeditObservaciones.getText();
                torigen = vistaregistrar.jcomboTipoOrigen.getSelectedItem().toString();
                confidencial = vistaregistrar.jcheckConfidencial.isSelected();
//                CorrespondenciaEntrante c1 = new CorrespondenciaEntrante(f, origen, remitente, destino, tdestinatario, asun, obs, torigen, documento, confidencial, usuarioautenticado.getNombre1() + " " + usuarioautenticado.getApellido1());
//                conexion.ingresarCorrespondencia(origen, c1, depen, confidencial, remitente, f);
                JOptionPane.showMessageDialog(null, "Guardado exitoso!", "Guardado", JOptionPane.INFORMATION_MESSAGE);

                if (documento != null) {
                    
                        File folder = new File("C:\\Users\\Public\\Downloads\\CORRESPONDENCIA");
                        folder.mkdirs();
//                        String doc = conexion.ConsultaDocumento();
                       // System.out.println(Integer.parseInt(doc));
                       
                        //    manejo.copiarArchivo(path, "C:\\Users\\Public\\Downloads\\CORRESPONDENCIA\\" + doc + "(" + f + ").pdf");
                       
                    
                }
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vistaregistrar.atras) {
            panelprincipal = new vistaPanelPrincipal(UsValido);
            controladorPanelPrincipal controladorP = new controladorPanelPrincipal(panelprincipal);
            panelprincipal.setVisible(true);
            panelprincipal.setLocationRelativeTo(vistaregistrar);
            vistaregistrar.dispose();

        }

    }

    @Override
    public void mousePressed(MouseEvent e
    ) {
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if ((e.getStateChange() == ItemEvent.SELECTED)) {

        } else if (vistaregistrar.jcomboOrigen.getSelectedItem().toString() == "INTERNO") {
            vistaregistrar.jcomboDependencia.enable(true);
            vistaregistrar.jtxtRemitente.setEditable(false);
            int posicion = vistaregistrar.jcomboDependencia.getSelectedIndex();
         //   vistaregistrar.encargado.setText(encargados.get(posicion));

        } else if (vistaregistrar.jcomboOrigen.getSelectedItem().toString() == "EXTERNO") {
            vistaregistrar.jcomboDependencia.enable(false);
            vistaregistrar.jtxtRemitente.setText("");
            vistaregistrar.jtxtRemitente.setEditable(true);

        }

    }

}
