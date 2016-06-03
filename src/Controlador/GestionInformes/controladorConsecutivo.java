package Controlador.GestionInformes;

//import static Controlador.ControladorInicioSesion.conexion;
import static Controlador.controladorInicioSesion.UsValido;
import static Controlador.GestionCorrespondencia.controladorAnularCorrespondencia.DeStringADate;

import Controlador.controladorPanelPrincipal;
import Vista.GestionInformes.vistaConsecutivos;
import Vista.vistaPanelPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.JOptionPane;

public class controladorConsecutivo implements ActionListener, MouseListener {

    vistaConsecutivos vistaconsecutivos = new vistaConsecutivos(UsValido);
    vistaPanelPrincipal panelprincipal;

    public controladorConsecutivo(vistaConsecutivos vistaconsecutivos) {
        this.vistaconsecutivos = vistaconsecutivos;
        vistaconsecutivos.atras.addMouseListener(this);
        vistaconsecutivos.fecha.addActionListener(this);
        //  vistaconsecutivos.numero_consecutivo.addActionListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vistaconsecutivos.atras) {

            panelprincipal = new vistaPanelPrincipal(UsValido);
            controladorPanelPrincipal controladorP = new controladorPanelPrincipal(panelprincipal);
            panelprincipal.setVisible(true);
            panelprincipal.setLocationRelativeTo(vistaconsecutivos);
            vistaconsecutivos.dispose();
        } else {

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
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaconsecutivos.fecha) {
            Date Date1 = DeStringADate(vistaconsecutivos.fechainicial.getText());
            Date Date2 = DeStringADate(vistaconsecutivos.fechafinal.getText());
            int numero = Date1.compareTo(Date2);
          

          

        }

    }
}
