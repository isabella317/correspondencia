package Modelo;

import static Controlador.controladorInicioSesion.listaPermisos;
import javax.swing.JLabel;

/*ENCARGADO DE ADMINISTRACION DE PERMISOS*/
public class PanelPermiso {

    private String descripcion;
    private JLabel idImagen;
    private JLabel idLetrero;
    private int rolPermiso;

    public PanelPermiso() {

    }

    public PanelPermiso(String descripcion, int rol, JLabel idImagen, JLabel idLetrero) {
        this.descripcion = descripcion;
        this.idImagen = idImagen;
        this.idLetrero = idLetrero;      
        this.rolPermiso=rolPermiso;
    }

    public void validarPermiso(int rolPermiso, JLabel idVista, JLabel idLetrero) {
        Boolean encontrado = false;
        for (int i = 0; i < listaPermisos.size(); i++) {
            if (listaPermisos.get(i) == rolPermiso) {
                encontrado = true;
                break;
            }
        }

        if (encontrado == false) {
            idVista.setVisible(false);
            idLetrero.setVisible(false);
        }
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
