package Controlador.GestionCorrespondencia;

import static Controlador.ControladorInicioSesion.UsValido;
import static Controlador.GestionCorrespondencia.controladorRegistrarCorrespondencia.fecha;
//import static Controlador.ControladorInicioSesion.conexion;
import Controlador.controladorPanelPrincipal;
import Vista.GestionCorrespondencia.vistaCancelarCorrespondencia;
import Vista.vistaPanelPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class controladorCancelarCorrespondencia implements ActionListener, MouseListener {

    vistaCancelarCorrespondencia vistacorrespondencia = new vistaCancelarCorrespondencia(UsValido);
    vistaPanelPrincipal panelprincipal;
    String fecha2;
    int numero;
    boolean paso = false;

    public controladorCancelarCorrespondencia(vistaCancelarCorrespondencia vistacorrespondencia) {
        this.vistacorrespondencia = vistacorrespondencia;
        vistacorrespondencia.atras.addMouseListener(this);
        vistacorrespondencia.fecha1.addActionListener(this);
        vistacorrespondencia.numero_correspondencia.addActionListener(this);

    }

    public static boolean compararFechas(Date actual, Date ingresado) {

        boolean años = ingresado.getYear() == actual.getYear();
        boolean meses = ingresado.getMonth() == actual.getMonth();

        if (ingresado.getYear() > actual.getYear()) {
            return false;
        } else if (años == true && ingresado.getMonth() > actual.getMonth()) {
            return false;

        } else if (años == true && meses == true && ingresado.getDate() > actual.getDate()) {

            return false;
        }
        return true;
    }

    public static Date DeStringADate(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
        String strFecha = fecha;
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(strFecha);

            return fechaDate;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return fechaDate;
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vistacorrespondencia.atras) {
            panelprincipal = new vistaPanelPrincipal(UsValido);
            controladorPanelPrincipal controladorP = new controladorPanelPrincipal(panelprincipal);
            panelprincipal.setVisible(true);
            panelprincipal.setLocationRelativeTo(vistacorrespondencia);
            vistacorrespondencia.dispose();

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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistacorrespondencia.fecha1) {

            Date fechaelegida = DeStringADate(vistacorrespondencia.calendario.getText());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
            System.out.println("elegida " + formato.format(fechaelegida));
            System.out.println("actual " + formato.format(fecha.getTime()));
            System.out.println("iguales : " + formato.format(fechaelegida).compareTo(formato.format(fecha.getTime())));

            Date Date2 = DeStringADate(formato.format(fechaelegida));
            Date Date1 = DeStringADate(formato.format(fecha.getTime()));

            boolean seguir = compararFechas(Date1, Date2);

            if (seguir == true) {

                fecha2 = formato.format(fechaelegida);
                //conexion.obtenerFechas(fecha2, vistacorrespondencia);

            } else {
                JOptionPane.showMessageDialog(null, "La fecha ingresada es invalida");
            }

        } else if (e.getSource() == vistacorrespondencia.numero_correspondencia) {

            try {
                numero = Integer.parseInt(vistacorrespondencia.numero_consecutivo.getText());

//                    conexion.cancelarCorrespondencia(numero);
            } catch (NumberFormatException t) {
                JOptionPane.showMessageDialog(panelprincipal, "El dato ingresado debe ser numerico");
            }
        }
    }
}
