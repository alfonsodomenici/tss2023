/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web.categorie;

import it.tss.web.AbstractStore;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author ospite
 */
public class CategoriaStore extends AbstractStore<Categoria> {

    public List<Categoria> findOrSave(List<Categoria> e) {
        List<Categoria> result = new ArrayList<Categoria>();
        e.forEach(v -> result.add(findOrSave(v)));
        return result;
    }

    public Categoria findOrSave(Categoria e) {
        return e.getId() != null
                ? findById(e.getId())
                        .orElseThrow(() -> new NotFoundException("Categoria non trovata"))
                : save(e);
    }

    public List<Categoria> all() {
        return em.createNamedQuery(Categoria.FIND_ALL)
                .getResultList();
    }
}
