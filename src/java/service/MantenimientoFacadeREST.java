/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Mantenimiento;

/**
 *
 * @author dell
 */
@Stateless
@Path("modelo.mantenimiento")
public class MantenimientoFacadeREST extends AbstractFacade<Mantenimiento> {

    @PersistenceContext(unitName = "SistemaReVentasVehiculosPU")
    private EntityManager em;

    public MantenimientoFacadeREST() {
        super(Mantenimiento.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Mantenimiento entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Mantenimiento entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Mantenimiento find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Mantenimiento> findAll() {
        return super.findAll();
    }

    @POST
    @Path("create")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Crear(@FormParam("id_mantenimiento") String id_mantenimiento, @FormParam("vehiculo") int vehiculo, @FormParam("cliente") String cliente,
            @FormParam("fecha") String fecha, @FormParam("descripcion") String descripcion, @FormParam("kilometraje") String kilometraje) {

        Mantenimiento m = new Mantenimiento(id_mantenimiento, vehiculo, cliente, fecha, descripcion, kilometraje);
        return "datos creados";

    }

    @POST
    @Path("editar")
    public String Editar(@FormParam("id_mantenimiento") String id_mantenimiento, @FormParam("vehiculo") int vehiculo, @FormParam("cliente") String cliente,
            @FormParam("fecha") String fecha, @FormParam("descripcion") String descripcion, @FormParam("kilometraje") String kilometraje) {

        Mantenimiento ma = super.find(id_mantenimiento);
        ma.setVehiculo(vehiculo);
        ma.setCliente(cliente);
        ma.setFecha(fecha);
        ma.setDescripcion(descripcion);
        ma.setKilometraje(kilometraje);
        super.edit(ma);
        if (id_mantenimiento == null) {
            return "no se encauntran el valor";
        } else {
            return "datos modificacados";
        }
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mantenimiento> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
