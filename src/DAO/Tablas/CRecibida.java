/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Tablas;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ISABELLA
 */
@Entity
@Table(name = "c_recibida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRecibida.findAll", query = "SELECT c FROM CRecibida c"),
    @NamedQuery(name = "CRecibida.findByConsecutivoR", query = "SELECT c FROM CRecibida c WHERE c.consecutivoR = :consecutivoR"),
    @NamedQuery(name = "CRecibida.findByFecha", query = "SELECT c FROM CRecibida c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CRecibida.findByAsunto", query = "SELECT c FROM CRecibida c WHERE c.asunto = :asunto"),
    @NamedQuery(name = "CRecibida.findByObservaciones", query = "SELECT c FROM CRecibida c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "CRecibida.findByTipoCorrespondecia", query = "SELECT c FROM CRecibida c WHERE c.tipoCorrespondecia = :tipoCorrespondecia")})
public class CRecibida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consecutivo_r")
    private Integer consecutivoR;
    @Basic(optional = false)
    @Column(name = "fecha")
    private String fecha;
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

    public CRecibida() {
    }

    public CRecibida(Integer consecutivoR, String fecha, String asunto, String observaciones, String tipoCorrespondecia, Funcionario idFuncionario, FuncionarioExterno idFuncionarioExterno) {

        this.consecutivoR = consecutivoR;
        this.fecha = fecha;
        this.asunto = asunto;
        this.observaciones = observaciones;
        this.tipoCorrespondecia = tipoCorrespondecia;
        this.idFuncionario = idFuncionario;
        this.idFuncionarioExterno = idFuncionarioExterno;

    }

    public CRecibida(Integer consecutivoR) {
        this.consecutivoR = consecutivoR;
    }

    public CRecibida(Integer consecutivoR, String fecha) {
        this.consecutivoR = consecutivoR;
        this.fecha = fecha;
    }

    public Integer getConsecutivoR() {
        return consecutivoR;
    }

    public void setConsecutivoR(Integer consecutivoR) {
        this.consecutivoR = consecutivoR;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        hash += (consecutivoR != null ? consecutivoR.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRecibida)) {
            return false;
        }
        CRecibida other = (CRecibida) object;
        if ((this.consecutivoR == null && other.consecutivoR != null) || (this.consecutivoR != null && !this.consecutivoR.equals(other.consecutivoR))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Tablas.CRecibida[ consecutivoR=" + consecutivoR + " ]";
    }

}
