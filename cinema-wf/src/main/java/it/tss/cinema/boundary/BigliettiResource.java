/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cinema.boundary;

import it.tss.cinema.Boundary;
import it.tss.cinema.control.BigliettoStore;
import it.tss.cinema.entity.Biglietto;
import it.tss.cinema.entity.Film;
import java.util.List;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 *
 * @author ospite
 */
@DenyAll
@Boundary
@Path("biglietti")
public class BigliettiResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    BigliettoStore store;

    @RolesAllowed({"ADMIN"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Biglietto> search(
            @QueryParam("programmazione_id") Long programmazioneId,
            @QueryParam("proiezione_id") Long proiezioneId,
            @QueryParam("utente_id") Long utenteId,
            @DefaultValue("1") @QueryParam("page") Integer page,
            @QueryParam("per_page") Integer perPage) {
        return store.search(programmazioneId, utenteId, proiezioneId, page, perPage);
    }

    @RolesAllowed({"ADMIN", "USER"})
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Biglietto find(@PathParam("id") Long id) {
        Biglietto found = store.findById(id).orElseThrow(() -> new NotFoundException());
        checkUser(found.getUtente().getId());
        return found;
    }

    @RolesAllowed({"ADMIN", "USER"})
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        Biglietto found = store.findById(id).orElseThrow(() -> new NotFoundException());
        checkUser(found.getUtente().getId());
        store.remove(found.getId());
    }

    private void checkUser(Long id) {
        if (jwt.getGroups().contains("ADMIN")) {
            return;
        }
        long loggedId = Long.parseLong(jwt.getSubject());
        if (loggedId != id) {
            throw new BadRequestException("Id biglietto non valido");
        }
    }

}
