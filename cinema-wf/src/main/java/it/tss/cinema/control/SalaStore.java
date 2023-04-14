/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cinema.control;

import it.tss.cinema.Control;
import it.tss.cinema.entity.Film;
import it.tss.cinema.entity.Sala;
import java.util.List;

/**
 *
 * @author ospite
 */
@Control
public class SalaStore extends AbstractStore<Sala> {

    public SalaStore() {
        super(Sala.class);
    }

    public List<Sala> all() {
        return em.createNamedQuery(Sala.FIND_ALL, Sala.class)
                .getResultList();
    }
}
