
package Modelo.Entidades;
import java.io.File;
import java.util.Date;

public abstract class Correspondencia {
    
       // metodos : registrar() , cancelar()
    
     
 /*create table correspondencia_Entrante(id serial,fecha timestamp,tipo_origen varchar(15),dependencia varchar(50),remitente varchar(50),tipo_destino varchar(15),
tipo_destinatario varchar(50),asunto varchar(50), observaciones varchar(100),tipo_origen_envio varchar(25),documento bytea,confidencia BOOLEAN , estado BOOLEAN,constraint 
LlaveP7 primary key (id));*/
    private  String fecha1;
    private  String fecha2;
    private String tipo_origen;
    private String remitente;
    private String tipo_destino;
    private String tipo_destinatario;
    private String asunto;
    private String observaciones;
    private String tipo_origen_envio;
    private File documento;
    private String encargado;
    private boolean estado=true;
    
    
    public Correspondencia(){}
    
    public  Correspondencia( String fecha1, String fecha2, String tipo_origen,String remitente,String tipo_destino,String tipo_destinatario,String asunto, String observaciones,String tipo_origen_envio, File documento,boolean estado,String encargado  ){
      this.encargado=encargado;
      this.fecha1=fecha1;
      this.fecha2=fecha2;
      this.tipo_origen=tipo_origen;
      this.remitente=remitente;
      this.tipo_destino=tipo_destino;
      this.tipo_destinatario=tipo_destinatario;
      this.asunto=asunto;
      this.observaciones=observaciones;
      this.tipo_origen_envio=tipo_origen_envio;
      this.documento=documento;
      this.estado=estado;
    }
    
        public  Correspondencia( String fecha2, String tipo_origen,String remitente,String tipo_destino,String tipo_destinatario,String asunto, String observaciones,String tipo_origen_envio, File documento,boolean estado,String encargado  ){
      this.encargado=encargado;
      this.fecha2=fecha2;
      this.tipo_origen=tipo_origen;
      this.remitente=remitente;
      this.tipo_destino=tipo_destino;
      this.tipo_destinatario=tipo_destinatario;
      this.asunto=asunto;
      this.observaciones=observaciones;
      this.tipo_origen_envio=tipo_origen_envio;
      this.documento=documento;
      this.estado=estado;
    }

    
    
    
    public void setEstado(){
        this.setEstado(isEstado());
    }
    
     public boolean getEstado(){
        return isEstado();
    }



    /**
     * @return the fecha1
     */
    public String getFecha1() {
        return fecha1;
    }

    /**
     * @param fecha1 the fecha1 to set
     */
    public void setFecha1( String fecha1) {
        this.fecha1 = fecha1;
    }

    /**
     * @return the fecha2
     */
    public String getFecha2() {
        return fecha2;
    }

    /**
     * @param fecha2 the fecha2 to set
     */
    public void setFecha2( String fecha2) {
        this.fecha2 = fecha2;
    }

    /**
     * @return the tipo_origen
     */
    public String getTipo_origen() {
        return tipo_origen;
    }

    /**
     * @param tipo_origen the tipo_origen to set
     */
    public void setTipo_origen(String tipo_origen) {
        this.tipo_origen = tipo_origen;
    }

    /**
     * @return the remitente
     */
    public String getRemitente() {
        return remitente;
    }

    /**
     * @param remitente the remitente to set
     */
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    /**
     * @return the tipo_destino
     */
    public String getTipo_destino() {
        return tipo_destino;
    }

    /**
     * @param tipo_destino the tipo_destino to set
     */
    public void setTipo_destino(String tipo_destino) {
        this.tipo_destino = tipo_destino;
    }

    /**
     * @return the tipo_destinatario
     */
    public String getTipo_destinatario() {
        return tipo_destinatario;
    }

    /**
     * @param tipo_destinatario the tipo_destinatario to set
     */
    public void setTipo_destinatario(String tipo_destinatario) {
        this.tipo_destinatario = tipo_destinatario;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the tipo_origen_envio
     */
    public String getTipo_origen_envio() {
        return tipo_origen_envio;
    }

    /**
     * @param tipo_origen_envio the tipo_origen_envio to set
     */
    public void setTipo_origen_envio(String tipo_origen_envio) {
        this.tipo_origen_envio = tipo_origen_envio;
    }

    /**
     * @return the documento
     */
    public File getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(File documento) {
        this.documento = documento;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the encargado
     */
    public String getEncargado() {
        return encargado;
    }

    /**
     * @param encargado the encargado to set
     */
    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }
    
    
    
    
    
   
    

}
