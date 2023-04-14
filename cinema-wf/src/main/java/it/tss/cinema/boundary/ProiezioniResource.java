/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cinema.boundary;

import it.tss.cinema.Boundary;
import it.tss.cinema.control.BigliettoStore;
import it.tss.cinema.control.ProiezioneStore;
import it.tss.cinema.control.SalaStore;
import it.tss.cinema.control.UtenteStore;
import it.tss.cinema.entity.Biglietto;
import it.tss.cinema.entity.Programmazione;
import it.tss.cinema.entity.Proiezione;
import it.tss.cinema.entity.Sala;
import it.tss.cinema.entity.Utente;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 *
 * @author ospite
 */
@DenyAll
@Boundary
@Path("proiezioni")
public class ProiezioniResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    ProiezioneStore store;

    @Inject
    BigliettoStore bigliettoStore;

    @Inject
    UtenteStore utenteStore;

    @RolesAllowed({"ADMIN", "USER"})
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Proiezione find(@PathParam("id") Long id) {
        return store.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @RolesAllowed({"ADMIN", "USER"})
    @GET
    @Path("{id}/biglietti")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Biglietto> biglietti(@PathParam("id") Long id) {
        Utente logged = utenteStore.findById(Long.parseLong(jwt.getSubject()))
                .orElseThrow(() -> new NotFoundException());

        return bigliettoStore.byProiezioneUtente(id, logged.getId());
    }

    @RolesAllowed({"ADMIN", "USER"})
    @POST
    @Path("{id}/biglietti")
    @Produces(MediaType.APPLICATION_JSON)
    public Biglietto creaBiglietto(@PathParam("id") Long id, Biglietto e) {
        Utente logged = utenteStore.findById(Long.parseLong(jwt.getSubject()))
                .orElseThrow(() -> new NotFoundException());
        Proiezione found = store.findById(id).orElseThrow(() -> new NotFoundException());
        e.setProiezione(found);
        e.setUtente(logged);
        return bigliettoStore.save(e);
    }

}
