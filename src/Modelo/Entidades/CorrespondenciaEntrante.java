package Modelo.Entidades;

import java.io.File;
import java.util.Date;

public class CorrespondenciaEntrante extends Correspondencia {

    private String dependencia;

    public CorrespondenciaEntrante( String fecha1, String fecha2, String tipo_origen, String remitente, String tipo_destino, String tipo_destinatario, String asunto, String observaciones, String tipo_origen_envio, File documento, boolean estado, String dependencia,String encargado) {
        super( fecha1, fecha2, tipo_origen, remitente, tipo_destino, tipo_destinatario, asunto, observaciones, tipo_origen_envio, documento, estado,encargado);
        this.dependencia = dependencia;

    }

    public CorrespondenciaEntrante( String fecha2, String tipo_origen, String remitente, String tipo_destino, String tipo_destinatario, String asunto, String observaciones, String tipo_origen_envio, File documento, boolean estado,String encargado) {
        super( fecha2, tipo_origen, remitente, tipo_destino, tipo_destinatario, asunto, observaciones, tipo_origen_envio, documento, estado,encargado);
        this.dependencia = dependencia;

    }

    /**
     * @return the dependencia
     */
    public String getDependencia() {
        return dependencia;
    }

    /**
     * @param dependencia the dependencia to set
     */
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

}
