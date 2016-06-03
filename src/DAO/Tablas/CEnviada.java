/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Tablas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ISABELLA
 */
@Entity
@Table(name = "c_enviada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CEnviada.findAll", query = "SELECT c FROM CEnviada c"),
    @NamedQuery(name = "CEnviada.findByConsecutivoE", query = "SELECT c FROM CEnviada c WHERE c.consecutivoE = :consecutivoE"),
    @NamedQuery(name = "CEnviada.findByFecha", query = "SELECT c FROM CEnviada c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CEnviada.findByAsunto", query = "SELECT c FROM CEnviada c WHERE c.asunto = :asunto"),
    @NamedQuery(name = "CEnviada.findByObservaciones", query = "SELECT c FROM CEnviada c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "CEnviada.findByTipoCorrespondecia", query = "SELECT c FROM CEnviada c WHERE c.tipoCorrespondecia = :tipoCorrespondecia")})
public class CEnviada implements Serializable {

    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consecutivo_e")
    private Integer consecutivoE;
    @Basic(optional = false) 
    @Column(name = "asunto")
    private String asunto;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "tipo_correspondecia")
    private String tipoCorrespondecia;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "identificacion")
    @ManyToOne
    private Funcionario idFuncionario;
    @JoinColumn(name = "id_funcionario_externo", referencedColumnName = "identificacion")
    @ManyToOne
    private FuncionarioExterno idFuncionarioExterno;
    @Column(name = "encargado")
    private String encargado;

    public CEnviada() {
    }

    public CEnviada(Integer consecutivoE, Date fecha, String asunto, String observaciones, String tipoCorrespondecia, Funcionario idFuncionario, FuncionarioExterno idFuncionarioExterno, String encargado,boolean estado) {

        this.estado=estado;
        this.consecutivoE = consecutivoE;
        this.fecha = fecha;
        this.asunto = asunto;
        this.observaciones = observaciones;
        this.tipoCorrespondecia = tipoCorrespondecia;
        this.idFuncionario = idFuncionario;
        this.idFuncionarioExterno = idFuncionarioExterno;
        this.encargado = encargado;
    }

    public CEnviada(Integer consecutivoE) {
        this.consecutivoE = consecutivoE;
    }


    public Integer getConsecutivoE() {
        return consecutivoE;
    }

    public void setConsecutivoE(Integer consecutivoE) {
        this.consecutivoE = consecutivoE;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTipoCorrespondecia() {
        return tipoCorrespondecia;
    }

    public void setTipoCorrespondecia(String tipoCorrespondecia) {
        this.tipoCorrespondecia = tipoCorrespondecia;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public FuncionarioExterno getIdFuncionarioExterno() {
        return idFuncionarioExterno;
    }

    public void setIdFuncionarioExterno(FuncionarioExterno idFuncionarioExterno) {
        this.idFuncionarioExterno = idFuncionarioExterno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consecutivoE != null ? consecutivoE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CEnviada)) {
            return false;
        }
        CEnviada other = (CEnviada) object;
        if ((this.consecutivoE == null && other.consecutivoE != null) || (this.consecutivoE != null && !this.consecutivoE.equals(other.consecutivoE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Tablas.CEnviada[ consecutivoE=" + consecutivoE + " ]";
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

    /**
     * @return the estado
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
