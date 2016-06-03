package Controlador;

import Modelo.GeneradorClaves;
import Modelo.NotificarCorreo;
import Vista.Autenticar.vistaLogin;
import Vista.Autenticar.vistaRecuperarContraseña;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static Controlador.controladorInicioSesion.UsDaoTabla;
import static Controlador.controladorInicioSesion.AdAdvertencia;
import static Controlador.controladorInicioSesion.Conconexion;
import static Controlador.controladorInicioSesion.DuDaousuario;
import DAO.Funciones.DaoUsuario;
import Modelo.Seguridad;
import java.util.logging.Level;
import java.util.logging.Logger;

/* CLASE ENCARAGADA DEL CONTROL DE LA VISTARECUPERARCONTRASEÑA*/
public class controladorRecuperacionContrasena implements ActionListener, MouseListener {

    private vistaRecuperarContraseña jfrVistaContrasena = new vistaRecuperarContraseña();
    private final NotificarCorreo NtNotificacion = new NotificarCorreo();
    private final GeneradorClaves GnGenerador = new GeneradorClaves();

    public controladorRecuperacionContrasena(vistaRecuperarContraseña jfrVistaContrasena) {

        this.jfrVistaContrasena = jfrVistaContrasena;
        this.jfrVistaContrasena.btnaceptar.addActionListener(this);
        this.jfrVistaContrasena.btnlimpiar.addActionListener(this);
        this.jfrVistaContrasena.jlbAtras.addMouseListener(this);
        jfrVistaContrasena.jlbMsjAdvertencia.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        jfrVistaContrasena.jlbMsjAdvertencia.setVisible(false);

        if (e.getSource() == jfrVistaContrasena.btnaceptar) {

            if (jfrVistaContrasena.jtxIdentificacion.getText().equals("")) {
                jfrVistaContrasena.jlbMsjAdvertencia.setText(AdAdvertencia.getIncIdentificacion());
                jfrVistaContrasena.jlbMsjAdvertencia.setVisible(true);

            } else {

                UsDaoTabla = DuDaousuario.findUsuario(jfrVistaContrasena.jtxIdentificacion.getText());

                if (UsDaoTabla == null) {
                    jfrVistaContrasena.jlbMsjAdvertencia.setText(AdAdvertencia.getIdentificacion());
                    jfrVistaContrasena.jlbMsjAdvertencia.setVisible(true);

                } else if (UsDaoTabla.getEstado() == true) {

                    try {

                        boolean seguir = true;
                        String Stpass = GnGenerador.getPassword();
                        DuDaousuario = new DaoUsuario(Conconexion.getConexion());
                        DAO.Tablas.Usuario usuario = DuDaousuario.findUsuario(jfrVistaContrasena.jtxIdentificacion.getText());
                        Seguridad Segseguridad = new Seguridad();
                        Segseguridad.addKey(Stpass);
                        String StPassword = Segseguridad.encriptar(Stpass);
                        
                        

                        try {
                            NtNotificacion.mandarCorreo(UsDaoTabla.getIdFuncionario().getEmail(), Stpass);
                            usuario.setContraseña(StPassword);
                            DuDaousuario.edit(usuario);
                        } catch (Exception ex) {
                            jfrVistaContrasena.jlbMsjAdvertencia.setText(AdAdvertencia.getConexionFallida());
                            jfrVistaContrasena.jlbMsjAdvertencia.setVisible(true);
                            seguir = false;
                        }

                        if (seguir == true) {
                            jfrVistaContrasena.jlbMsjAdvertencia.setText(AdAdvertencia.getCorreoEnviado());
                            jfrVistaContrasena.jlbMsjAdvertencia.setVisible(true);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(controladorRecuperacionContrasena.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    jfrVistaContrasena.jlbMsjAdvertencia.setText(AdAdvertencia.getCuentaInactivada());
                    jfrVistaContrasena.jlbMsjAdvertencia.setVisible(true);
                }
            }
        } else if (e.getSource() == jfrVistaContrasena.btnlimpiar) {

            jfrVistaContrasena.jtxIdentificacion.setText("");

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jfrVistaContrasena.jlbAtras) {
            vistaLogin jfrVistaLogin = new vistaLogin();
            controladorInicioSesion ctInicioSesion = new controladorInicioSesion(jfrVistaLogin);
            jfrVistaLogin.setVisible(true);
            jfrVistaLogin.setLocationRelativeTo(jfrVistaContrasena);
            jfrVistaContrasena.dispose();

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
