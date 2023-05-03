/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cinema.control;

import it.tss.cinema.Control;
import it.tss.cinema.entity.Film;
import it.tss.cinema.entity.Programmazione;
import it.tss.cinema.entity.Sala;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author ospite
 */
@Control
public class ProgrammazioneStore extends AbstractStore<Programmazione> {

    @Inject
    ProiezioneStore proiezioneStore;

    public ProgrammazioneStore() {
        super(Programmazione.class);
    }

    @Override
    public void remove(Long id) {
        proiezioneStore.byProgrammazione(id)
                .forEach(v -> proiezioneStore.remove(v.getId()));
        super.remove(id);
    }

    public List<Programmazione> all() {
        return em.createNamedQuery(Programmazione.FIND_ALL, Programmazione.class)
                .getResultList();
    }

    public List<Programmazione> prossime() {
        return em.createNamedQuery(Programmazione.FIND_BY_DATA, Programmazione.class)
                .setParameter("data", LocalDate.now())
                .getResultList();
    }

    public List<Programmazione> byFilm(Long filmId) {
        return em.createNamedQuery(Programmazione.FIND_BY_FILM)
                .setParameter("film_id", filmId)
                .getResultList();
    }

    public Optional<Programmazione> byFilmAndData(Long filmId, LocalDate data) {

        try {
            Programmazione found = em.createNamedQuery(Programmazione.FIND_BY_FILM, Programmazione.class)
                    .setParameter("film_id", filmId)
                    .setParameter("data", data)
                    .getSingleResult();
            return Optional.of(found);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
