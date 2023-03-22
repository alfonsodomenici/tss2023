/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.hello;

import it.tss.hello.entity.Libro;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ospite
 */

@Transactional(Transactional.TxType.REQUIRED)
@RequestScoped
@Path(value = "/libri")
public class LibriResource {
    
    @Inject
    Store store;
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Libro> all(){
        return store.allLibri();
    }
}
