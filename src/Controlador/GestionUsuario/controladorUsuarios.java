package Controlador.GestionUsuario;

import Modelo.Seguridad;
import static Controlador.controladorInicioSesion.AdAdvertencia;
import static Controlador.controladorInicioSesion.Conconexion;
import static Controlador.controladorInicioSesion.DuDaofuncionario;
import static Controlador.controladorInicioSesion.DuDaousuario;
import DAO.Funciones.DaoUsuario;
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
import DAO.Tablas.Usuario;
import Modelo.ButtonEditor;
import Modelo.ButtonRenderer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
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
    private int paginacion;
    int paginaActual = 0;
    private int registroactual = 0;
    private int totalPaginas;
    Funcionario Funcionario;
    boolean estado = false;

    /*Controlador de usuarios : Encargado de realizar acciones dependiendo del medio de donde provengan ::Boton,Jlabel,etc...  */
    void actualizarLista() {
        DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
        listaFuncionarios = DuDaofuncionario.noUsuarios();
        cargarUsuarios();

    }

    public controladorUsuarios(panelUsuario jfrGestionUsuario) {

        this.jfrGestionUsuario = jfrGestionUsuario;
        Paginar();
        DuDaorol = new DaoRol(Conconexion.getConexion());
        actualizarLista();
        listaRoles = DuDaorol.getRoles();
        cargarRoles();

        jfrGestionUsuario.cmbFuncionario.addActionListener(this);
        jfrGestionUsuario.jlbRegistrarUs.addMouseListener(this);
        jfrGestionUsuario.jlbModificarUs.addMouseListener(this);
        jfrGestionUsuario.jlbMsjAdvertencia.setVisible(false);
        jfrGestionUsuario.btnConsulta.addActionListener(this);
        jfrGestionUsuario.jlbMsjAdvertencia2.setVisible(false);
        jfrGestionUsuario.cmbEstado.setVisible(false);
        jfrGestionUsuario.jlbEstado.setVisible(false);
        jfrGestionUsuario.jlbSiguiente.addMouseListener(this);
        jfrGestionUsuario.jlbAtras.addMouseListener(this);
        jfrGestionUsuario.jlbPrimero.addMouseListener(this);
        jfrGestionUsuario.jlbUltimo.addMouseListener(this);
        jfrGestionUsuario.cmbPaginacion.addActionListener(this);
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
                try {
                    DuDaousuario.create(usuario);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Problema al registrar usuario.");
                }
                limpiarCampos();
                jfrGestionUsuario.cmbFuncionario.removeAllItems();
                actualizarLista();
                DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();
                borrarFilas(jfrGestionUsuario.jtbTablaUsuarios.getRowCount(), model);
                Paginar();

                jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getRegistroUsuario());
                jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);

            }

        } else if (e.getSource() == jfrGestionUsuario.jlbModificarUs) {

            if (jfrGestionUsuario.jpsContrasena.getText().equals("")) {

                try {
                    DuDaousuario = new DaoUsuario(Conconexion.getConexion());

                    if (jfrGestionUsuario.cmbEstado.getSelectedItem() == "ACTIVO") {
                        usuario.setEstado(true);
                    } else {
                        usuario.setEstado(false);

                    }
                    List<DAO.Tablas.Rol> listaRol = DuDaorol.obtenerRol(jfrGestionUsuario.cmbRol.getSelectedItem().toString());
                    usuario.setIdRol(listaRol.get(0));
                    try {
                        DuDaousuario.edit(usuario);
                    } catch (Exception ex) {
                        Logger.getLogger(controladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    limpiarCampos();
                    jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getConfUsuario());
                    jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);

                } catch (NullPointerException ex) {
                    jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getModificar());
                    jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);

                }

            } else if (jfrGestionUsuario.jpsContrasena.getText().equals(jfrGestionUsuario.jpsContrasena2.getText())) {

                if (jfrGestionUsuario.jpsContrasena.getText().length() >= 6 && jfrGestionUsuario.jpsContrasena.getText().length() <= 10) {
                    try {
                        DuDaousuario = new DaoUsuario(Conconexion.getConexion());

                        if (jfrGestionUsuario.cmbEstado.getSelectedItem() == "ACTIVO") {
                            usuario.setEstado(true);
                        } else {
                            usuario.setEstado(false);

                        }
                        List<DAO.Tablas.Rol> listaRol = DuDaorol.obtenerRol(jfrGestionUsuario.cmbRol.getSelectedItem().toString());
                        usuario.setIdRol(listaRol.get(0));
                        Seguridad SegSeguridad = new Seguridad();
                        SegSeguridad.addKey(jfrGestionUsuario.jpsContrasena.getText());
                        String StPass = SegSeguridad.encriptar(jfrGestionUsuario.jpsContrasena.getText());
                        usuario.setContraseña(StPass);
                        limpiarCampos();
                        DuDaousuario.edit(usuario);
                        jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getConfUsuario());
                        jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);

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

        } else if (e.getSource() == jfrGestionUsuario.jlbSiguiente) {

            if (paginaActual < totalPaginas - 1) {
                jfrGestionUsuario.cmbPaginacion.setEnabled(false);
                DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();
                borrarFilas(jfrGestionUsuario.jtbTablaUsuarios.getRowCount(), model);
                int paginacionActual = Integer.parseInt(jfrGestionUsuario.cmbPaginacion.getSelectedItem().toString());
                paginaActual++;
                registroactual = (paginaActual) * paginacionActual;
                Paginar();

            }
        } else if (e.getSource() == jfrGestionUsuario.jlbAtras) {

            if (paginaActual > 0) {

                if (paginaActual == 1) {
                    jfrGestionUsuario.cmbPaginacion.setEnabled(true);
                    DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();
                    borrarFilas(jfrGestionUsuario.jtbTablaUsuarios.getRowCount(), model);
                    int paginacionActual = Integer.parseInt(jfrGestionUsuario.cmbPaginacion.getSelectedItem().toString());
                    paginaActual--;
                    registroactual = (paginaActual) * paginacionActual;
                    Paginar();
                } else {

                    jfrGestionUsuario.cmbPaginacion.setEnabled(false);
                    DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();
                    borrarFilas(jfrGestionUsuario.jtbTablaUsuarios.getRowCount(), model);
                    int paginacionActual = Integer.parseInt(jfrGestionUsuario.cmbPaginacion.getSelectedItem().toString());
                    paginaActual--;
                    registroactual = (paginaActual) * paginacionActual;
                    Paginar();
                }
            }
        } else if (e.getSource() == jfrGestionUsuario.jlbPrimero) {

            if (totalPaginas != 1) {
                jfrGestionUsuario.cmbPaginacion.setEnabled(true);
                DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();
                borrarFilas(jfrGestionUsuario.jtbTablaUsuarios.getRowCount(), model);
                int paginacionActual = Integer.parseInt(jfrGestionUsuario.cmbPaginacion.getSelectedItem().toString());
                paginaActual = 0;
                registroactual = (paginaActual) * paginacionActual;
                Paginar();
            }
        } else if (e.getSource() == jfrGestionUsuario.jlbUltimo) {

            if (totalPaginas != 1) {
                jfrGestionUsuario.cmbPaginacion.setEnabled(false);
                DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();
                borrarFilas(jfrGestionUsuario.jtbTablaUsuarios.getRowCount(), model);
                int paginacionActual = Integer.parseInt(jfrGestionUsuario.cmbPaginacion.getSelectedItem().toString());
                paginaActual = totalPaginas - 1;
                registroactual = (paginaActual) * paginacionActual;
                Paginar();
            }
        }

    }

    public void Paginar() {
        paginacion = Integer.parseInt(jfrGestionUsuario.cmbPaginacion.getSelectedItem().toString());
        DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
        int InTotalPag = DuDaofuncionario.getPaginacionUsuarioContar();
        totalPaginas = ((InTotalPag / paginacion) + 1);
        jfrGestionUsuario.jlbPaginas.setText("Página " + (paginaActual + 1) + " de " + ((InTotalPag / paginacion) + 1));

        List<Funcionario> listaFuncionarios = DuDaofuncionario.getPaginacionUsuario(registroactual, paginacion);
        llenarLista(listaFuncionarios);

    }

    public void limpiarCampos() {

        jfrGestionUsuario.jtxIdentificacion.setText("");
        jfrGestionUsuario.jpsContrasena.setText("");
        jfrGestionUsuario.jpsContrasena2.setText("");
        jfrGestionUsuario.jlbMsjAdvertencia2.setVisible(false);
        jfrGestionUsuario.jlbMsjAdvertencia.setVisible(false);

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

        if (e.getSource() == jfrGestionUsuario.btnConsulta) {

            totalPaginas = 1;
            paginaActual = 0;
            jfrGestionUsuario.jlbPaginas.setText("Página " + (paginaActual + 1) + " de " + 1);
            jfrGestionUsuario.jlbMsjAdvertencia.setVisible(false);
            jfrGestionUsuario.jlbMsjAdvertencia.setVisible(false);

            if (jfrGestionUsuario.jtxConsulta.getText().equals("")) {
                jfrGestionUsuario.jlbMsjAdvertencia2.setText(AdAdvertencia.getIncIdentificacion());
                jfrGestionUsuario.jlbMsjAdvertencia2.setVisible(true);
                DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();
                borrarFilas(jfrGestionUsuario.jtbTablaUsuarios.getRowCount(), model);

            } else {

                DuDaousuario = new DaoUsuario(Conconexion.getConexion());
                DAO.Tablas.Usuario UsuarioFnModificar = DuDaousuario.findUsuario(jfrGestionUsuario.jtxConsulta.getText());

                if (UsuarioFnModificar == null) {
                    jfrGestionUsuario.jlbMsjAdvertencia2.setText(AdAdvertencia.getIdentificacion());
                    jfrGestionUsuario.jlbMsjAdvertencia2.setVisible(true);
                    DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();
                    borrarFilas(jfrGestionUsuario.jtbTablaUsuarios.getRowCount(), model);

                } else {

                    DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();
                    borrarFilas(jfrGestionUsuario.jtbTablaUsuarios.getRowCount(), model);
                    model.addRow(new Object[]{UsuarioFnModificar.getIdusuario(), UsuarioFnModificar.getIdFuncionario().getNombre(), UsuarioFnModificar.getIdFuncionario().getApellido(), UsuarioFnModificar.getIdFuncionario().getTelefono(), UsuarioFnModificar.getIdFuncionario().getEmail(), UsuarioFnModificar.getIdFuncionario().getSede(), "Editar"});
                    jfrGestionUsuario.jtbTablaUsuarios.getColumn("").setCellRenderer(new ButtonRenderer());
                    jfrGestionUsuario.jtbTablaUsuarios.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox(), this));
                    jfrGestionUsuario.jtbTablaUsuarios.getColumn("").setPreferredWidth(-50000);

                }

            }
        } else if (e.getSource() == jfrGestionUsuario.cmbFuncionario && estado == false) {

            try {
                StIdentificacion = jfrGestionUsuario.cmbFuncionario.getSelectedItem().toString();
                Funcionario = DuDaofuncionario.findFuncionario(StIdentificacion);
                jfrGestionUsuario.jtxIdentificacion.setText(Funcionario.getNombre() + " " + Funcionario.getApellido());
            } catch (NullPointerException ex) {
                jfrGestionUsuario.jtxIdentificacion.setText("");

            }
        } else if (e.getSource() == jfrGestionUsuario.cmbPaginacion) {
            DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();
            borrarFilas(jfrGestionUsuario.jtbTablaUsuarios.getRowCount(), model);
            Paginar();

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

    public void modificar() {
        estado = true;
        jfrGestionUsuario.cmbEstado.setVisible(true);
        jfrGestionUsuario.jlbEstado.setVisible(true);
        jfrGestionUsuario.jlbContrasena1.setVisible(true);
        jfrGestionUsuario.jlbContrasena2.setVisible(true);
        jfrGestionUsuario.jpsContrasena.setVisible(true);
        jfrGestionUsuario.jpsContrasena2.setVisible(true);
        jfrGestionUsuario.cmbFuncionario.setSelectedItem("");
        jfrGestionUsuario.jlbMsjAdvertencia.setVisible(false);
        jfrGestionUsuario.jlbMsjAdvertencia2.setVisible(false);
        if (jfrGestionUsuario.jtbTablaUsuarios.getSelectedRow() == -1) {

            jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getModificar());
            jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);

        } else {

            jfrGestionUsuario.jtxIdentificacion.setEditable(false);
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

    void llenarLista(List<DAO.Tablas.Funcionario> UsuarioUsModificar) {
        DefaultTableModel model = (DefaultTableModel) jfrGestionUsuario.jtbTablaUsuarios.getModel();

        for (int i = 0; i < UsuarioUsModificar.size(); i++) {

            model.addRow(new Object[]{UsuarioUsModificar.get(i).getIdentificacion(), UsuarioUsModificar.get(i).getNombre(), UsuarioUsModificar.get(i).getApellido(), UsuarioUsModificar.get(i).getTelefono(), UsuarioUsModificar.get(i).getEmail(), UsuarioUsModificar.get(i).getSede(), "Editar", "Eliminar"});
            jfrGestionUsuario.jtbTablaUsuarios.getColumn("").setCellRenderer(new ButtonRenderer());
            jfrGestionUsuario.jtbTablaUsuarios.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox(), this));
            jfrGestionUsuario.jtbTablaUsuarios.getColumn("").setPreferredWidth(-50000);

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
