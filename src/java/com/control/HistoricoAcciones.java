/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author padagoal
 */
@Entity
@Table(name = "historico_acciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoAcciones.findAll", query = "SELECT h FROM HistoricoAcciones h")
    , @NamedQuery(name = "HistoricoAcciones.findByIdHistorico", query = "SELECT h FROM HistoricoAcciones h WHERE h.idHistorico = :idHistorico")
    , @NamedQuery(name = "HistoricoAcciones.findByTablaAfectada", query = "SELECT h FROM HistoricoAcciones h WHERE h.tablaAfectada = :tablaAfectada")
    , @NamedQuery(name = "HistoricoAcciones.findByFechahoraAccion", query = "SELECT h FROM HistoricoAcciones h WHERE h.fechahoraAccion = :fechahoraAccion")
    , @NamedQuery(name = "HistoricoAcciones.findByUsuarioAccion", query = "SELECT h FROM HistoricoAcciones h WHERE h.usuarioAccion = :usuarioAccion")
    , @NamedQuery(name = "HistoricoAcciones.findByAccionEjecutada", query = "SELECT h FROM HistoricoAcciones h WHERE h.accionEjecutada = :accionEjecutada")})
public class HistoricoAcciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_historico")
    private Integer idHistorico;
    @Size(max = 2147483647)
    @Column(name = "tabla_afectada")
    private String tablaAfectada;
    @Column(name = "fechahora_accion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahoraAccion;
    @Size(max = 2147483647)
    @Column(name = "usuario_accion")
    private String usuarioAccion;
    @Size(max = 2147483647)
    @Column(name = "accion_ejecutada")
    private String accionEjecutada;

    public HistoricoAcciones() {
    }

    public HistoricoAcciones(Integer idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Integer getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Integer idHistorico) {
        this.idHistorico = idHistorico;
    }

    public String getTablaAfectada() {
        return tablaAfectada;
    }

    public void setTablaAfectada(String tablaAfectada) {
        this.tablaAfectada = tablaAfectada;
    }

    public Date getFechahoraAccion() {
        return fechahoraAccion;
    }

    public void setFechahoraAccion(Date fechahoraAccion) {
        this.fechahoraAccion = fechahoraAccion;
    }

    public String getUsuarioAccion() {
        return usuarioAccion;
    }

    public void setUsuarioAccion(String usuarioAccion) {
        this.usuarioAccion = usuarioAccion;
    }

    public String getAccionEjecutada() {
        return accionEjecutada;
    }

    public void setAccionEjecutada(String accionEjecutada) {
        this.accionEjecutada = accionEjecutada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorico != null ? idHistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoAcciones)) {
            return false;
        }
        HistoricoAcciones other = (HistoricoAcciones) object;
        if ((this.idHistorico == null && other.idHistorico != null) || (this.idHistorico != null && !this.idHistorico.equals(other.idHistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.control.HistoricoAcciones[ idHistorico=" + idHistorico + " ]";
    }
    
}
