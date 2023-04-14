/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cinema.boundary;

import it.tss.cinema.Boundary;
import it.tss.cinema.control.ProgrammazioneStore;
import it.tss.cinema.control.ProiezioneStore;
import it.tss.cinema.control.SalaStore;
import it.tss.cinema.entity.Programmazione;
import it.tss.cinema.entity.Proiezione;
import it.tss.cinema.entity.Sala;
import java.util.List;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.PostActivate;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
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
@DenyAll
@Boundary
@Path("programmazioni")
public class ProgrammazioniResource {

    @Inject
    ProgrammazioneStore store;

    @Inject
    ProiezioneStore proiezioneStore;

    @Inject
    SalaStore salaStore;

    @RolesAllowed({"ADMIN", "USER"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Programmazione> prossime() {
        return store.prossime();
    }

    @RolesAllowed({"ADMIN", "USER"})
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Programmazione find(@PathParam("id") Long id) {
        return store.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @RolesAllowed({"ADMIN", "USER"})
    @GET
    @Path("{id}/proiezioni")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proiezione> proiezioni(@PathParam("id") Long id) {
        return proiezioneStore.byProgrammazione(id);
    }

    @RolesAllowed({"ADMIN"})
    @POST
    @Path("{id}/proiezioni")
    @Produces(MediaType.APPLICATION_JSON)
    public Proiezione creaProiezione(@PathParam("id") Long id, Proiezione e) {
        Programmazione foundProgr = store.findById(id).orElseThrow(() -> new NotFoundException());
        if (e == null || e.getSala() == null || e.getSala().getId() == null) {
            throw new BadRequestException();
        }
        Sala foundSala = salaStore.findById(e.getSala().getId()).orElseThrow(() -> new NotFoundException());
        e.setProgrammazione(foundProgr);
        e.setSala(foundSala);
        e.setDisponibilita(foundSala.getPosti());
        return proiezioneStore.save(e);
    }
}
