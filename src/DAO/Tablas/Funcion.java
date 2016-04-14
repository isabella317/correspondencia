/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Tablas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ISABELLA
 */
@Entity
@Table(catalog = "correspondencia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcion.findAll", query = "SELECT f FROM Funcion f"),
    @NamedQuery(name = "Funcion.findById", query = "SELECT f FROM Funcion f WHERE f.id = :id"),
    @NamedQuery(name = "Funcion.findByVistaActivada", query = "SELECT f FROM Funcion f WHERE f.vistaActivada = :vistaActivada"),
    @NamedQuery(name = "Funcion.findByDescripcion", query = "SELECT f FROM Funcion f WHERE f.descripcion = :descripcion")})
public class Funcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "vista_activada", length = 100)
    private String vistaActivada;
    @Column(length = 100)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncion")
    private Collection<Funcionrol> funcionrolCollection;

    public Funcion() {
    }

    public Funcion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVistaActivada() {
        return vistaActivada;
    }

    public void setVistaActivada(String vistaActivada) {
        this.vistaActivada = vistaActivada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Funcionrol> getFuncionrolCollection() {
        return funcionrolCollection;
    }

    public void setFuncionrolCollection(Collection<Funcionrol> funcionrolCollection) {
        this.funcionrolCollection = funcionrolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcion)) {
            return false;
        }
        Funcion other = (Funcion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Tablas.Funcion[ id=" + id + " ]";
    }
    
}
