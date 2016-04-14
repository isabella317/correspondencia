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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdentificacion", query = "SELECT f FROM Funcionario f WHERE f.identificacion = :identificacion"),
    @NamedQuery(name = "Funcionario.findByTipoIdentificacion", query = "SELECT f FROM Funcionario f WHERE f.tipoIdentificacion = :tipoIdentificacion"),
    @NamedQuery(name = "Funcionario.findByNombre", query = "SELECT f FROM Funcionario f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Funcionario.findByApellido", query = "SELECT f FROM Funcionario f WHERE f.apellido = :apellido"),
    @NamedQuery(name = "Funcionario.findByCargo", query = "SELECT f FROM Funcionario f WHERE f.cargo = :cargo"),
    @NamedQuery(name = "Funcionario.findByTelefono", query = "SELECT f FROM Funcionario f WHERE f.telefono = :telefono"),
    @NamedQuery(name = "Funcionario.findByEmail", query = "SELECT f FROM Funcionario f WHERE f.email = :email")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String identificacion;
    @Column(name = "tipo_identificacion", length = 20)
    private String tipoIdentificacion;
    @Column(length = 40)
    private String nombre;
    @Column(length = 40)
    private String apellido;
    @Column(length = 60)
    private String cargo;
    @Column(length = 15)
    private String telefono;
    @Column(length = 50)
    private String sede;
    @Column(length = 80)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionario")
    private Collection<Usuario> usuarioCollection;
    @JoinColumn(name = "id_dependencia", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Dependencia idDependencia;

    public Funcionario() {
    }
    
    public Funcionario(String identificacion,String tipoIdentificacion,String nombre,String apellido, String cargo,String telefono,String email,Dependencia idDependencia,String sede){
        this.identificacion=identificacion;
        this.tipoIdentificacion=tipoIdentificacion;
        this.apellido=apellido;
        this.nombre=nombre;
        this.telefono=telefono;
        this.email=email;
        this.sede=sede;
        this.idDependencia=idDependencia;
        this.cargo=cargo;
    }

    public Funcionario(String identificacion) {
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Dependencia getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(Dependencia idDependencia) {
        this.idDependencia = idDependencia;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Tablas.Funcionario[ identificacion=" + identificacion + " ]";
    }

    /**
     * @return the sede
     */
    public String getSede() {
        return sede;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(String sede) {
        this.sede = sede;
    }
    
}
