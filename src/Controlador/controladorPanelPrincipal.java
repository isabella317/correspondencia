package Controlador;

import static Controlador.ControladorInicioSesion.UsValido;
import Vista.Autenticar.vistaLogin;
import Controlador.GestionCorrespondencia.controladorCancelarCorrespondencia;
import Controlador.GestionCorrespondencia.controladorRegistrarCorrespondencia;
import Controlador.GestionInformes.controladorConsecutivo;
import Controlador.GestionUsuario.controladorFuncionarios;
import Vista.GestionCorrespondencia.vistaCancelarCorrespondencia;
import Vista.GestionCorrespondencia.vistaRegistrarCorrespondencia;
import Vista.GestionInformes.vistaConsecutivos;
import Vista.vistaPanelPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import Controlador.GestionUsuario.controladorUsuarios;
import Controlador.GestionUsuario.controladorConfUsuario;
import static correspondenciafundacion.CorrespondenciaFundacion.panel;
import vistaGestionUsuario.panelConfiguracion;
import vistaGestionUsuario.panelFuncionario;
import vistaGestionUsuario.panelUsuario;

/*CONTROLADOR DE PANEL PRINCIPAL */
public class controladorPanelPrincipal implements MouseListener {

    vistaPanelPrincipal jfrVistaPanelPrincipal = new vistaPanelPrincipal(UsValido);

    public controladorPanelPrincipal(vistaPanelPrincipal jfrVistaPanelPrincipal) {
        this.jfrVistaPanelPrincipal = jfrVistaPanelPrincipal;
        panel.validarPermiso(2, jfrVistaPanelPrincipal.vistaFuncionario, jfrVistaPanelPrincipal.jlbFuncionarios);
        panel.validarPermiso(1, jfrVistaPanelPrincipal.vistaUsuario, jfrVistaPanelPrincipal.jlbUsuarios);
        panel.validarPermiso(3, jfrVistaPanelPrincipal.vistaConfiguracion, jfrVistaPanelPrincipal.jlbConfUsuario);

        jfrVistaPanelPrincipal.jlbRegistrarCorrespondencia.addMouseListener(this);
        jfrVistaPanelPrincipal.jlbCancelarCorrespondencia.addMouseListener(this);
        jfrVistaPanelPrincipal.jlbGestionInformes.addMouseListener(this);
        jfrVistaPanelPrincipal.vistaUsuario.addMouseListener(this);
        jfrVistaPanelPrincipal.jlbSalir.addMouseListener(this);
        jfrVistaPanelPrincipal.vistaFuncionario.addMouseListener(this);
        jfrVistaPanelPrincipal.vistaConfiguracion.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == jfrVistaPanelPrincipal.jlbRegistrarCorrespondencia) {
            vistaRegistrarCorrespondencia jfrVistaRegistrar = new vistaRegistrarCorrespondencia(UsValido);
            try {
                controladorRegistrarCorrespondencia ctCorrespondencia = new controladorRegistrarCorrespondencia(jfrVistaRegistrar);
            } catch (SQLException ex) {
            }
            jfrVistaRegistrar.setvistaP(jfrVistaPanelPrincipal);
            jfrVistaRegistrar.setVisible(true);
            jfrVistaRegistrar.setLocationRelativeTo(jfrVistaPanelPrincipal);
            jfrVistaPanelPrincipal.dispose();

        } else if (e.getSource() == jfrVistaPanelPrincipal.jlbCancelarCorrespondencia) {
            vistaCancelarCorrespondencia jfrVistaCancelar = new vistaCancelarCorrespondencia(UsValido);
            controladorCancelarCorrespondencia ctCorrespondencia = new controladorCancelarCorrespondencia(jfrVistaCancelar);
            jfrVistaCancelar.setvistaR(jfrVistaPanelPrincipal);
            jfrVistaCancelar.setVisible(true);
            jfrVistaCancelar.setLocationRelativeTo(jfrVistaPanelPrincipal);
            jfrVistaPanelPrincipal.dispose();

        } else if (e.getSource() == jfrVistaPanelPrincipal.vistaUsuario) {
            panelUsuario jfrGestionUsuario = new panelUsuario();
            controladorUsuarios ctUsuario = new controladorUsuarios(jfrGestionUsuario);
            jfrVistaPanelPrincipal.Panel1.removeAll();
            jfrVistaPanelPrincipal.Panel1.add(jfrGestionUsuario);
            jfrVistaPanelPrincipal.Panel1.revalidate();
            jfrVistaPanelPrincipal.Panel1.repaint();

        } else if (e.getSource() == jfrVistaPanelPrincipal.jlbSalir) {
            vistaLogin jfrVistaLogin = new vistaLogin();
            ControladorInicioSesion ctInicioSesion = new ControladorInicioSesion(jfrVistaLogin);
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

        } else if (e.getSource() == jfrVistaPanelPrincipal.vistaFuncionario) {

            panelFuncionario jfrGestionFuncionario = new panelFuncionario();
            controladorFuncionarios ctFuncionario = new controladorFuncionarios(jfrGestionFuncionario);
            jfrVistaPanelPrincipal.Panel1.removeAll();
            jfrVistaPanelPrincipal.Panel1.add(jfrGestionFuncionario);
            jfrVistaPanelPrincipal.Panel1.revalidate();
            jfrVistaPanelPrincipal.Panel1.repaint();

        } else if (e.getSource() == jfrVistaPanelPrincipal.vistaConfiguracion) {

            panelConfiguracion jfrConfUsuario = new panelConfiguracion();
            controladorConfUsuario ctConfUsuario = new controladorConfUsuario(jfrConfUsuario);
            jfrVistaPanelPrincipal.Panel1.removeAll();
            jfrVistaPanelPrincipal.Panel1.add(jfrConfUsuario);
            jfrVistaPanelPrincipal.Panel1.revalidate();
            jfrVistaPanelPrincipal.Panel1.repaint();

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
