/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author ospite
 */
@Dependent
public class AutoreStore extends AbstractStore<Autore> {

    public List<Autore> all() {
        return em.createNamedQuery(Autore.FIND_ALL)
                .getResultList();
    }

    public Autore findOrSave(Autore e) {
        return e.getId() != null
                ? findById(e.getId())
                        .orElseThrow(() -> new NotFoundException("Autore non trovato"))
                : save(e);
    }
}
