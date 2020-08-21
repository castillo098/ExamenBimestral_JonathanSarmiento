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
import modelo.Cliente;
import modelo.Cliente_;

/**
 *
 * @author dell
 */
@Stateless
@Path("modelo.cliente")
public class ClienteFacadeREST extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "SistemaReVentasVehiculosPU")
    private EntityManager em;

    public ClienteFacadeREST() {
        super(Cliente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Cliente entity) {
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
    public Cliente find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        return super.findAll();
    }

    @POST
    @Path("create")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Crear(@FormParam("id_cliente") String id_cliente, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido, @FormParam("cedula") String cedula,
            @FormParam("edad") String edad, @FormParam("provincia_residencia") String provincia_residencia, @FormParam("vehiculo_compro") String vehiculo_compro) {

        Cliente cl = new Cliente(id_cliente, nombre, apellido, cedula, apellido, edad, provincia_residencia, vehiculo_compro);
        return "datos creados";
    }

    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Editar(@FormParam("id_cliente") String id_cliente, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido, @FormParam("cedula") String cedula,
            @FormParam("edad") String edad, @FormParam("provincia_residencia") String provincia_residencia, @FormParam("vehiculo_compro") String vehiculo_compro) {
        Cliente c = super.find(id_cliente);
        c.setNombre(nombre);
        c.setApellido(apellido);
        c.setCedula(cedula);
        c.setEdad(edad);
        c.setProvinciaResidencia(provincia_residencia);
        c.setVehiculoCompro(vehiculo_compro);
        super.edit(c);
        if (id_cliente == null) {
            return "no se encuentra el valor";
        } else {
            return "datos modificacados";
        }
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
