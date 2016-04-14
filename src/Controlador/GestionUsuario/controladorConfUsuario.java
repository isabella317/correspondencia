package Controlador.GestionUsuario;

import static Controlador.ControladorInicioSesion.AdAdvertencia;
import static Controlador.ControladorInicioSesion.Conconexion;
import static Controlador.ControladorInicioSesion.DuDaofuncionario;
import static Controlador.ControladorInicioSesion.DuDaousuario;
import static Controlador.ControladorInicioSesion.UsValido;
import Modelo.Entidades.*;
import Vista.vistaPanelPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import DAO.Funciones.DaoDependencia;
import DAO.Funciones.DaoFuncionario;
import DAO.Tablas.Dependencia;
import DAO.Tablas.Funcionario;
import javax.swing.JOptionPane;
import vistaGestionUsuario.panelConfiguracion;

/*CLASE ENCARGADA DE VISTA CONTROL USUARIOS */
public final class controladorConfUsuario implements MouseListener, ActionListener, KeyListener {

    private panelConfiguracion jfrGestionUsuario = new panelConfiguracion();
    vistaPanelPrincipal jfrPanelPrincipal;
    public Seguridad SgSeguridad = new Seguridad();
    Funcionario funcionario;
    public static validarEmail VAlidaEmail = new validarEmail();

    public void modificar() {

        DaoDependencia DuDaodependencia = new DaoDependencia(Conconexion.getConexion());
        Dependencia UsDependencia = DuDaodependencia.findDependencia(UsValido.getIdFuncionario().getIdDependencia().getId());

        jfrGestionUsuario.jtxIdentificacion.setText(UsValido.getIdFuncionario().getIdentificacion());
        jfrGestionUsuario.jtxApellidos.setText(UsValido.getIdFuncionario().getApellido());
        jfrGestionUsuario.jtxDependencia.setText(UsDependencia.getNombre());
        jfrGestionUsuario.jtxNombres.setText(UsValido.getIdFuncionario().getNombre());
        jfrGestionUsuario.jtxTelefono.setText(UsValido.getIdFuncionario().getTelefono());
        jfrGestionUsuario.jtxtCorreo.setText(UsValido.getIdFuncionario().getEmail());
        jfrGestionUsuario.cmbTipoDoc.setSelectedItem(UsValido.getIdFuncionario().getTipoIdentificacion());

    }

    public controladorConfUsuario(panelConfiguracion jfrGestionUsuario) {
        this.jfrGestionUsuario = jfrGestionUsuario;
        
        jfrGestionUsuario.btnActualizar.addActionListener(this);
        jfrGestionUsuario.btnLimpiar.addActionListener(this);
        jfrGestionUsuario.jlbMsjAdvertencia.setVisible(false);
        jfrGestionUsuario.jtxDependencia.setEditable(false);
        jfrGestionUsuario.cmbTipoDoc.setEnabled(false);
        jfrGestionUsuario.jtxNombres.setEditable(false);
        jfrGestionUsuario.jtxApellidos.setEditable(false);

        modificar();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

       

    }

    public void limpiarCampos() {

        jfrGestionUsuario.jtxTelefono.setText("");
        jfrGestionUsuario.jtxtCorreo.setText("");
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

        if (e.getSource() == jfrGestionUsuario.btnLimpiar) {

            limpiarCampos();

        } else if (e.getSource() == jfrGestionUsuario.btnActualizar) {

            if (jfrGestionUsuario.jtxNombres.getText().equals("") || jfrGestionUsuario.jtxApellidos.getText().equals("") || jfrGestionUsuario.jtxTelefono.getText().equals("") || jfrGestionUsuario.jtxtCorreo.getText().equals("")) {

                jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getDatosInc());
                jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);
            } else {

                try {

                    if (VAlidaEmail.validateEmail(jfrGestionUsuario.jtxtCorreo.getText()) == true) {

                        if (jfrGestionUsuario.jpasContrasena.getText().equals("")) {

                            funcionario = UsValido.getIdFuncionario();
                            funcionario.setApellido(jfrGestionUsuario.jtxApellidos.getText());
                            funcionario.setNombre(jfrGestionUsuario.jtxNombres.getText());
                            funcionario.setEmail(jfrGestionUsuario.jtxtCorreo.getText());
                            funcionario.setTelefono(jfrGestionUsuario.jtxTelefono.getText());
                            DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
                            DuDaofuncionario.edit(funcionario);
                            jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getConfUsuario());
                            jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);

                        } else if (jfrGestionUsuario.jpasContrasena.getText().equals(jfrGestionUsuario.jpasContrasena2.getText())) {

                            if (jfrGestionUsuario.jpasContrasena.getText().length() >= 6 && jfrGestionUsuario.jpasContrasena.getText().length() <= 10) {

                                SgSeguridad.addKey(jfrGestionUsuario.jpasContrasena2.getText());
                                String StPass = SgSeguridad.encriptar(jfrGestionUsuario.jpasContrasena2.getText());
                                UsValido.setContraseña(StPass);
                                funcionario = UsValido.getIdFuncionario();
                                funcionario.setApellido(jfrGestionUsuario.jtxApellidos.getText());
                                funcionario.setNombre(jfrGestionUsuario.jtxNombres.getText());
                                funcionario.setEmail(jfrGestionUsuario.jtxtCorreo.getText());
                                funcionario.setTelefono(jfrGestionUsuario.jtxTelefono.getText());
                                DuDaousuario.edit(UsValido);
                                DaoFuncionario DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
                                DuDaofuncionario.edit(funcionario);
                                jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getConfUsuario());
                                jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);
                            } else {
                                jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getLongContrasena());
                                jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);
                            }
                        } else {
                            jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getContrasenaInc());
                            jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);
                        }
                    } else {
                        jfrGestionUsuario.jlbMsjAdvertencia.setText(AdAdvertencia.getCorreoInvalido());
                        jfrGestionUsuario.jlbMsjAdvertencia.setVisible(true);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Problema al modificar el usuario.");
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

}
