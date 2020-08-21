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
import modelo.Vehiculos;

/**
 *
 * @author dell
 */
@Stateless
@Path("modelo.vehiculos")
public class VehiculosFacadeREST extends AbstractFacade<Vehiculos> {

    @PersistenceContext(unitName = "SistemaReVentasVehiculosPU")
    private EntityManager em;

    public VehiculosFacadeREST() {
        super(Vehiculos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Vehiculos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Vehiculos entity) {
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
    public Vehiculos find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Vehiculos> findAll() {
        return super.findAll();
    }

    @POST
    @Path("create")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Crear(@FormParam("id_vehiculo") String id_vehiculo, @FormParam("año") String año, @FormParam("num_pasajeros") String num_pasajeros, @FormParam("modelo") String modelo,
            @FormParam("marca") String marca, @FormParam("cilindraje") String cilindraje, @FormParam("pais_fabricacion") String pais_fabricacion, @FormParam("placa") String placa,
            @FormParam("concesionario_pertenece") String concesionario_pertenece) {
        Vehiculos v = new Vehiculos(id_vehiculo, año, num_pasajeros, modelo, marca, cilindraje, pais_fabricacion, placa, concesionario_pertenece);

        return "datos ingresados";

    }

    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Editar(@FormParam("id_vehiculo") String id_vehiculo, @FormParam("año") String año, @FormParam("num_pasajeros") String num_pasajeros, @FormParam("modelo") String modelo,
            @FormParam("marca") String marca, @FormParam("cilindraje") String cilindraje, @FormParam("pais_fabricacion") String pais_fabricacion, @FormParam("placa") String placa,
            @FormParam("concesionario_pertenece") String concesionario_pertenece) {
        Vehiculos ve = super.find(id_vehiculo);
        ve.setAño(año);
        ve.setNumPasajeros(num_pasajeros);
        ve.setModelo(modelo);
        ve.setMarca(marca);
        ve.setCilindraje(cilindraje);
        ve.setPaisFabricacion(pais_fabricacion);
        ve.setPlaca(placa);
        ve.setConcesionarioPertenece(concesionario_pertenece);
        super.edit(ve);
        if (id_vehiculo == null) {
            return "no se encuentra el valor";
        } else {
            return "datos modificacados";
        }

    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
