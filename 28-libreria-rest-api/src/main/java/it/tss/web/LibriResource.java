/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonCollectors;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
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
    public List<Libro> all() {
        return store.all();
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
}
