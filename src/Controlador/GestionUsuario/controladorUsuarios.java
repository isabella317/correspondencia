package Controlador.GestionUsuario;

import static Controlador.ControladorInicioSesion.AdAdvertencia;
import static Controlador.ControladorInicioSesion.Conconexion;
import static Controlador.ControladorInicioSesion.DuDaofuncionario;
import static Controlador.ControladorInicioSesion.DuDaousuario;
import DAO.Funciones.DaoUsuario;
import Modelo.Entidades.*;
import Vista.vistaPanelPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import DAO.Funciones.DaoFuncionario;
import DAO.Funciones.DaoRol;
import DAO.Tablas.Funcionario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vistaGestionUsuario.panelUsuario;

/*CLASE ENCARGADA DE VISTA CONTROL USUARIOS */
public class controladorUsuarios implements MouseListener, ActionListener, KeyListener {

    private panelUsuario jfrGestionUsuario = new panelUsuario();
    vistaPanelPrincipal jfrPanelPrincipal;
    public Seguridad SgSeguridad = new Seguridad();
    DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();
    List<DAO.Tablas.Funcionario> listaFuncionarios;
    DAO.Tablas.Usuario usuario;
    List<DAO.Tablas.Rol> listaRoles;
    DaoRol DuDaorol;
    String StIdentificacion;
    Funcionario Funcionario;
    boolean estado = false;

