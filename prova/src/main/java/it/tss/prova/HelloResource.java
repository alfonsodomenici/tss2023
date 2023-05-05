/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.prova;

import java.time.LocalDateTime;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ospite
 */
@Path("hello")
public class HelloResource {
    
    @Inject
    MessageService srv;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return srv.getHelloMessageByHour(
                LocalDateTime.now().getHour());
    }
}
