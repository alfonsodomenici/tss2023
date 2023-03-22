/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.hello;

import it.tss.hello.entity.Libro;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ospite
 */

@RequestScoped
@Named(value = "libriStore")
public class Store {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Libro> allLibri(){
        return em.createNamedQuery(Libro.FIND_ALL,Libro.class)
                .getResultList();
    }
}
