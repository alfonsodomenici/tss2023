/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web.libri;

import it.tss.web.AbstractStore;
import it.tss.web.categorie.CategoriaStore;
import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.json.JsonObject;

/**
 *
 * @author ospite
 */
@Dependent
public class LibroStore extends AbstractStore<Libro> {

    @Inject
    CategoriaStore categoriaStore;
    
    public List<Libro> all() {
        return em.createNamedQuery(Libro.FIND_ALL)
                .getResultList();
    }

    public Libro patch(Libro e, JsonObject json) {
        if (json.containsKey("titolo")) {
            e.setTitolo(json.getString("titolo"));
        }
        if (json.containsKey("data_pubblicazione")) {
            e.setDataPubblicazione(
                    LocalDate.parse(json.getString("data_pubblicazione"))
            );
        }
        if(json.containsKey("categorie")){
           e.setCategorie(
                   categoriaStore.findOrSave(e.getCategorie())
           );
        }
        return save(e);
    }
}
