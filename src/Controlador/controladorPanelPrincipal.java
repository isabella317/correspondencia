package Controlador;

import static Controlador.controladorInicioSesion.UsValido;
import Vista.Autenticar.vistaLogin;
import Controlador.GestionCorrespondencia.controladorAnularCorrespondencia;
import Controlador.GestionCorrespondencia.controladorRegistrarCorrespondencia;
import Controlador.GestionInformes.controladorConsecutivo;
import Controlador.GestionUsuario.controladorFuncionarios;
import Vista.GestionInformes.vistaConsecutivos;
import Vista.vistaPanelPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Controlador.GestionUsuario.controladorUsuarios;
import Controlador.GestionUsuario.controladorConfUsuario;
import Vista.Correspondencia.panelAnularCorrespondencia;
import Vista.Correspondencia.panelRegistrarCorrespondencia;
import static correspondenciafundacion.CorrespondenciaFundacion.panel;
import vistaGestionUsuario.panelConfiguracion;
import vistaGestionUsuario.panelFuncionario;
import vistaGestionUsuario.panelUsuario;

/*Controlador de panel principal : Encargado de realizar acciones dependiendo del medio de donde provengan ::Boton,Jlabel,etc...  */
public class controladorPanelPrincipal implements MouseListener {

    vistaPanelPrincipal jfrVistaPanelPrincipal = new vistaPanelPrincipal(UsValido);

    public controladorPanelPrincipal(vistaPanelPrincipal jfrVistaPanelPrincipal) {
        this.jfrVistaPanelPrincipal = jfrVistaPanelPrincipal;

        jfrVistaPanelPrincipal.jlbIdentificador.setText(UsValido.getIdFuncionario().getNombre() + " " + UsValido.getIdFuncionario().getApellido());
        panel.validarPermiso(2, jfrVistaPanelPrincipal.jlbFuncionario, jfrVistaPanelPrincipal.jlbFuncionarios);
        panel.validarPermiso(1, jfrVistaPanelPrincipal.jlbUsuario, jfrVistaPanelPrincipal.jlbUsuarios);
        panel.validarPermiso(3, jfrVistaPanelPrincipal.jlbConfiguracion, jfrVistaPanelPrincipal.jlbConfUsuario);

        jfrVistaPanelPrincipal.jlbRegistrarCorrespondencia.addMouseListener(this);
        jfrVistaPanelPrincipal.jlbCancelarCorrespondencia.addMouseListener(this);
        jfrVistaPanelPrincipal.jlbGestionInformes.addMouseListener(this);
        jfrVistaPanelPrincipal.jlbUsuario.addMouseListener(this);
        jfrVistaPanelPrincipal.jlbSalir.addMouseListener(this);
        jfrVistaPanelPrincipal.jlbFuncionario.addMouseListener(this);
        jfrVistaPanelPrincipal.jlbConfiguracion.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == jfrVistaPanelPrincipal.jlbRegistrarCorrespondencia) {
            panelRegistrarCorrespondencia jfrGestionFuncionario = new panelRegistrarCorrespondencia();
            controladorRegistrarCorrespondencia ctFuncionario = new controladorRegistrarCorrespondencia(jfrGestionFuncionario,jfrVistaPanelPrincipal);
            jfrVistaPanelPrincipal.jpnFondo.removeAll();
            jfrVistaPanelPrincipal.jpnFondo.add(jfrGestionFuncionario);
            jfrVistaPanelPrincipal.jpnFondo.revalidate();
            jfrVistaPanelPrincipal.jpnFondo.repaint();

        } else if (e.getSource() == jfrVistaPanelPrincipal.jlbCancelarCorrespondencia) {
            panelAnularCorrespondencia jfrGestionFuncionario = new panelAnularCorrespondencia ();
            controladorAnularCorrespondencia ctFuncionario = new controladorAnularCorrespondencia(jfrGestionFuncionario);
            jfrVistaPanelPrincipal.jpnFondo.removeAll();
            jfrVistaPanelPrincipal.jpnFondo.add(jfrGestionFuncionario);
            jfrVistaPanelPrincipal.jpnFondo.revalidate();
            jfrVistaPanelPrincipal.jpnFondo.repaint();

        } else if (e.getSource() == jfrVistaPanelPrincipal.jlbUsuario) {
            panelUsuario jfrGestionUsuario = new panelUsuario();
            controladorUsuarios ctUsuario = new controladorUsuarios(jfrGestionUsuario);
            jfrVistaPanelPrincipal.jpnFondo.removeAll();
            jfrVistaPanelPrincipal.jpnFondo.add(jfrGestionUsuario);
            jfrVistaPanelPrincipal.jpnFondo.revalidate();
            jfrVistaPanelPrincipal.jpnFondo.repaint();

        } else if (e.getSource() == jfrVistaPanelPrincipal.jlbSalir) {
            vistaLogin jfrVistaLogin = new vistaLogin();
            controladorInicioSesion ctInicioSesion = new controladorInicioSesion(jfrVistaLogin);
            jfrVistaLogin.setVisible(true);
            jfrVistaLogin.setLocationRelativeTo(null);
            jfrVistaPanelPrincipal.dispose();

        } else if (e.getSource() == jfrVistaPanelPrincipal.jlbGestionInformes) {

            vistaConsecutivos jfrConsecutivo = new vistaConsecutivos(UsValido);
            controladorConsecutivo ctConsecutivo = new controladorConsecutivo(jfrConsecutivo);
            jfrConsecutivo.setvistapanelprincipalinformes(jfrVistaPanelPrincipal);
            jfrConsecutivo.setVisible(true);
            jfrConsecutivo.setLocationRelativeTo(jfrVistaPanelPrincipal);
            jfrVistaPanelPrincipal.dispose();

        } else if (e.getSource() == jfrVistaPanelPrincipal.jlbFuncionario) {

            panelFuncionario jfrGestionFuncionario = new panelFuncionario();
            controladorFuncionarios ctFuncionario = new controladorFuncionarios(jfrGestionFuncionario);
            jfrVistaPanelPrincipal.jpnFondo.removeAll();
            jfrVistaPanelPrincipal.jpnFondo.add(jfrGestionFuncionario);
            jfrVistaPanelPrincipal.jpnFondo.revalidate();
            jfrVistaPanelPrincipal.jpnFondo.repaint();

        } else if (e.getSource() == jfrVistaPanelPrincipal.jlbConfiguracion) {

            panelConfiguracion jfrConfUsuario = new panelConfiguracion();
            controladorConfUsuario ctConfUsuario = new controladorConfUsuario(jfrConfUsuario);
            jfrVistaPanelPrincipal.jpnFondo.removeAll();
            jfrVistaPanelPrincipal.jpnFondo.add(jfrConfUsuario);
            jfrVistaPanelPrincipal.jpnFondo.revalidate();
            jfrVistaPanelPrincipal.jpnFondo.repaint();

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
