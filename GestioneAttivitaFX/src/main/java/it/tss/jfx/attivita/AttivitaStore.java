/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jfx.attivita;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Singleton
 * @author alfonso
 */
public class AttivitaStore {

    private static AttivitaStore instance;

    private EntityManager em;

    private AttivitaStore() {
       em = Persistence.createEntityManagerFactory("dbattivita")
               .createEntityManager();
    }

    public static AttivitaStore getInstance() {
        if (instance == null) {
            instance = new AttivitaStore();
        }
        return instance;
    }

    public List<Attivita> all() {
        return em.createQuery("select e from Attivita e order by e.data desc", Attivita.class)
                .getResultList();
                
    }

    public void save(Attivita e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }

    public void remove(Attivita e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

}
