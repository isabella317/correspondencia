package Controlador;

import DAO.Funciones.DaoDependencia;
import DAO.Funciones.DaoFuncionario;
import DAO.Funciones.DaoFuncionrol;
import Modelo.Entidades.Seguridad;
import Modelo.Entidades.Usuario;
import DAO.Funciones.DaoUsuario;
import Modelo.Entidades.Advertencia;
import Vista.Autenticar.vistaLogin;
import Vista.Autenticar.vistaRecuperarContraseña;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.vistaPanelPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Modelo.Entidades.Conexion;

/*CLASE ENCARGADA DEL CONTROL DE LA VISTALOGIN */
public class ControladorInicioSesion implements ActionListener, MouseListener {
    
    private vistaLogin jfrVistaLogin = new vistaLogin();

    //Creación de clases.
    public static DAO.Tablas.Usuario UsValido = new DAO.Tablas.Usuario();
    public static Advertencia AdAdvertencia = new Advertencia();
    public static Seguridad SgSeguridad = new Seguridad();
    public Usuario UsEnLinea = new Usuario();
    public static List<Integer> listaPermisos = new ArrayList<>();
    public static DaoFuncionario DuDaofuncionario;
    public static DaoDependencia DuDaodependencia;

    /**
     *
     */
    public static Conexion Conconexion;
    public static DaoUsuario DuDaousuario;
    public static DaoFuncionrol DuDaofuncionrol;
    
    public static DAO.Tablas.Usuario UsDaoTabla;
    public static List<DAO.Tablas.Dependencia> DpDaoTabla;
    public static DAO.Tablas.Rol RlDaoTabla;
    public static List<DAO.Tablas.Funcionrol> FnDaoTabla;

    //variables
    ArrayList<String> listaLogueos = new ArrayList<>();
    int InNumIntentos = 0;
    boolean BlValido = false;
    
