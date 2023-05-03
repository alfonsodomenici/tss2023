/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cinema.control;

import it.tss.cinema.AcquistoBiglietto;
import it.tss.cinema.Control;
import it.tss.cinema.RinunciaBiglietto;
import it.tss.cinema.entity.Biglietto;
import it.tss.cinema.entity.Film;
import it.tss.cinema.entity.Proiezione;
import it.tss.cinema.entity.Sala;
import java.util.List;
import java.util.Optional;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author ospite
 */
@Control
public class ProiezioneStore extends AbstractStore<Proiezione> {

    @Inject
    BigliettoStore bigliettoStore;

    public ProiezioneStore() {
        super(Proiezione.class);
    }

    @Override
    public void remove(Long id) {
        bigliettoStore.byProiezione(id)
                .forEach(v -> bigliettoStore.remove(v.getId()));
        super.remove(id);
    }

    public List<Proiezione> findAll() {
        return em.createNamedQuery(Proiezione.FIND_ALL, Proiezione.class)
                .getResultList();
    }

    public List<Proiezione> byFilm(Long filmId) {
        return em.createNamedQuery(Proiezione.FIND_BY_FILM, Proiezione.class)
                .setParameter("id", filmId)
                .getResultList();
    }

    public List<Proiezione> byProgrammazione(Long programmazioneId) {
        return em.createNamedQuery(Proiezione.FIND_BY_PROGRAMMAZIONE, Proiezione.class)
                .setParameter("id", programmazioneId)
                .getResultList();
    }

    public Proiezione onAcquistoBiglietto(@Observes @AcquistoBiglietto Biglietto e) {
        Proiezione found = findById(e.getProiezione().getId()).orElseThrow(() -> new NotFoundException());
        if (found.getDisponibilita() < e.getQuantita()) {
            throw new BadRequestException("quantita non disponibile");
        }
        found.setDisponibilita(found.getDisponibilita() - e.getQuantita());
        return save(found);
    }

    public Proiezione onRinunciaBiglietto(@Observes @RinunciaBiglietto Biglietto e) {
        Proiezione found = findById(e.getProiezione().getId()).orElseThrow(() -> new NotFoundException());
        found.setDisponibilita(found.getDisponibilita() + e.getQuantita());
        return save(found);
    }

}
