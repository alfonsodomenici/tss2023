/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web;

import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author ospite
 */
@Transactional(Transactional.TxType.REQUIRED)
@RequestScoped
public class MessaggioStore {

    @Inject
    private EntityManager em;

    public List<Messaggio> findAll() {
        return em.createNamedQuery(Messaggio.FIND_ALL, Messaggio.class)
                .getResultList();
    }

    public List<Messaggio> findByTesto(String search) {
        return em.createNamedQuery(Messaggio.FIND_BY_TESTO, Messaggio.class)
                .setParameter("search", "%" + search + "%")
                .getResultList();
    }

    public Optional<Messaggio> find(int id) {
        Messaggio found = em.find(Messaggio.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }
    
    public Messaggio save(Messaggio e){
        return em.merge(e);
    }
    
    public void delete(int id){
        find(id).ifPresent(em::remove);
    }
}
