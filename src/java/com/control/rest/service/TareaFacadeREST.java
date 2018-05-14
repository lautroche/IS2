/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control.rest.service;

import com.control.rest.Tarea;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author emax
 */
@Stateless
@Path("com.control.rest.tarea")
public class TareaFacadeREST extends AbstractFacade<Tarea> {

    @PersistenceContext(unitName = "Control_NPU")
    private EntityManager em;

    public TareaFacadeREST() {
        super(Tarea.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Tarea entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Tarea entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Tarea find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tarea> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tarea> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("/byCode/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tarea> byCode(@PathParam("code") String code) {
        List<Tarea> tareas = super.findAll();

        for (int j = tareas.size() - 1; j >= 0; j--) {
            if (!tareas.get(j).getIdUsuario().getCodigoUser().equals(code)) {
                tareas.remove(j);
            }
        }

        return tareas;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
