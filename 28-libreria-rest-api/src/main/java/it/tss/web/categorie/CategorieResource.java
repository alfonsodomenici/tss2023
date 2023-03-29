/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web.categorie;

import java.util.List;
import java.util.Objects;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ospite
 */
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
@Path("categorie")
public class CategorieResource {

    @Inject
    CategoriaStore store;
    

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> all() {
        return store.all();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Categoria find(@PathParam("id") Long id) {
        return store.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Categoria create(Categoria e) {
        return store.save(e);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Categoria update(@PathParam("id") Long id, Categoria e) {
        if (!Objects.equals(e.getId(), id)) {
            throw new BadRequestException("id non corrisponde..");
        }
        return store.save(e);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        store.remove(id);
    }
}
