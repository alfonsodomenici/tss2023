/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.libreria;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ospite
 */
public class Store {
    
    private static System.Logger log = 
            System.getLogger( Store.class.getName());
    
    private static EntityManager em;

    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();
    }
    
    public static <T> T save(T e){
        
        log.log(System.Logger.Level.INFO, "begin save...");
        em.getTransaction().begin();
        final T saved = em.merge(e);
        em.getTransaction().commit();
        return saved;
    }
    
    public static List<Categoria> allCategorie(){
        return em.createQuery("select e from Categoria e",Categoria.class)
                .getResultList();
    }
    
    public static List<Libro> allLibri(){
        return em.createQuery("select e from Libro e",Libro.class)
                .getResultList();
    }
    
    public static List<Libro> libriByAutore(String cognome){
        return em.createNamedQuery(Libro.FIND_BY_AUTHOR)
                .setParameter("pcognome", cognome)
                .getResultList();
    }
}
