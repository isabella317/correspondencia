package Controlador.GestionCorrespondencia;

import static Controlador.controladorInicioSesion.AdAdvertencia;
import static Controlador.controladorInicioSesion.Conconexion;
import DAO.Funciones.DaoFuncionarioExterno;
import DAO.Tablas.FuncionarioExterno;
import Modelo.ButtonEditor;
import Modelo.ButtonRenderer;
import Vista.Correspondencia.ExternoModal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

public class controladorExterno implements ActionListener {

    private ExternoModal vistaremitente;
    private String source = "";
    public static FuncionarioExterno FnFuncionario;
    private controladorRegistrarCorrespondencia controladorcorrespondencia;
    public static DAO.Funciones.DaoFuncionarioExterno DuDafuncionario;

    int paginaActual = 0;

    public FuncionarioExterno getFuncionario() {
        return FnFuncionario;
    }

    public controladorExterno(ExternoModal vistaremitente, controladorRegistrarCorrespondencia controladorcorrespondencia, String source) {
        this.vistaremitente = vistaremitente;
        this.source = source;
        this.controladorcorrespondencia = controladorcorrespondencia;
        vistaremitente.jlbMsjAdvertencia.setVisible(false);
        vistaremitente.jlbMsjAdvertencia2.setVisible(false);
        vistaremitente.btnConsulta.addActionListener(this);
        vistaremitente.btnAceptar.addActionListener(this);
        llenarTabla();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaremitente.btnAceptar) {

            vistaremitente.jlbMsjAdvertencia2.setVisible(false);
            vistaremitente.jlbMsjAdvertencia.setVisible(false);

            if (vistaremitente.jtxNombres.getText().equals("") || vistaremitente.jtxApellidos.getText().equals("") || vistaremitente.jtxtLugar.getText().equals("") || vistaremitente.jtxIdentificacion.getText().equals("") || vistaremitente.jtxDireccion.getText().equals("")) {

                vistaremitente.jlbMsjAdvertencia.setText(AdAdvertencia.getDatosInc());
                vistaremitente.jlbMsjAdvertencia.setVisible(true);

            } else {

                String StTipoDocumento = vistaremitente.cmbTipoDoc.getSelectedItem().toString();

                try {

                    DuDafuncionario = new DaoFuncionarioExterno(Conconexion.getConexion());
                    DuDafuncionario.create(new FuncionarioExterno(vistaremitente.jtxIdentificacion.getText(), StTipoDocumento, vistaremitente.jtxNombres.getText().toUpperCase(), vistaremitente.jtxApellidos.getText().toUpperCase(), vistaremitente.jtxtLugar.getText().toUpperCase(), vistaremitente.jtxDireccion.getText().toUpperCase()));
                    DefaultTableModel model = (DefaultTableModel) vistaremitente.jtbTablaUsuarios.getModel();
                    limpiar();
                    borrarFilas(vistaremitente.jtbTablaUsuarios.getRowCount(), model);
                    vistaremitente.jlbMsjAdvertencia.setText(AdAdvertencia.getRegistroFuncionario());
                    vistaremitente.jlbMsjAdvertencia.setVisible(true);

                } catch (Exception ex) {
                    vistaremitente.jlbMsjAdvertencia.setText(AdAdvertencia.getusuarioRegistrado());
                    vistaremitente.jlbMsjAdvertencia.setVisible(true);
                }

            }

        } else if (e.getSource() == vistaremitente.btnConsulta) {
            paginaActual = 0;

            DefaultTableModel model = (DefaultTableModel) vistaremitente.jtbTablaUsuarios.getModel();
            borrarFilas(vistaremitente.jtbTablaUsuarios.getRowCount(), model);

            vistaremitente.jlbMsjAdvertencia.setVisible(false);
            vistaremitente.jlbMsjAdvertencia.setVisible(false);

            if (vistaremitente.jtxConsulta.getText().equals("")) {
                vistaremitente.jlbMsjAdvertencia2.setText(AdAdvertencia.getIncIdentificacion());
                vistaremitente.jlbMsjAdvertencia2.setVisible(true);

            } else {

                DuDafuncionario = new DaoFuncionarioExterno(Conconexion.getConexion());
                DAO.Tablas.FuncionarioExterno UsuarioFnModificar = DuDafuncionario.findFuncionarioExterno(vistaremitente.jtxConsulta.getText());

                if (UsuarioFnModificar == null) {
                    vistaremitente.jlbMsjAdvertencia2.setText(AdAdvertencia.getIdentificacion());
                    vistaremitente.jlbMsjAdvertencia2.setVisible(true);

                } else {

                    model.addRow(new Object[]{UsuarioFnModificar.getIdentificacion(), UsuarioFnModificar.getNombre(), UsuarioFnModificar.getApellido(), UsuarioFnModificar.getLugar(), UsuarioFnModificar.getDireccion(), "Adicionar"});
                    vistaremitente.jtbTablaUsuarios.getColumn("").setCellRenderer(new ButtonRenderer());
                    vistaremitente.jtbTablaUsuarios.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox(), this));
                    vistaremitente.jtbTablaUsuarios.getColumn("").setPreferredWidth(-50000);
                }

            }
        }

    }

    public void limpiar() {
        vistaremitente.jtxNombres.setText("");
        vistaremitente.jtxApellidos.setText("");
        vistaremitente.jtxtLugar.setText("");
        vistaremitente.jtxDireccion.setText("");
        vistaremitente.jtxIdentificacion.setText("");

    }

    public void llenarTabla() {

        DuDafuncionario = new DaoFuncionarioExterno(Conconexion.getConexion());
        List<DAO.Tablas.FuncionarioExterno> UsuarioFnModificar = DuDafuncionario.ultimosRegistrarCorrespondencia();

        DefaultTableModel model = (DefaultTableModel) vistaremitente.jtbTablaUsuarios.getModel();

        for (int i = 0; i < UsuarioFnModificar.size(); i++) {

            model.addRow(new Object[]{UsuarioFnModificar.get(i).getIdentificacion(), UsuarioFnModificar.get(i).getNombre(), UsuarioFnModificar.get(i).getApellido(), UsuarioFnModificar.get(i).getLugar(), UsuarioFnModificar.get(i).getDireccion(), "Adicionar"});
            vistaremitente.jtbTablaUsuarios.getColumn("").setCellRenderer(new ButtonRenderer());
            vistaremitente.jtbTablaUsuarios.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox(), this));
            vistaremitente.jtbTablaUsuarios.getColumn("").setPreferredWidth(-50000);

        }

    }

    public void borrarFilas(int InFilas, DefaultTableModel model) {

        for (int i = 0; i < InFilas; i++) {
            model.removeRow(0);
        }
    }

    public void asignarRemitente() {

        String id = (String) vistaremitente.jtbTablaUsuarios.getValueAt(vistaremitente.jtbTablaUsuarios.getSelectedRow(), 0);
        DuDafuncionario = new DaoFuncionarioExterno(Conconexion.getConexion());
        FnFuncionario = DuDafuncionario.findFuncionarioExterno(id);
        if (source.equals("REMITENTE")) {
            controladorcorrespondencia.vistaregistrar.jtxtRutaRemitente.setText(FnFuncionario.getNombre() + " " + FnFuncionario.getApellido() + "-" + id);
            controladorcorrespondencia.vistaregistrar.btnDestinatario.setEnabled(true);
            vistaremitente.dispose();
        } else if (source.equals("DESTINATARIO")) {
            controladorcorrespondencia.vistaregistrar.jtxtRutaDestinatario.setText(FnFuncionario.getNombre() + " " + FnFuncionario.getApellido() + "-" + id);
            controladorcorrespondencia.vistaregistrar.btnDestinatario.setEnabled(true);
            vistaremitente.dispose();

        }

    }
}
