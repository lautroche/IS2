/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author padagoal
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuarios.findByEsCliente", query = "SELECT u FROM Usuarios u WHERE u.esCliente = :esCliente")
    , @NamedQuery(name = "Usuarios.findByCorreoUser", query = "SELECT u FROM Usuarios u WHERE u.correoUser = :correoUser")
    , @NamedQuery(name = "Usuarios.findByNombreEmpresa", query = "SELECT u FROM Usuarios u WHERE u.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "Usuarios.findByTelefonoUser", query = "SELECT u FROM Usuarios u WHERE u.telefonoUser = :telefonoUser")
    , @NamedQuery(name = "Usuarios.findByCodigoUser", query = "SELECT u FROM Usuarios u WHERE u.codigoUser = :codigoUser")
    , @NamedQuery(name = "Usuarios.findByPasswordUser", query = "SELECT u FROM Usuarios u WHERE u.passwordUser = :passwordUser")
    , @NamedQuery(name = "Usuarios.findByModifcarPassword", query = "SELECT u FROM Usuarios u WHERE u.modifcarPassword = :modifcarPassword")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "es_cliente")
    private Boolean esCliente;
    @Size(max = 2147483647)
    @Column(name = "correo_user")
    private String correoUser;
    @Size(max = 2147483647)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Size(max = 2147483647)
    @Column(name = "telefono_user")
    private String telefonoUser;
    @Size(max = 2147483647)
    @Column(name = "codigo_user")
    private String codigoUser;
    @Size(max = 2147483647)
    @Column(name = "password_user")
    private String passwordUser;
    @Column(name = "modifcar_password")
    private Boolean modifcarPassword;
    @ManyToMany(mappedBy = "usuariosCollection")
    private Collection<EquipoTrabajo> equipoTrabajoCollection;
    @OneToMany(mappedBy = "idCliente")
    private Collection<Proyecto> proyectoCollection;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Boolean getEsCliente() {
        return esCliente;
    }

    public void setEsCliente(Boolean esCliente) {
        this.esCliente = esCliente;
    }

    public String getCorreoUser() {
        return correoUser;
    }

    public void setCorreoUser(String correoUser) {
        this.correoUser = correoUser;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefonoUser() {
        return telefonoUser;
    }

    public void setTelefonoUser(String telefonoUser) {
        this.telefonoUser = telefonoUser;
    }

    public String getCodigoUser() {
        return codigoUser;
    }

    public void setCodigoUser(String codigoUser) {
        this.codigoUser = codigoUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public Boolean getModifcarPassword() {
        return modifcarPassword;
    }

    public void setModifcarPassword(Boolean modifcarPassword) {
        this.modifcarPassword = modifcarPassword;
    }

    @XmlTransient
    public Collection<EquipoTrabajo> getEquipoTrabajoCollection() {
        return equipoTrabajoCollection;
    }

    public void setEquipoTrabajoCollection(Collection<EquipoTrabajo> equipoTrabajoCollection) {
        this.equipoTrabajoCollection = equipoTrabajoCollection;
    }

    @XmlTransient
    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.control.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
