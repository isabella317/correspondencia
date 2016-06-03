package Controlador.GestionCorrespondencia;

import static Controlador.GestionUsuario.controladorConfUsuario.VAlidaEmail;
import static Controlador.controladorInicioSesion.AdAdvertencia;
import static Controlador.controladorInicioSesion.Conconexion;
import static Controlador.controladorInicioSesion.DuDaodependencia;
import static Controlador.controladorInicioSesion.DuDaofuncionario;
import DAO.Funciones.DaoDependencia;
import DAO.Funciones.DaoFuncionario;
import DAO.Tablas.Dependencia;
import DAO.Tablas.Funcionario;
import Modelo.ButtonEditor;
import Modelo.ButtonRenderer;
import Vista.Correspondencia.InternoModal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

public class controladorInterno implements ActionListener {

    private InternoModal vistaremitente;
    public static Funcionario FnFuncionario;
    private controladorRegistrarCorrespondencia controladorcorrespondencia;
    private DAO.Funciones.DaoFuncionario DuDafuncionario;
    private String source = "";

    int paginaActual = 0;

    public Funcionario getFuncionario() {
        return FnFuncionario;
    }

    controladorInterno(InternoModal vistaremitente, controladorRegistrarCorrespondencia controladorcorrespondencia, String source) {
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

            if (vistaremitente.jtxNombres.getText().equals("") || vistaremitente.jtxApellidos.getText().equals("") || vistaremitente.jtxTelefono.getText().equals("") || vistaremitente.jtxIdentificacion.getText().equals("") || vistaremitente.jtxtCorreo.getText().equals("") || vistaremitente.jtxCargo.getText().equals("")) {

                vistaremitente.jlbMsjAdvertencia.setText(AdAdvertencia.getDatosInc());
                vistaremitente.jlbMsjAdvertencia.setVisible(true);

            } else {

                boolean BlValido = VAlidaEmail.validateEmail(vistaremitente.jtxtCorreo.getText());
                String StTipoDocumento = vistaremitente.cmbTipoDoc.getSelectedItem().toString();
                String StSede = vistaremitente.cmbSede.getSelectedItem().toString();
                int InDependencia = vistaremitente.cmbDependencia.getSelectedIndex() + 1;
                DuDaodependencia = new DaoDependencia(Conconexion.getConexion());
                Dependencia DpDaoTabla = DuDaodependencia.findDependencia(InDependencia);
                String StCargo = vistaremitente.jtxCargo.getText().toUpperCase();

                if (BlValido == true) {

                    try {

                        DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
                        DuDaofuncionario.create(new Funcionario(vistaremitente.jtxIdentificacion.getText(), StTipoDocumento, vistaremitente.jtxNombres.getText().toUpperCase(), vistaremitente.jtxApellidos.getText().toUpperCase(), StCargo, vistaremitente.jtxTelefono.getText(), vistaremitente.jtxtCorreo.getText(), DpDaoTabla, StSede));
                        DefaultTableModel model = (DefaultTableModel) vistaremitente.jtbTablaUsuarios.getModel();
                        limpiar();
                        borrarFilas(vistaremitente.jtbTablaUsuarios.getRowCount(), model);
                        vistaremitente.jlbMsjAdvertencia.setText(AdAdvertencia.getRegistroFuncionario());
                        vistaremitente.jlbMsjAdvertencia.setVisible(true);

                    } catch (Exception ex) {
                        vistaremitente.jlbMsjAdvertencia.setText(AdAdvertencia.getusuarioRegistrado());
                        vistaremitente.jlbMsjAdvertencia.setVisible(true);
                    }

                } else {
                    vistaremitente.jlbMsjAdvertencia.setText(AdAdvertencia.getCorreoInvalido());
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

                DuDafuncionario = new DaoFuncionario(Conconexion.getConexion());
                DAO.Tablas.Funcionario UsuarioFnModificar = DuDafuncionario.findFuncionario(vistaremitente.jtxConsulta.getText());

                if (UsuarioFnModificar == null) {
                    vistaremitente.jlbMsjAdvertencia2.setText(AdAdvertencia.getIdentificacion());
                    vistaremitente.jlbMsjAdvertencia2.setVisible(true);

                } else {

                    model.addRow(new Object[]{UsuarioFnModificar.getIdentificacion(), UsuarioFnModificar.getNombre(), UsuarioFnModificar.getApellido(), UsuarioFnModificar.getTelefono(), UsuarioFnModificar.getEmail(), "Adicionar"});
                    vistaremitente.jtbTablaUsuarios.getColumn("").setCellRenderer(new ButtonRenderer());
                    vistaremitente.jtbTablaUsuarios.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox(), this));
                    vistaremitente.jtbTablaUsuarios.getColumn("").setPreferredWidth(-50000);
                }

            }
        }

    }

    public void limpiar() {
        vistaremitente.jlbMsjAdvertencia.setVisible(false);
        vistaremitente.jlbMsjAdvertencia2.setVisible(false);
        vistaremitente.jtxApellidos.setText("");
        vistaremitente.jtxNombres.setText("");
        vistaremitente.jtxCargo.setText("");
        vistaremitente.jtxIdentificacion.setText("");
        vistaremitente.jtxtCorreo.setText("");
        vistaremitente.jtxTelefono.setText("");
    }

    public void llenarTabla() {

        DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
        List<DAO.Tablas.Funcionario> UsuarioFnModificar = DuDaofuncionario.ultimosRegistrarCorrespondencia();

        DefaultTableModel model = (DefaultTableModel) vistaremitente.jtbTablaUsuarios.getModel();

        for (int i = 0; i < UsuarioFnModificar.size(); i++) {

            model.addRow(new Object[]{UsuarioFnModificar.get(i).getIdentificacion(), UsuarioFnModificar.get(i).getNombre(), UsuarioFnModificar.get(i).getApellido(), UsuarioFnModificar.get(i).getTelefono(), UsuarioFnModificar.get(i).getEmail(), "Adicionar"});
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
        DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
        FnFuncionario = DuDaofuncionario.findFuncionario(id);
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
