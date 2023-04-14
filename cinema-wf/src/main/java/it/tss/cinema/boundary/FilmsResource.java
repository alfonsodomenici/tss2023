/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cinema.boundary;

import it.tss.cinema.Boundary;
import it.tss.cinema.control.FilmStore;
import it.tss.cinema.control.ProgrammazioneStore;
import it.tss.cinema.control.SalaStore;
import it.tss.cinema.entity.Film;
import it.tss.cinema.entity.Programmazione;
import it.tss.cinema.entity.Sala;
import java.util.List;
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
    ProgrammazioneStore programmazioneStore;
    
    @RolesAllowed({"ADMIN"})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Film create(Film e){
        return store.save(e);
    }
    
    @RolesAllowed({"ADMIN","USER"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> all(){
        return store.all();
    }
    
    @RolesAllowed({"ADMIN","USER"})
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Film find(@PathParam("id") Long id) {
        return store.findById(id).orElseThrow(() -> new NotFoundException());
    }
    
    @RolesAllowed({"ADMIN","USER"})
    @GET
    @Path("{id}/programmazioni")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Programmazione> programmazioni(@PathParam("id") Long id) {
        Film found = store.findById(id).orElseThrow(() -> new NotFoundException());
        return programmazioneStore.byFilm(found.getId());
    }
    
    @RolesAllowed({"ADMIN","USER"})
    @POST
    @Path("{id}/programmazioni")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Programmazione creaProgrammazione(@PathParam("id") Long id, Programmazione e) {
        Film found = store.findById(id).orElseThrow(() -> new NotFoundException());
        e.setFilm(found);
        return programmazioneStore.save(e);
    }
}
