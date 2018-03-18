/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control.rest;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "equipo_trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoTrabajo.findAll", query = "SELECT e FROM EquipoTrabajo e")
    , @NamedQuery(name = "EquipoTrabajo.findByIdEquipo", query = "SELECT e FROM EquipoTrabajo e WHERE e.idEquipo = :idEquipo")
    , @NamedQuery(name = "EquipoTrabajo.findByNombreEquipo", query = "SELECT e FROM EquipoTrabajo e WHERE e.nombreEquipo = :nombreEquipo")
    , @NamedQuery(name = "EquipoTrabajo.findByActivo", query = "SELECT e FROM EquipoTrabajo e WHERE e.activo = :activo")})
public class EquipoTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private Integer idEquipo;
    @Size(max = 2147483647)
    @Column(name = "nombre_equipo")
    private String nombreEquipo;
    @Column(name = "activo")
    private Character activo;
    @JoinTable(name = "equipo_trabajo_x_usuario", joinColumns = {
        @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(mappedBy = "idEquipoTrabajo")
    private Collection<Proyecto> proyectoCollection;

    public EquipoTrabajo() {
    }

    public EquipoTrabajo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
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
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoTrabajo)) {
            return false;
        }
        EquipoTrabajo other = (EquipoTrabajo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.control.rest.EquipoTrabajo[ idEquipo=" + idEquipo + " ]";
    }
    
}