    public ControladorInicioSesion(vistaLogin jfrVistaLogin) {
        listaPermisos.clear();
        this.jfrVistaLogin = jfrVistaLogin;
        this.jfrVistaLogin.btnIngresar.addActionListener(this);
        this.jfrVistaLogin.btnLimpiar.addActionListener(this);
        this.jfrVistaLogin.jlbRecuperar.addMouseListener(this);
        this.jfrVistaLogin.btnSalir.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == jfrVistaLogin.btnIngresar) {
            
            jfrVistaLogin.jlblMsjAdvertencia.setVisible(false);
            jfrVistaLogin.jlbMsjUsuario.setVisible(false);
            jfrVistaLogin.jlbMsjContrasena.setVisible(false);
            
            if (jfrVistaLogin.jtxLogin.getText().equals("") || jfrVistaLogin.jpasContrasena.getText().equals("")) {
                
                jfrVistaLogin.jlblMsjAdvertencia.setText(AdAdvertencia.getDatosInc());
                jfrVistaLogin.jlblMsjAdvertencia.setVisible(true);
                
            } else {
                
                String StContrasena = jfrVistaLogin.jpasContrasena.getText();
                String StLogin = jfrVistaLogin.jtxLogin.getText().toUpperCase();
                
                DuDaousuario = new DaoUsuario(Conconexion.getConexion());
                
                try {
                    
                    UsValido = DuDaousuario.findUsuario(StLogin);
                    
                    if (UsValido == null) {
                        jfrVistaLogin.jlbMsjUsuario.setText(AdAdvertencia.getUsuario());
                        jfrVistaLogin.jlbMsjUsuario.setVisible(true);
                        
                    } else if (UsValido.getEstado() == true) {
                        
                        String StContrasenaUsuario = UsValido.getContraseña();
                        BlValido = validarUsuario(StLogin, StContrasena, StContrasenaUsuario);
                        
                        if (BlValido == true) {
                            
                            int InRol = UsValido.getIdRol().getId();
                            DuDaofuncionrol = new DaoFuncionrol(Conconexion.getConexion());
                            DuDaofuncionrol.findFuncionrolXIdRol(InRol);
                            vistaPanelPrincipal jfrVistaPanelPrincipal = new vistaPanelPrincipal(UsValido);
                            controladorPanelPrincipal ctPanelPrincipal = new controladorPanelPrincipal(jfrVistaPanelPrincipal);
                            jfrVistaPanelPrincipal.setvistaLogin(jfrVistaLogin);
                            jfrVistaPanelPrincipal.setVisible(true);
                            jfrVistaPanelPrincipal.setLocationRelativeTo(jfrVistaLogin);
                            
                            jfrVistaLogin.dispose();
                            
                        } else {
                            verificarRepetido(StLogin);
                            
                            if (InNumIntentos != 5) {
                                
                                jfrVistaLogin.jlblMsjAdvertencia.setText(AdAdvertencia.getadvInactiva(InNumIntentos));
                                jfrVistaLogin.jlbMsjContrasena.setText(AdAdvertencia.getContrasena());
                                jfrVistaLogin.jlbMsjContrasena.setVisible(true);
                                jfrVistaLogin.jlblMsjAdvertencia.setVisible(true);
                                
                            } else if (InNumIntentos == 5) {
                                InNumIntentos = 0;
                                listaLogueos.clear();
                                jfrVistaLogin.jlblMsjAdvertencia.setText(AdAdvertencia.getInactivacion());
                                jfrVistaLogin.jlblMsjAdvertencia.setVisible(true);
                                inactivarCuenta(StLogin);
                            }
                            
                        }
                    } else {
                        jfrVistaLogin.jlblMsjAdvertencia.setText(AdAdvertencia.getInactivacion());
                        jfrVistaLogin.jlblMsjAdvertencia.setVisible(true);
                    }
                    
                } catch (NullPointerException s) {
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Problemas en actualizacion de información en la  BD.");
                }
            }
        } else if (e.getSource() == jfrVistaLogin.btnSalir) {
            
            System.exit(0);
            
        } else if (e.getSource() == jfrVistaLogin.btnLimpiar) {
            
            jfrVistaLogin.jlblMsjAdvertencia.setText("");
            jfrVistaLogin.jlbMsjUsuario.setText("");
            jfrVistaLogin.jlbMsjContrasena.setText("");
            jfrVistaLogin.jtxLogin.setText("");
            jfrVistaLogin.jpasContrasena.setText("");
            
        }
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jfrVistaLogin.jlbRecuperar) {
            
            vistaRecuperarContraseña jfrVistaRecuperar = new vistaRecuperarContraseña();
            controladorRecuperacionContrasena ctAyuda = new controladorRecuperacionContrasena(jfrVistaRecuperar);
            jfrVistaRecuperar.setVisible(true);
            jfrVistaRecuperar.setLocationRelativeTo(jfrVistaLogin);
            jfrVistaLogin.dispose();
            
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

    //Funciones auxiliares
    public void inactivarCuenta(String StLogin) {
        
        try {
            UsDaoTabla = DuDaousuario.findUsuario(StLogin);
            UsDaoTabla.setEstado(false);
            DuDaousuario.edit(UsDaoTabla);
            
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Problema al inactivar cuenta.");
        }
        
    }
    
    public boolean verificarRepetido(String StLogin) {
        listaLogueos.add(StLogin);
        
        for (int Ini = 0; Ini < listaLogueos.size(); Ini++) {
            if (StLogin.equals(listaLogueos.get(Ini))) {
                
            } else {
                listaLogueos.clear();
                return false;
            }
        }
        InNumIntentos++;
        return true;
    }
    
    public boolean validarUsuario(String StLogin, String StPass, String StCifrado) {
        
        SgSeguridad.addKey(StPass);
        String StContrasenaCifrada = SgSeguridad.encriptar(StPass);
        
        if (StContrasenaCifrada.equals(StCifrado)) {

//           usuario = new UsuarioA(usuariovalido.getNombre1(), usuariovalido.getNombre2(), usuariovalido.getApellido1(), usuariovalido.getApellido2(), usuariovalido.getTelefono(), usuariovalido.getIdentificacion(), usuariovalido.getCorreo());
            return true;
        }
        
        return false;
    }
}
