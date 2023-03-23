/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.Message;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * http://localhost:8080/26-web-1.0-SNAPSHOT/api/messages?search=ciao
 *
 *
 * @author ospite
 */

@Path("messaggi")
public class MessaggiResource {

    @Inject
    private MessaggioStore store;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Messaggio> messages(@QueryParam("search") String search) {
        return search == null
                ? store.findAll() : store.findByTesto(search);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Messaggio message(@PathParam("id") int id) {
        return store.find(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Messaggio value) {
        Messaggio saved = store.save(value);
        return Response.status(Response.Status.CREATED)
                .entity(saved)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) {
        store.delete(id);
    }
}
