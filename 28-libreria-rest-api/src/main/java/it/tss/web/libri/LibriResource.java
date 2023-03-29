/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web.libri;

import it.tss.web.categorie.CategoriaStore;
import it.tss.web.autori.AutoreStore;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonCollectors;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ospite
 */
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
@Path("libri")
public class LibriResource {

    @Inject
    LibroStore store;

    @Inject
    AutoreStore autoreStore;

    @Inject
    CategoriaStore categoriaStore;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response all() {
        List<Libro> libri = store.all();

        return libri.isEmpty()
                ? Response.status(Response.Status.NOT_FOUND).build()
                : Response.status(Response.Status.OK).entity(libri).build();
//        return store.all()
//                .stream()
//                .map(Libro::toJsonSlice)
//                .collect(JsonCollectors.toJsonArray());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Libro find(@PathParam("id") long id) {
        return store.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Libro create(Libro libro) {
        libro.setAutore(autoreStore.findOrSave(libro.getAutore()));
        libro.setCategorie(categoriaStore.findOrSave(libro.getCategorie()));
        return store.save(libro);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Libro update(@PathParam("id") long id, Libro libro) {
        libro.setAutore(autoreStore.findOrSave(libro.getAutore()));
        libro.setCategorie(categoriaStore.findOrSave(libro.getCategorie()));
        return store.save(libro);
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Libro patch(@PathParam("id") long id, JsonObject json) {
        Libro found = store.findById(id).orElseThrow(() -> new NotFoundException());
        return store.patch(found, json);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        store.remove(id);
    }
}
