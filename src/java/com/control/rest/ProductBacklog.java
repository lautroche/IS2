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
import javax.persistence.ManyToOne;
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
@Table(name = "product_backlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductBacklog.findAll", query = "SELECT p FROM ProductBacklog p")
    , @NamedQuery(name = "ProductBacklog.findByIdProductBacklog", query = "SELECT p FROM ProductBacklog p WHERE p.idProductBacklog = :idProductBacklog")
    , @NamedQuery(name = "ProductBacklog.findByEnunciado", query = "SELECT p FROM ProductBacklog p WHERE p.enunciado = :enunciado")
    , @NamedQuery(name = "ProductBacklog.findByAlias", query = "SELECT p FROM ProductBacklog p WHERE p.alias = :alias")
    , @NamedQuery(name = "ProductBacklog.findByEstado", query = "SELECT p FROM ProductBacklog p WHERE p.estado = :estado")
    , @NamedQuery(name = "ProductBacklog.findByPrioridad", query = "SELECT p FROM ProductBacklog p WHERE p.prioridad = :prioridad")
    , @NamedQuery(name = "ProductBacklog.findByComentarios", query = "SELECT p FROM ProductBacklog p WHERE p.comentarios = :comentarios")})
public class ProductBacklog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product_backlog")
    private Integer idProductBacklog;
    @Size(max = 2147483647)
    @Column(name = "enunciado")
    private String enunciado;
    @Size(max = 2147483647)
    @Column(name = "alias")
    private String alias;
    @Column(name = "estado")
    private Character estado;
    @Size(max = 2147483647)
    @Column(name = "prioridad")
    private String prioridad;
    @Size(max = 2147483647)
    @Column(name = "comentarios")
    private String comentarios;
    @OneToMany(mappedBy = "idBacklog")
    private Collection<Sprint> sprintCollection;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne
    private Proyecto idProyecto;

    public ProductBacklog() {
    }

    public ProductBacklog(Integer idProductBacklog) {
        this.idProductBacklog = idProductBacklog;
    }

    public Integer getIdProductBacklog() {
        return idProductBacklog;
    }

    public void setIdProductBacklog(Integer idProductBacklog) {
        this.idProductBacklog = idProductBacklog;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @XmlTransient
    public Collection<Sprint> getSprintCollection() {
        return sprintCollection;
    }

    public void setSprintCollection(Collection<Sprint> sprintCollection) {
        this.sprintCollection = sprintCollection;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductBacklog != null ? idProductBacklog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductBacklog)) {
            return false;
        }
        ProductBacklog other = (ProductBacklog) object;
        if ((this.idProductBacklog == null && other.idProductBacklog != null) || (this.idProductBacklog != null && !this.idProductBacklog.equals(other.idProductBacklog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.control.rest.ProductBacklog[ idProductBacklog=" + idProductBacklog + " ]";
    }
    
}
