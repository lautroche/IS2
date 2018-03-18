/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control.rest;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author padagoal
 */
@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByIdProyecto", query = "SELECT p FROM Proyecto p WHERE p.idProyecto = :idProyecto")
    , @NamedQuery(name = "Proyecto.findByCodigoProyecto", query = "SELECT p FROM Proyecto p WHERE p.codigoProyecto = :codigoProyecto")
    , @NamedQuery(name = "Proyecto.findByFechaIncio", query = "SELECT p FROM Proyecto p WHERE p.fechaIncio = :fechaIncio")
    , @NamedQuery(name = "Proyecto.findByFechaFin", query = "SELECT p FROM Proyecto p WHERE p.fechaFin = :fechaFin")
    , @NamedQuery(name = "Proyecto.findByAnhoProyecto", query = "SELECT p FROM Proyecto p WHERE p.anhoProyecto = :anhoProyecto")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proyecto")
    private Integer idProyecto;
    @Size(max = 2147483647)
    @Column(name = "codigo_proyecto")
    private String codigoProyecto;
    @Column(name = "fecha_incio")
    @Temporal(TemporalType.DATE)
    private Date fechaIncio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 2147483647)
    @Column(name = "anho_proyecto")
    private String anhoProyecto;
    @JoinColumn(name = "id_equipo_trabajo", referencedColumnName = "id_equipo")
    @ManyToOne
    private EquipoTrabajo idEquipoTrabajo;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuarios idCliente;
    @OneToMany(mappedBy = "idProyecto")
    private Collection<ProductBacklog> productBacklogCollection;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public Date getFechaIncio() {
        return fechaIncio;
    }

    public void setFechaIncio(Date fechaIncio) {
        this.fechaIncio = fechaIncio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getAnhoProyecto() {
        return anhoProyecto;
    }

    public void setAnhoProyecto(String anhoProyecto) {
        this.anhoProyecto = anhoProyecto;
    }

    public EquipoTrabajo getIdEquipoTrabajo() {
        return idEquipoTrabajo;
    }

    public void setIdEquipoTrabajo(EquipoTrabajo idEquipoTrabajo) {
        this.idEquipoTrabajo = idEquipoTrabajo;
    }

    public Usuarios getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Usuarios idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public Collection<ProductBacklog> getProductBacklogCollection() {
        return productBacklogCollection;
    }

    public void setProductBacklogCollection(Collection<ProductBacklog> productBacklogCollection) {
        this.productBacklogCollection = productBacklogCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.control.rest.Proyecto[ idProyecto=" + idProyecto + " ]";
    }
    
}
