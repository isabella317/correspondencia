package correspondenciafundacion;

import Controlador.ControladorInicioSesion;
import static Controlador.ControladorInicioSesion.Conconexion;
import static Controlador.ControladorInicioSesion.DuDaousuario;
import DAO.Funciones.DaoUsuario;
import Modelo.Entidades.Conexion;
import Modelo.Entidades.PanelPermiso;
import Vista.Autenticar.vistaLogin;
import Vista.Autenticar.vistaLogin;
import Vista.vistaPanelPrincipal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;

public class CorrespondenciaFundacion extends Application {

    public static ArrayList<PanelPermiso> listaPanel = new ArrayList<PanelPermiso>();
    public static PanelPermiso panel = new PanelPermiso();

    public void GenerarPermisos() {

        vistaPanelPrincipal jfrVistaPanelPrincipal = new vistaPanelPrincipal();
        panel = new PanelPermiso("INGRESO PARA MODIFICAR,CONSULTAR Y CREAR USUARIOS", 1, jfrVistaPanelPrincipal.vistaUsuario, jfrVistaPanelPrincipal.jlbUsuarios);

        panel = new PanelPermiso("INGRESO PARA CREAR REGISTRAR Y CONSULTAR FUNCIONARIOS", 2, jfrVistaPanelPrincipal.vistaFuncionario, jfrVistaPanelPrincipal.jlbFuncionarios);

        panel = new PanelPermiso("INGRESO PARA MODIFICAR Y CONSULTAR INFORMACION PROPIA", 3, jfrVistaPanelPrincipal.vistaConfiguracion, jfrVistaPanelPrincipal.jlbConfUsuario);

    }

    @Override
    public void start(Stage primaryStage) {

        GenerarPermisos();
        Conconexion = Conexion.getInstance();
        DuDaousuario = new DaoUsuario(Conconexion.getConexion());
        DAO.Tablas.Usuario UsValido = DuDaousuario.findUsuario("111");

        vistaLogin r = new vistaLogin();
        ControladorInicioSesion controladorL = new ControladorInicioSesion(r);
        r.setVisible(true);
        r.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {

        launch(args);
    }

}
