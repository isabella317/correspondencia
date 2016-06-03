package Controlador.GestionCorrespondencia;

import static Controlador.controladorInicioSesion.Conconexion;
import DAO.Funciones.DaoCEnviada;
import Modelo.ButtonEditor;
import Modelo.ButtonRenderer;
import Vista.Correspondencia.panelAnularCorrespondencia;
import Vista.vistaPanelPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class controladorAnularCorrespondencia implements ActionListener {

    panelAnularCorrespondencia vistacorrespondencia = new panelAnularCorrespondencia();
    vistaPanelPrincipal panelprincipal;
    String fecha2;
    Date fechainicial;
    Date fechafinal;
    int numero;
    private DAO.Funciones.DaoCEnviada DuDaEnviada;

    boolean paso = false;

    public controladorAnularCorrespondencia(panelAnularCorrespondencia vistacorrespondencia) {
        this.vistacorrespondencia = vistacorrespondencia;
        vistacorrespondencia.btnConsultar.addActionListener(this);
        vistacorrespondencia.btnAceptar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistacorrespondencia.btnConsultar) {

            fechainicial = DeStringADate(vistacorrespondencia.calendarioDesde.getText());
            fechafinal = DeStringADate(vistacorrespondencia.calendarioHasta.getText());
            boolean seguir = compararFechas(fechafinal, fechainicial);

            if (seguir == false) {
                vistacorrespondencia.jlbMsjAdvertencia.setText("El rango de fechas es errónea.");
                vistacorrespondencia.jlbMsjAdvertencia.setVisible(true);

            } else {
                getRegistros(vistacorrespondencia.calendarioDesde.getText(), vistacorrespondencia.calendarioHasta.getText());

            }
        } else if (e.getSource() == vistacorrespondencia.btnAceptar) {

            if (vistacorrespondencia.jtxConsulta.getText().equals("")) {
                vistacorrespondencia.jlbMsjAdvertencia.setText("Debe ingresar el no. consecutivo a cancelar.");
                vistacorrespondencia.jlbMsjAdvertencia.setVisible(true);
            } else {
                DuDaEnviada = new DaoCEnviada(Conconexion.getConexion());
                DAO.Tablas.CEnviada correspondenciaE = DuDaEnviada.findCEnviada(Integer.parseInt(vistacorrespondencia.jtxConsulta.getText()));
                if (correspondenciaE == null) {
                    vistacorrespondencia.jlbMsjAdvertencia.setText("El número de correspondencia a cancelar no existe.");
                    vistacorrespondencia.jlbMsjAdvertencia.setVisible(true);
                } else if (correspondenciaE.getEstado() == false) {
                    vistacorrespondencia.jlbMsjAdvertencia.setText("El número de correspondencia ya se encuentra cancelado.");
                    vistacorrespondencia.jlbMsjAdvertencia.setVisible(true);
                } else {
                    try {
                        correspondenciaE.setEstado(false);
                        DuDaEnviada.edit(correspondenciaE);
                        vistacorrespondencia.jlbMsjAdvertencia.setText("El número de correspondencia digitado se ha cancelado satisfactoriamente.");
                        vistacorrespondencia.jlbMsjAdvertencia.setVisible(true);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Problema al actualizar correspondencia.");
                    }
                }

            }
        }
    }

    public static boolean compararFechas(Date actual, Date ingresado) {

        boolean años = ingresado.getYear() == actual.getYear();
        boolean meses = ingresado.getMonth() == actual.getMonth();

        if (ingresado.getYear() > actual.getYear()) {
            return false;
        } else if (años == true && ingresado.getMonth() > actual.getMonth()) {
            return false;

        } else if (años == true && meses == true && ingresado.getDate() > actual.getDate()) {

            return false;
        }
        return true;
    }

    public static Date DeStringADate(String fecha) {
        fecha = fecha.replaceAll("/", "-");
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
        String strFecha = fecha;
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(strFecha);

            return fechaDate;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return fechaDate;
        }

    }

    public void borrarFilas(int InFilas, DefaultTableModel model) {

        for (int i = 0; i < InFilas; i++) {
            model.removeRow(0);
        }
    }

    public void cancelarCorrespondencia() {
        try {
            int id = (int) vistacorrespondencia.jtbTablaUsuarios.getValueAt(vistacorrespondencia.jtbTablaUsuarios.getSelectedRow(), 3);
            DuDaEnviada = new DaoCEnviada(Conconexion.getConexion());
            DAO.Tablas.CEnviada correspondenciaE = DuDaEnviada.findCEnviada(id);
            correspondenciaE.setEstado(false);
            DuDaEnviada.edit(correspondenciaE);
            vistacorrespondencia.jlbMsjAdvertencia.setText("El número de correspondencia digitado se ha cancelado satisfactoriamente.");
            vistacorrespondencia.jlbMsjAdvertencia.setVisible(true);
            DefaultTableModel model = (DefaultTableModel) vistacorrespondencia.jtbTablaUsuarios.getModel();
            borrarFilas(vistacorrespondencia.jtbTablaUsuarios.getRowCount(), model);

            getRegistros(fechainicial.toString(), fechafinal.toString());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema al consultar en BD.");
        }

    }

    public void getRegistros(String fechaInicial, String fechaFinal) {

        DefaultTableModel model = (DefaultTableModel) vistacorrespondencia.jtbTablaUsuarios.getModel();
        borrarFilas(vistacorrespondencia.jtbTablaUsuarios.getRowCount(), model);

        DuDaEnviada = new DaoCEnviada(Conconexion.getConexion());
        List<DAO.Tablas.CEnviada> correspondenciaEn = DuDaEnviada.getCorrespondenciaIntervalo(fechaInicial, fechaFinal);

        if (correspondenciaEn.isEmpty() || correspondenciaEn == null) {
            vistacorrespondencia.jlbMsjAdvertencia.setText("No existen registros en el intervalo definido.");
            vistacorrespondencia.jlbMsjAdvertencia.setVisible(true);

        } else {

            model = (DefaultTableModel) vistacorrespondencia.jtbTablaUsuarios.getModel();
            for (int i = 0; i < correspondenciaEn.size(); i++) {

                model.addRow(new Object[]{correspondenciaEn.get(i).getFecha().toString(), correspondenciaEn.get(i).getEncargado(), correspondenciaEn.get(i).getIdFuncionarioExterno().getNombre() + " " + correspondenciaEn.get(i).getIdFuncionarioExterno().getApellido(), correspondenciaEn.get(i).getConsecutivoE(), correspondenciaEn.get(i).getAsunto(), "Cancelar"});
                vistacorrespondencia.jtbTablaUsuarios.getColumn("").setCellRenderer(new ButtonRenderer());
                vistacorrespondencia.jtbTablaUsuarios.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox(), this));
            }

        }

    }
}
