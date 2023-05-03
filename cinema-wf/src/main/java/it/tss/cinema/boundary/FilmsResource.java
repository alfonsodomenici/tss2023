/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cinema.boundary;

import it.tss.cinema.Boundary;
import it.tss.cinema.control.FilmStore;
import it.tss.cinema.control.ProgrammazioneStore;
import it.tss.cinema.control.ProiezioneStore;
import it.tss.cinema.control.SalaStore;
import it.tss.cinema.entity.Film;
import it.tss.cinema.entity.Programmazione;
import it.tss.cinema.entity.Sala;
import java.util.List;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
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
import it.tss.cinema.entity.Proiezione;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;

/**
 *
 * @author ospite
 */
@DenyAll
@Boundary
@Path("films")
public class FilmsResource {

    @Inject
    FilmStore store;

    @Inject
    SalaStore salaStore;

    @Inject
    ProiezioneStore proiezioneStore;

    @Inject
    ProgrammazioneStore programmazioneStore;

    @RolesAllowed({"ADMIN"})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Film create(Film e) {
        return store.save(e);
    }

    @RolesAllowed({"ADMIN", "USER"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> all() {
        return store.all();
    }

    @RolesAllowed({"ADMIN", "USER"})
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Film find(@PathParam("id") Long id) {
        return store.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @RolesAllowed({"ADMIN"})
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Film update(@PathParam("id") Long id, Film e) {
        e.setId(id);
        return store.save(e);
    }

    @RolesAllowed({"ADMIN"})
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        store.remove(id);
    }

    @RolesAllowed({"ADMIN"})
    @GET
    @Path("{id}/programmazioni")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Programmazione> programmazioni(@PathParam("id") Long id) {
        Film found = store.findById(id).orElseThrow(() -> new NotFoundException());
        return programmazioneStore.byFilm(found.getId());
    }

    @RolesAllowed({"ADMIN"})
    @POST
    @Path("{id}/programmazioni")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Programmazione creaProgrammazione(@PathParam("id") Long id, @Valid ProgDTO e) {
        Film found = store.findById(id).orElseThrow(() -> new NotFoundException());
        Optional<Programmazione> searchProgr = programmazioneStore.byFilmAndData(id, e.il);
        Programmazione p = searchProgr.isEmpty()
                ? programmazioneStore.save(
                        new Programmazione(found, e.il, e.prezzo)) : searchProgr.get();
        salaStore.all()
                .stream().filter(v -> e.tutteSale
                || e.sale_id.contains(v.getId()))
                .forEach(v -> proiezioneStore.save(
                new Proiezione(p, v, v.getPosti())));
        return p;
    }
    
    @RolesAllowed({"ADMIN"})
    @GET
    @Path("{id}/proiezioni")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proiezione> proiezioni(@PathParam("id") Long id) {
        Film found = store.findById(id).orElseThrow(() -> new NotFoundException());
        return proiezioneStore.byFilm(found.getId());
    }
}
