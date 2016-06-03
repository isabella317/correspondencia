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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ISABELLA
 */
@Entity
@Table(name = "funcionario_externo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuncionarioExterno.findAll", query = "SELECT f FROM FuncionarioExterno f"),
    @NamedQuery(name = "FuncionarioExterno.findByIdentificacion", query = "SELECT f FROM FuncionarioExterno f WHERE f.identificacion = :identificacion"),
    @NamedQuery(name = "FuncionarioExterno.findByTipoIdentificacion", query = "SELECT f FROM FuncionarioExterno f WHERE f.tipoIdentificacion = :tipoIdentificacion"),
    @NamedQuery(name = "FuncionarioExterno.findByNombre", query = "SELECT f FROM FuncionarioExterno f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "FuncionarioExterno.findByApellido", query = "SELECT f FROM FuncionarioExterno f WHERE f.apellido = :apellido"),
    @NamedQuery(name = "FuncionarioExterno.findByLugar", query = "SELECT f FROM FuncionarioExterno f WHERE f.lugar = :lugar"),
    @NamedQuery(name = "FuncionarioExterno.findByDireccion", query = "SELECT f FROM FuncionarioExterno f WHERE f.direccion = :direccion")})
public class FuncionarioExterno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "direccion")
    private String direccion;

    public FuncionarioExterno(String identificacion, String tipoIdentificacion, String nombre, String apellido, String lugar, String direccion) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.lugar = lugar;
        this.identificacion = identificacion;
        this.tipoIdentificacion = tipoIdentificacion;

    }

    public FuncionarioExterno() {

    }

    public FuncionarioExterno(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionarioExterno)) {
            return false;
        }
        FuncionarioExterno other = (FuncionarioExterno) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Tablas.FuncionarioExterno[ identificacion=" + identificacion + " ]";
    }

}
