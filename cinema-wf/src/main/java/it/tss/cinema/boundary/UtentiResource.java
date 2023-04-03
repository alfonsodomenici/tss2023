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
import it.tss.cinema.TokenManager;
import it.tss.cinema.control.UtenteStore;
import it.tss.cinema.entity.Utente;
import java.math.BigDecimal;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;

@DenyAll
@Boundary
@Path("utenti")
public class UtentiResource {

    @Inject
    UtenteStore store;

    @Inject
    TokenManager tokenManager;
    
    @PermitAll
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Utente registrazione(Utente e) {
        return store.save(e);
    }

    @PermitAll
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("username") String usr,
            @FormParam("password") String pwd) {
        Utente found = store.findByUsrAndPwd(usr, pwd)
                .orElseThrow(() -> new NotFoundException());
        String jwt = tokenManager.generate(found);
        JsonObject json = Json.createObjectBuilder()
                .add("jwt", jwt)
                .build();
        return Response.ok(json).build();
    }
    
}
