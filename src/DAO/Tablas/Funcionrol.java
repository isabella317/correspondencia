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
@Table(catalog = "correspondencia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionrol.findAll", query = "SELECT f FROM Funcionrol f"),
    @NamedQuery(name = "Funcionrol.findById", query = "SELECT f FROM Funcionrol f WHERE f.id = :id")})
public class Funcionrol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "id_funcion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Funcion idFuncion;
    @JoinColumn(name = "id_rol", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Rol idRol;

    public Funcionrol() {
    }

    public Funcionrol(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Funcion getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Funcion idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
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
        if (!(object instanceof Funcionrol)) {
            return false;
        }
        Funcionrol other = (Funcionrol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Tablas.Funcionrol[ id=" + id + " ]";
    }
    
}
