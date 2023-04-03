package it.tss.cinema.boundary;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.tss.cinema.Boundary;
import it.tss.cinema.control.UtenteStore;
import it.tss.cinema.entity.Utente;

@Boundary
@Path("utenti")
public class UtentiResource {

    @Inject
    UtenteStore store;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Utente registrazione(Utente e) {
        return store.save(e);
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Utente login(@FormParam("username") String usr,
            @FormParam("password") String pwd) {
        return store.findByUsrAndPwd(usr, pwd)
                .orElseThrow(() -> new NotFoundException());
    }
}
