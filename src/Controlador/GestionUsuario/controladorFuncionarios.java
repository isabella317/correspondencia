package Controlador.GestionUsuario;


import Modelo.Entidades.*;
import Vista.vistaPanelPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static Controlador.ControladorInicioSesion.AdAdvertencia;
import static Controlador.ControladorInicioSesion.Conconexion;
import static Controlador.ControladorInicioSesion.DuDaodependencia;
import static Controlador.ControladorInicioSesion.DuDaofuncionario;
import static Controlador.ControladorInicioSesion.UsValido;
import static Controlador.GestionUsuario.controladorConfUsuario.VAlidaEmail;
import DAO.Funciones.DaoDependencia;
import DAO.Funciones.DaoFuncionario;
import DAO.Tablas.Dependencia;
import DAO.Tablas.Funcionario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vistaGestionUsuario.panelFuncionario;

/*CLASE ENCARGADA DE CONTROL DE GESTION FUNCIONARIOS*/
public final class controladorFuncionarios implements MouseListener, ActionListener, KeyListener {

    private panelFuncionario jfrGestionFuncionario = new panelFuncionario ();
    vistaPanelPrincipal jfrPanelPrincipal;
    public Seguridad SgSeguridad = new Seguridad();
    DAO.Funciones.DaoFuncionario DuDafuncionario;
    Funcionario funcionario;
    Funcionario FnFuncionario;

