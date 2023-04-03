/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cinema.boundary;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author ospite
 */
@DenyAll
@Path("secure")
public class SecureTestResource {

    @GET
    @RolesAllowed({"ADMIN"})
    @Path("admin")
    public Response testAdmin() {
        return Response.ok().build();
    }

    @GET
    @RolesAllowed({"USER"})
    @Path("user")
    public Response testUser() {
        return Response.ok().build();
    }

    @GET
    @RolesAllowed({"ADMIN","USER"})
    @Path("all")
    public Response testAll() {
        return Response.ok().build();
    }
}
