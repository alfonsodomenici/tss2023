/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *http://localhost:8080/26-web-1.0-SNAPSHOT/api/messages?search=ciao
 * 
 * 
 * @author ospite
 */
@ApplicationScoped
@Path("messages")
public class MessagesResource {
    
    List<String> messages = Stream.
            of("ciao","arrivederci","alla prox","addio")
            .collect(Collectors.toList());
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> messages(@QueryParam("search") String search){
        
        return search==null ? messages
                :messages.stream()
                .filter(v -> v.contains(search))
                .collect(Collectors.toList());
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String message(@PathParam("id") int index){
        return messages.get(index);
    }
    
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int index){
        messages.remove(index);
    }
}
