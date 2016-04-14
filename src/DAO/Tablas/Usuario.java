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
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByContrase\u00f1a", query = "SELECT u FROM Usuario u WHERE u.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
    @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String contraseña;
    private Boolean estado;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String idusuario;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "identificacion", nullable = false)
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @JoinColumn(name = "id_rol", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Rol idRol;

    public Usuario() {
    }

    public Usuario(Funcionario idFuncionario, String idusuario, Rol idRol, Boolean estado) {
        this.idusuario = idusuario;
        this.idFuncionario = idFuncionario;
        this.estado = estado;
        this.idRol = idRol;
    }

    public Usuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(String idusuario, String contraseña) {
        this.idusuario = idusuario;
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
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
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Tablas.Usuario[ idusuario=" + idusuario + " ]";
    }

}