    public controladorFuncionarios(panelFuncionario  jfrGestionFuncionario) {

        this.jfrGestionFuncionario = jfrGestionFuncionario;
        DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
        List<DAO.Tablas.Funcionario> UsuarioUsModificar = DuDaofuncionario.funcionarioXApellidos();
        llenarLista(UsuarioUsModificar);
        jfrGestionFuncionario.jlbRegistrarFU.addMouseListener(this);
        jfrGestionFuncionario.jlbModificarFU.addMouseListener(this);
        jfrGestionFuncionario.btnActualizar.setEnabled(false);
        jfrGestionFuncionario.btnActualizar.addActionListener(this);
        jfrGestionFuncionario.btnLimpiar.addActionListener(this);
        jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(false);
        jfrGestionFuncionario.jlbMsjAdvertencia2.setVisible(false);
        jfrGestionFuncionario.btnConsulta.addActionListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == jfrGestionFuncionario.jlbRegistrarFU) {

            jfrGestionFuncionario.jtxIdentificacion.setEditable(true);
            jfrGestionFuncionario.jtxNombres.setEditable(true);
            jfrGestionFuncionario.jtxApellidos.setEditable(true);
            jfrGestionFuncionario.btnActualizar.setEnabled(false);
            jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(false);
            jfrGestionFuncionario.jlbMsjAdvertencia2.setVisible(false);

            if (jfrGestionFuncionario.jtxNombres.getText().equals("") || jfrGestionFuncionario.jtxApellidos.getText().equals("") || jfrGestionFuncionario.jtxTelefono.getText().equals("") || jfrGestionFuncionario.jtxIdentificacion.getText().equals("") || jfrGestionFuncionario.jtxtCorreo.getText().equals("") || jfrGestionFuncionario.jtxCargo.getText().equals("")) {

                jfrGestionFuncionario.jlbMsjAdvertencia.setText(AdAdvertencia.getDatosInc());
                jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(true);

            } else {

                boolean BlValido = VAlidaEmail.validateEmail(jfrGestionFuncionario.jtxtCorreo.getText());
                String StTipoDocumento = jfrGestionFuncionario.cmbTipoDoc.getSelectedItem().toString();
                String StSede = jfrGestionFuncionario.cmbSede.getSelectedItem().toString();
                int InDependencia = jfrGestionFuncionario.cmbDependencia.getSelectedIndex() + 1;
                DuDaodependencia = new DaoDependencia(Conconexion.getConexion());
                Dependencia DpDaoTabla = DuDaodependencia.findDependencia(InDependencia);
                String StCargo = jfrGestionFuncionario.jtxCargo.getText().toUpperCase();

                if (BlValido == true) {

                    try {

                        DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
                        DuDaofuncionario.create(new Funcionario(jfrGestionFuncionario.jtxIdentificacion.getText(), StTipoDocumento, jfrGestionFuncionario.jtxNombres.getText().toUpperCase(), jfrGestionFuncionario.jtxApellidos.getText().toUpperCase(), StCargo, jfrGestionFuncionario.jtxTelefono.getText(), jfrGestionFuncionario.jtxtCorreo.getText(), DpDaoTabla, StSede));
                        jfrGestionFuncionario.jlbMsjAdvertencia.setText(AdAdvertencia.getRegistroFuncionario());
                        jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(true);

                    } catch (Exception ex) {
                        jfrGestionFuncionario.jlbMsjAdvertencia.setText(AdAdvertencia.getusuarioRegistrado());
                        jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(true);
                    }

                } else {
                    jfrGestionFuncionario.jlbMsjAdvertencia.setText(AdAdvertencia.getCorreoInvalido());
                    jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(true);
                }

            }

        } else if (e.getSource() == jfrGestionFuncionario.jlbModificarFU) {

            jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(false);
            jfrGestionFuncionario.jlbMsjAdvertencia2.setVisible(false);
            if (jfrGestionFuncionario.jtbTablaUsuarios.getSelectedRow() == -1) {

                jfrGestionFuncionario.jlbMsjAdvertencia.setText(AdAdvertencia.getModificar());
                jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(true);

            } else {

                jfrGestionFuncionario.jtxIdentificacion.setEditable(false);
                jfrGestionFuncionario.jtxNombres.setEditable(false);
                jfrGestionFuncionario.jtxApellidos.setEditable(false);
                jfrGestionFuncionario.cmbTipoDoc.enable(false);
                jfrGestionFuncionario.btnActualizar.setEnabled(true);
                String id = (String) jfrGestionFuncionario.jtbTablaUsuarios.getValueAt(jfrGestionFuncionario.jtbTablaUsuarios.getSelectedRow(), 0);
                DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
                FnFuncionario = DuDaofuncionario.findFuncionario(id);
                jfrGestionFuncionario.jtxNombres.setText(FnFuncionario.getNombre());
                jfrGestionFuncionario.jtxApellidos.setText(FnFuncionario.getApellido());
                jfrGestionFuncionario.jtxIdentificacion.setText(FnFuncionario.getIdentificacion());
                jfrGestionFuncionario.jtxtCorreo.setText(FnFuncionario.getEmail());
                jfrGestionFuncionario.jtxTelefono.setText(FnFuncionario.getTelefono());
                jfrGestionFuncionario.jtxCargo.setText(FnFuncionario.getCargo());
                jfrGestionFuncionario.cmbTipoDoc.setSelectedItem(FnFuncionario.getTipoIdentificacion());
                jfrGestionFuncionario.cmbDependencia.setSelectedItem(FnFuncionario.getIdDependencia().getNombre());
                jfrGestionFuncionario.cmbSede.setSelectedItem(FnFuncionario.getSede());

            }
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
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jfrGestionFuncionario.btnLimpiar) {

            limpiarCampos();

        } else if (e.getSource() == jfrGestionFuncionario.btnActualizar) {

            jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(false);
            jfrGestionFuncionario.jlbMsjAdvertencia2.setVisible(false);

            if (jfrGestionFuncionario.jtxNombres.getText().equals("") || jfrGestionFuncionario.jtxApellidos.getText().equals("") || jfrGestionFuncionario.jtxTelefono.getText().equals("") || jfrGestionFuncionario.jtxIdentificacion.getText().equals("") || jfrGestionFuncionario.jtxtCorreo.getText().equals("") || jfrGestionFuncionario.jtxCargo.getText().equals("")) {

                jfrGestionFuncionario.jlbMsjAdvertencia.setText(AdAdvertencia.getDatosInc());
                jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(true);

            } else {

                boolean BlValido = VAlidaEmail.validateEmail(jfrGestionFuncionario.jtxtCorreo.getText());

                if (BlValido == true) {

                    try {
                        int InDependencia = jfrGestionFuncionario.cmbDependencia.getSelectedIndex() + 1;
                        DuDaodependencia = new DaoDependencia(Conconexion.getConexion());
                        Dependencia DpDaoTabla = DuDaodependencia.findDependencia(InDependencia);

                        funcionario = FnFuncionario;
                        funcionario.setIdentificacion(jfrGestionFuncionario.jtxIdentificacion.getText());
                        funcionario.setTipoIdentificacion(jfrGestionFuncionario.cmbTipoDoc.getSelectedItem().toString());
                        funcionario.setNombre(jfrGestionFuncionario.jtxNombres.getText().toUpperCase());
                        funcionario.setApellido(jfrGestionFuncionario.jtxApellidos.getText().toUpperCase());
                        funcionario.setEmail(jfrGestionFuncionario.jtxtCorreo.getText());
                        funcionario.setTelefono(jfrGestionFuncionario.jtxTelefono.getText());
                        funcionario.setIdDependencia(DpDaoTabla);
                        funcionario.setSede(jfrGestionFuncionario.cmbSede.getSelectedItem().toString());
                        funcionario.setCargo(jfrGestionFuncionario.jtxCargo.getText().toUpperCase());
                        DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
                        DuDaofuncionario.edit(funcionario);
                        jfrGestionFuncionario.jlbMsjAdvertencia.setText(AdAdvertencia.getModificarUsuario());
                        jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(true);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Problema al modificar funcionario.");
                    }

                } else {

                    jfrGestionFuncionario.jlbMsjAdvertencia.setText(AdAdvertencia.getCorreoInvalido());
                    jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(true);
                }
            }
        } else if (e.getSource() == jfrGestionFuncionario.btnConsulta) {
            jfrGestionFuncionario.jtxIdentificacion.setEditable(true);
            jfrGestionFuncionario.jtxNombres.setEditable(true);
            jfrGestionFuncionario.jtxApellidos.setEditable(true);
            jfrGestionFuncionario.btnActualizar.setEnabled(false);
            jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(false);
            jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(false);

            if (jfrGestionFuncionario.jtxConsulta.getText().equals("")) {
                jfrGestionFuncionario.jlbMsjAdvertencia2.setText(AdAdvertencia.getIncIdentificacion());
                jfrGestionFuncionario.jlbMsjAdvertencia2.setVisible(true);
                DefaultTableModel model = (DefaultTableModel) jfrGestionFuncionario.jtbTablaUsuarios.getModel();
                borrarFilas(jfrGestionFuncionario.jtbTablaUsuarios.getRowCount(), model);

            } else {

                DuDafuncionario = new DaoFuncionario(Conconexion.getConexion());
                DAO.Tablas.Funcionario UsuarioFnModificar = DuDafuncionario.findFuncionario(jfrGestionFuncionario.jtxConsulta.getText());

                if (UsuarioFnModificar == null) {
                    jfrGestionFuncionario.jlbMsjAdvertencia2.setText(AdAdvertencia.getIdentificacion());
                    jfrGestionFuncionario.jlbMsjAdvertencia2.setVisible(true);
                    DefaultTableModel model = (DefaultTableModel) jfrGestionFuncionario.jtbTablaUsuarios.getModel();
                    borrarFilas(jfrGestionFuncionario.jtbTablaUsuarios.getRowCount(), model);

                } else {

                    DefaultTableModel model = (DefaultTableModel) jfrGestionFuncionario.jtbTablaUsuarios.getModel();
                    borrarFilas(jfrGestionFuncionario.jtbTablaUsuarios.getRowCount(), model);
                    model.addRow(new Object[]{UsuarioFnModificar.getIdentificacion(), UsuarioFnModificar.getNombre(), UsuarioFnModificar.getApellido(), UsuarioFnModificar.getTelefono(), UsuarioFnModificar.getEmail(), UsuarioFnModificar.getSede()});

                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e
    ) {
    }

    @Override
    public void keyPressed(KeyEvent e
    ) {
    }

    @Override
    public void keyReleased(KeyEvent e
    ) {
    }

    public void borrarFilas(int filas, DefaultTableModel model) {

        for (int i = 0; i < filas; i++) {
            model.removeRow(0);
        }
    }

    void llenarLista(List<DAO.Tablas.Funcionario> UsuarioUsModificar) {
        DefaultTableModel model = (DefaultTableModel) jfrGestionFuncionario.jtbTablaUsuarios.getModel();

        for (int i = 0; i < UsuarioUsModificar.size(); i++) {

            model.addRow(new Object[]{UsuarioUsModificar.get(i).getIdentificacion(), UsuarioUsModificar.get(i).getNombre(), UsuarioUsModificar.get(i).getApellido(), UsuarioUsModificar.get(i).getTelefono(), UsuarioUsModificar.get(i).getEmail(), UsuarioUsModificar.get(i).getSede()});

        }
    }

    public void limpiarCampos() {

        jfrGestionFuncionario.jlbMsjAdvertencia.setVisible(false);
        jfrGestionFuncionario.jlbMsjAdvertencia2.setVisible(false);
        jfrGestionFuncionario.jtxNombres.setText("");
        jfrGestionFuncionario.jtxApellidos.setText("");
        jfrGestionFuncionario.jtxTelefono.setText("");
        jfrGestionFuncionario.jtxtCorreo.setText("");
        jfrGestionFuncionario.jtxIdentificacion.setText("");
        jfrGestionFuncionario.jtxCargo.setText("");

    }

}
