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
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByIdRol", query = "SELECT r FROM Rol r WHERE r.idRol = :idRol")
    , @NamedQuery(name = "Rol.findByNombreRol", query = "SELECT r FROM Rol r WHERE r.nombreRol = :nombreRol")
    , @NamedQuery(name = "Rol.findByDescripcionRol", query = "SELECT r FROM Rol r WHERE r.descripcionRol = :descripcionRol")
    , @NamedQuery(name = "Rol.findByActivo", query = "SELECT r FROM Rol r WHERE r.activo = :activo")
    , @NamedQuery(name = "Rol.findByRolAdministrativo", query = "SELECT r FROM Rol r WHERE r.rolAdministrativo = :rolAdministrativo")
    , @NamedQuery(name = "Rol.findByRolProyecto", query = "SELECT r FROM Rol r WHERE r.rolProyecto = :rolProyecto")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rol")
    private Integer idRol;
    @Size(max = 2147483647)
    @Column(name = "nombre_rol")
    private String nombreRol;
    @Size(max = 2147483647)
    @Column(name = "descripcion_rol")
    private String descripcionRol;
    @Column(name = "activo")
    private Character activo;
    @Size(max = 2147483647)
    @Column(name = "rol_administrativo")
    private String rolAdministrativo;
    @Size(max = 2147483647)
    @Column(name = "rol_proyecto")
    private String rolProyecto;
    @ManyToMany(mappedBy = "rolCollection")
    private Collection<Permisos> permisosCollection;

    public Rol() {
    }

    public Rol(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    public String getRolAdministrativo() {
        return rolAdministrativo;
    }

    public void setRolAdministrativo(String rolAdministrativo) {
        this.rolAdministrativo = rolAdministrativo;
    }

    public String getRolProyecto() {
        return rolProyecto;
    }

    public void setRolProyecto(String rolProyecto) {
        this.rolProyecto = rolProyecto;
    }

    @XmlTransient
    public Collection<Permisos> getPermisosCollection() {
        return permisosCollection;
    }

    public void setPermisosCollection(Collection<Permisos> permisosCollection) {
        this.permisosCollection = permisosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.control.Rol[ idRol=" + idRol + " ]";
    }
    
}
