/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control.service;

/**
 *
 * @author padagoal
 */
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Victor-Desarrollo
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.control.service.EquipoTrabajoFacadeREST.class);
        resources.add(com.control.service.HistoricoAccionesFacadeREST.class);
        resources.add(com.control.service.PermisosFacadeREST.class);
        resources.add(com.control.service.ProductBacklogFacadeREST.class);
        resources.add(com.control.service.ProyectoFacadeREST.class);
        resources.add(com.control.service.RolFacadeREST.class);
        resources.add(com.control.service.SprintFacadeREST.class);
        resources.add(com.control.service.UsuariosFacadeREST.class);
    }
    
}
