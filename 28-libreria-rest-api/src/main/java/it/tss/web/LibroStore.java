/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web;

import java.util.List;
import javax.enterprise.context.Dependent;

/**
 *
 * @author ospite
 */
@Dependent
public class LibroStore extends AbstractStore<Libro> {

    public List<Libro> all() {
        return em.createNamedQuery(Libro.FIND_ALL)
                .getResultList();
    }
}
