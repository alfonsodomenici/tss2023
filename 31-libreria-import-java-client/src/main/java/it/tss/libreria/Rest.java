/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.libreria;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.json.JsonObject;

/**
 *
 * @author ospite
 */
public class Rest {
    
    Client client = ClientBuilder.newClient();
    WebTarget wt;
    
    public Rest() {
        wt = client.target("http://localhost:8080/28-libreria-rest-1.0/api");
    }
    
    public JsonObject findLibro(long id){
        Response resp = wt
                .path("libri")
                .path("{id}")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get();
        return resp.readEntity(JsonObject.class);
    }
    
}
