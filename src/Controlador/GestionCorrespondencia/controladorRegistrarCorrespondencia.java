package Controlador.GestionCorrespondencia;

import static Controlador.GestionCorrespondencia.controladorAnularCorrespondencia.DeStringADate;
import static Controlador.controladorInicioSesion.AdAdvertencia;
import static Controlador.controladorInicioSesion.Conconexion;
import static Controlador.controladorInicioSesion.UsValido;
import DAO.Funciones.DaoCEnviada;
import DAO.Funciones.DaoCRecibida;
import DAO.Tablas.CEnviada;
import DAO.Tablas.CRecibida;
import Vista.Correspondencia.ExternoModal;
import Vista.Correspondencia.panelRegistrarCorrespondencia;
import Vista.Correspondencia.InternoModal;
import Vista.vistaPanelPrincipal;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class controladorRegistrarCorrespondencia implements ActionListener, ItemListener {

    protected panelRegistrarCorrespondencia vistaregistrar = new panelRegistrarCorrespondencia();
    private Date fechaActual = new Date();
    private vistaPanelPrincipal v;
    private controladorExterno controladordestinatario;
    private controladorInterno controladorremitente;
    private File documento = null;
    private DAO.Funciones.DaoCEnviada DuDaEnviado;
    private DAO.Funciones.DaoCRecibida DuDaRecibida;
    protected SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");

    public controladorRegistrarCorrespondencia(panelRegistrarCorrespondencia vistaregistrar, vistaPanelPrincipal v) {

        this.vistaregistrar = vistaregistrar;
        this.v = v;
        vistaregistrar.btnDestinatario.addActionListener(this);
        vistaregistrar.btnRemitente.addActionListener(this);
        vistaregistrar.btnDocumento.addActionListener(this);
        vistaregistrar.btnRegistrar.addActionListener(this);
        vistaregistrar.jtxFecha.setText(formateador.format(fechaActual));
        vistaregistrar.btnDestinatario.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaregistrar.btnRemitente) {

            if (vistaregistrar.cmbOrigen.getSelectedItem().toString().equals("INTERNO")) {
                vistaregistrar.jtxtDestino.setText("EXTERNO");
                asignarInterno("REMITENTE");
            } else {
                vistaregistrar.jtxtDestino.setText("INTERNO");
                asignarExterno("REMITENTE");

            }

        } else if (e.getSource() == vistaregistrar.btnDocumento) {

            String ruta = "";

            FileNameExtensionFilter filtro = new FileNameExtensionFilter("PDF", "pdf");
            JFileChooser chooser = new JFileChooser();
            chooser.setPreferredSize(new Dimension(600, 400));
            chooser.setFileFilter(filtro);
            chooser.setAcceptAllFileFilterUsed(false);

            chooser.setDialogTitle("Archivo PDF");

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                ruta = chooser.getSelectedFile().toString();
                vistaregistrar.jtxtRutaDocumento.setText(ruta);
                documento = chooser.getSelectedFile();
                System.out.println(documento);
            }

        } else if (e.getSource() == vistaregistrar.btnDestinatario) {

            if (vistaregistrar.jtxtDestino.getText().equals("INTERNO")) {
                asignarInterno("DESTINATARIO");
            } else {
                asignarExterno("DESTINATARIO");
            }

        } else if (e.getSource() == vistaregistrar.btnRegistrar) {

            vistaregistrar.jlbMsjAdvertencia.setVisible(false);
            if (vistaregistrar.jtxAsunto.getText().equals("") || vistaregistrar.jeditObservaciones.getText().equals("") || vistaregistrar.jtxtRutaDocumento.getText().equals("") || vistaregistrar.jtxtRutaRemitente.getText().equals("") || vistaregistrar.jtxtRutaDestinatario.getText().equals("") || documento == null) {
                vistaregistrar.jlbMsjAdvertencia.setText(AdAdvertencia.getDatosInc());
                vistaregistrar.jlbMsjAdvertencia.setVisible(true);

            } else if (vistaregistrar.cmbOrigen.getSelectedItem().toString().equals("INTERNO")) {

                //enviada
                DuDaEnviado = new DaoCEnviada(Conconexion.getConexion());
                int ultimoregistro = DuDaEnviado.getUltimoRegistro();
                Date fecha =DeStringADate(vistaregistrar.jtxFecha.getText());
                DuDaEnviado.create(new CEnviada((ultimoregistro + 1),fecha , vistaregistrar.jtxAsunto.getText().toUpperCase(), vistaregistrar.jeditObservaciones.getText(), vistaregistrar.cmbTipoOrigen.getSelectedItem().toString(), controladorremitente.getFuncionario(), controladordestinatario.getFuncionario(),               UsValido.getIdFuncionario().getNombre()+" "+UsValido.getIdFuncionario().getApellido()+"-"+UsValido.getIdFuncionario().getIdentificacion(),true));
                File directorio = new File("C:\\Correspondencia");
                directorio.mkdir();
                directorio = new File("C:\\Correspondencia\\Enviada");
                directorio.mkdir();
                File nvoArchivo = new File(vistaregistrar.jtxFecha.getText() + "-" + (ultimoregistro + 1) + ".pdf");
                documento.renameTo(new File("C:\\Correspondencia\\Enviada\\" + nvoArchivo.getName()));
                limpiar();
                vistaregistrar.jlbMsjAdvertencia.setText("Correspondencia registrada satisfactoriamente.");
                vistaregistrar.jlbMsjAdvertencia.setVisible(true);

            } else {

                //recibida
                DuDaRecibida = new DaoCRecibida(Conconexion.getConexion());
                int ultimoregistro = DuDaRecibida.getUltimoRegistro();
                DuDaRecibida.create(new CRecibida((ultimoregistro + 1), vistaregistrar.jtxFecha.getText(), vistaregistrar.jtxAsunto.getText().toUpperCase(), vistaregistrar.jeditObservaciones.getText(), vistaregistrar.cmbTipoOrigen.getSelectedItem().toString(), controladorremitente.getFuncionario(), controladordestinatario.getFuncionario()));
                File directorio = new File("C:\\Correspondencia");
                directorio.mkdir();
                directorio = new File("C:\\Correspondencia\\Recibida");
                directorio.mkdir();

                File nvoArchivo = new File(vistaregistrar.jtxFecha.getText() + "-" + (ultimoregistro + 1) + ".pdf");
                documento.renameTo(new File("C:\\Correspondencia\\Recibida\\" + nvoArchivo.getName()));
                limpiar();
                vistaregistrar.jlbMsjAdvertencia.setText("Correspondencia registrada satisfactoriamente.");
                vistaregistrar.jlbMsjAdvertencia.setVisible(true);

            }
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }

    public void limpiar() {
        vistaregistrar.jlbMsjAdvertencia.setVisible(false);
        vistaregistrar.jtxAsunto.setText("");
        vistaregistrar.jeditObservaciones.setText("");
        vistaregistrar.jtxtRutaDestinatario.setText("");
        vistaregistrar.jtxtRutaDocumento.setText("");
        vistaregistrar.jtxtRutaRemitente.setText("");
        documento = null;
    }

    public void asignarInterno(String source) {

        InternoModal vistaremitente = new InternoModal(v, true);
        controladorremitente = new controladorInterno(vistaremitente, this, source);
        vistaremitente.setLocationRelativeTo(null);
        vistaremitente.setVisible(true);
    }

    public void asignarExterno(String source) {
        ExternoModal vistaremitente = new ExternoModal(v, true);
        controladordestinatario = new controladorExterno(vistaremitente, this, source);
        vistaremitente.setLocationRelativeTo(null);
        vistaremitente.setVisible(true);
    }

}
