package it.tss.cinema.control;

import java.util.stream.Stream;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.tss.cinema.Control;
import it.tss.cinema.entity.Film;
import java.util.List;
import javax.inject.Inject;

@Control
public class FilmStore extends AbstractStore<Film> {

    @Inject
    ProgrammazioneStore programmazioneStore;
    
    public FilmStore() {
        super(Film.class);
    }

    @PersistenceContext
    EntityManager em;

    public List<Film> all() {
        return  em.createNamedQuery(Film.FIND_ALL, Film.class)
                .getResultList();
    }

    @Override
    public void remove(Long id) {
        programmazioneStore.byFilm(id)
                .forEach(v -> programmazioneStore.remove(v.getId()));
        super.remove(id); 
    }

    
}
