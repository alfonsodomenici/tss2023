/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.libreria.rest.client;

import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ospite
 */
@Path("client")
public class AutoriClient {
    
    Client client = ClientBuilder.newClient();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray all(){
        Response resp = client
                .target("http://localhost:8080/28-libreria-rest-1.0/api/autori")
                .request(MediaType.APPLICATION_JSON)
                .get();
        return resp.readEntity(JsonArray.class);
    }
}