    public controladorUsuarios(panelUsuario jfrGestionUsuario) {

        this.jfrGestionUsuario = jfrGestionUsuario;

        DuDaousuario = new DaoUsuario(Conconexion.getConexion());
        DuDaorol = new DaoRol(Conconexion.getConexion());
        DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
        List<DAO.Tablas.Funcionario> UsuarioUsModificar = DuDaousuario.funcionarioXApellidos();
        listaFuncionarios = DuDaofuncionario.noUsuarios();
        listaRoles = DuDaorol.getRoles();

        llenarLista(UsuarioUsModificar);
        cargarUsuarios();
        cargarRoles();
        jfrGestionUsuario.cmbFuncionario.addActionListener(this);
        jfrGestionUsuario.jlbRegistrarUs.addMouseListener(this);
        jfrGestionUsuario.jlbModificarUs.addMouseListener(this);
        jfrGestionUsuario.btnActualizar.setEnabled(false);
        jfrGestionUsuario.btnActualizar.addActionListener(this);
        jfrGestionUsuario.btnlimpiar.addActionListener(this);
        jfrGestionUsuario.jlbMsjAdvertencia.setVisible(false);
        jfrGestionUsuario.btnConsulta.addActionListener(this);
        jfrGestionUsuario.jlbMsjAdvertencia2.setVisible(false);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == jfrGestionUsuario.jlbRegistrarUs) {
            estado = false;
            jfrGestionUsuario.jlbMsjAdvertencia.setVisible(false);
            jfrGestionUsuario.jlbMsjAdvertencia.setVisible(false);
    
            if (jfrGestionUsuario.cmbFuncionario.getSelectedItem().toString().equals("")) {

                jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getSeleccionUsuario());
                jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);

            } else {

                try {
                    DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
                    DAO.Tablas.Funcionario u = DuDaofuncionario.findFuncionario(jfrGestionUsuario.cmbFuncionario.getSelectedItem().toString());

                    List<DAO.Tablas.Rol> r = DuDaorol.obtenerRol(jfrGestionUsuario.cmbRol.getSelectedItem().toString());
                    DAO.Tablas.Usuario usuario = new DAO.Tablas.Usuario();
                    usuario.setIdFuncionario(u);
                    usuario.setIdusuario(u.getIdentificacion());
                    String Stcontrasena = u.getNombre().toUpperCase().charAt(0) + u.getIdentificacion() + u.getApellido().toUpperCase().charAt(0);
                    Seguridad s = new Seguridad();
                    s.addKey(Stcontrasena);
                    usuario.setContraseña(s.encriptar(Stcontrasena));
                    usuario.setIdRol(r.get(0));
                    if (jfrGestionUsuario.cmbEstado.getSelectedItem().toString().equals("ACTIVO")) {
                        usuario.setEstado(true);
                    } else {
                        usuario.setEstado(false);
                    }
                    DuDaousuario.create(usuario);

                    jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getRegistroUsuario());
                    jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Problema al registrar el usuario.");
                }

            }

        } else if (e.getSource() == jfrGestionUsuario.jlbModificarUs) {

            estado = true;
            jfrGestionUsuario.cmbFuncionario.setSelectedItem("");
            jfrGestionUsuario.jlbMsjAdvertencia.setVisible(false);
            jfrGestionUsuario.jlbMsjAdvertencia2.setVisible(false);
            if (jfrGestionUsuario.jtbTablaUsuarios.getSelectedRow() == -1) {

                jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getModificar());
                jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);

            } else {

                jfrGestionUsuario.jtxIdentificacion.setEditable(false);
                jfrGestionUsuario.btnActualizar.setEnabled(true);
                String id = (String) jfrGestionUsuario.jtbTablaUsuarios.getValueAt(jfrGestionUsuario.jtbTablaUsuarios.getSelectedRow(), 0);
                DuDaousuario = new DaoUsuario(Conconexion.getConexion());
                usuario = DuDaousuario.findUsuario(id);
                jfrGestionUsuario.cmbFuncionario.setSelectedItem(usuario.getIdusuario());
                jfrGestionUsuario.jtxIdentificacion.setText(usuario.getIdFuncionario().getNombre() + " " + usuario.getIdFuncionario().getApellido());
                jfrGestionUsuario.cmbRol.setSelectedItem(usuario.getIdRol().getTipo());
                if (usuario.getEstado() == true) {
                    jfrGestionUsuario.cmbEstado.setSelectedItem("ACTIVO");
                } else {
                    jfrGestionUsuario.cmbEstado.setSelectedItem("INACTIVO");

                }

            }
            estado = false;
        }

    }

    public void limpiarCampos() {

        jfrGestionUsuario.jtxIdentificacion.setText("");
        jfrGestionUsuario.jpasContrasena.setText("");
        jfrGestionUsuario.jpasContrasena2.setText("");

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

        if (e.getSource() == jfrGestionUsuario.btnlimpiar) {

            limpiarCampos();

        } else if (e.getSource() == jfrGestionUsuario.btnActualizar) {

            if (jfrGestionUsuario.jpasContrasena.getText().equals("")) {

                try {
                    DuDaousuario = new DaoUsuario(Conconexion.getConexion());

                    if (jfrGestionUsuario.cmbEstado.getSelectedItem() == "ACTIVO") {
                        usuario.setEstado(true);
                    } else {
                        usuario.setEstado(false);

                    }
                    List<DAO.Tablas.Rol> r = DuDaorol.obtenerRol(jfrGestionUsuario.cmbRol.getSelectedItem().toString());
                    usuario.setIdRol(r.get(0));
                    DuDaousuario.edit(usuario);
                    jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getConfUsuario());
                    jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);

                } catch (Exception ex) {
                    Logger.getLogger(controladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (jfrGestionUsuario.jpasContrasena.getText().equals(jfrGestionUsuario.jpasContrasena2.getText())) {

                if (jfrGestionUsuario.jpasContrasena.getText().length() >= 6 && jfrGestionUsuario.jpasContrasena.getText().length() <= 10) {
                    try {
                        DuDaousuario = new DaoUsuario(Conconexion.getConexion());

                        if (jfrGestionUsuario.cmbEstado.getSelectedItem() == "ACTIVO") {
                            usuario.setEstado(true);
                        } else {
                            usuario.setEstado(false);

                        }
                        List<DAO.Tablas.Rol> r = DuDaorol.obtenerRol(jfrGestionUsuario.cmbRol.getSelectedItem().toString());
                        usuario.setIdRol(r.get(0));
                        Seguridad SegSeguridad = new Seguridad();
                        SegSeguridad.addKey(jfrGestionUsuario.jpasContrasena.getText());
                        String StPass = SegSeguridad.encriptar(jfrGestionUsuario.jpasContrasena.getText());
                        usuario.setContraseña(StPass);
                        DuDaousuario.edit(usuario);
                        jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getConfUsuario());
                        jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);
                        limpiarCampos();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Problema al modificar el usuario.");
                    }
                } else {
                    jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getLongContrasena());
                    jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);

                }
            } else {
                jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getContrasenaInc());
                jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);
            }


        } else if (e.getSource() == jfrGestionUsuario.btnConsulta) {

            jfrGestionUsuario.btnActualizar.setEnabled(false);
            jfrGestionUsuario.jlbMsjAdvertencia.setVisible(false);
            jfrGestionUsuario.jlbMsjAdvertencia.setVisible(false);

            if (jfrGestionUsuario.jtxConsulta.getText().equals("")) {
                jfrGestionUsuario.jlbMsjAdvertencia2.setText(AdAdvertencia.getIncIdentificacion());
                jfrGestionUsuario.jlbMsjAdvertencia2.setVisible(true);

            } else {

                DuDaousuario = new DaoUsuario(Conconexion.getConexion());
                DAO.Tablas.Usuario UsuarioFnModificar = DuDaousuario.findUsuario(jfrGestionUsuario.jtxConsulta.getText());

                if (UsuarioFnModificar == null) {
                    jfrGestionUsuario.jlbMsjAdvertencia2.setText(AdAdvertencia.getIdentificacion());
                    jfrGestionUsuario.jlbMsjAdvertencia2.setVisible(true);

                } else {

                    DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();
                    borrarFilas(jfrGestionUsuario.jtbTablaUsuarios.getRowCount(), model);
                    model.addRow(new Object[]{UsuarioFnModificar.getIdusuario(), UsuarioFnModificar.getIdFuncionario().getNombre(), UsuarioFnModificar.getIdFuncionario().getApellido(), UsuarioFnModificar.getIdFuncionario().getTelefono(), UsuarioFnModificar.getIdFuncionario().getEmail(), UsuarioFnModificar.getIdFuncionario().getSede()});

                }

            }
        } else if (e.getSource() == jfrGestionUsuario.cmbFuncionario && estado == false) {

            StIdentificacion = jfrGestionUsuario.cmbFuncionario.getSelectedItem().toString();
            Funcionario = DuDaofuncionario.findFuncionario(StIdentificacion);
            jfrGestionUsuario.jtxIdentificacion.setText(Funcionario.getNombre() + " " + Funcionario.getApellido());

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
        DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();

        for (int i = 0; i < UsuarioUsModificar.size(); i++) {

            model.addRow(new Object[]{UsuarioUsModificar.get(i).getIdentificacion(), UsuarioUsModificar.get(i).getNombre(), UsuarioUsModificar.get(i).getApellido(), UsuarioUsModificar.get(i).getTelefono(), UsuarioUsModificar.get(i).getEmail(), UsuarioUsModificar.get(i).getSede()});

        }
    }

    public void cargarUsuarios() {
        DefaultComboBoxModel mdlCombo = new DefaultComboBoxModel();
        jfrGestionUsuario.cmbFuncionario.setModel(mdlCombo);

        mdlCombo.addElement("");

        for (int i = 0; i < listaFuncionarios.size(); i++) {

            mdlCombo.addElement(listaFuncionarios.get(i).getIdentificacion());
        }
    }

    public void cargarRoles() {
        DefaultComboBoxModel mdlCombo = new DefaultComboBoxModel();
        jfrGestionUsuario.cmbRol.setModel(mdlCombo);

        for (int i = 0; i < listaRoles.size(); i++) {

            mdlCombo.addElement(listaRoles.get(i).getTipo());
        }
    }

}
