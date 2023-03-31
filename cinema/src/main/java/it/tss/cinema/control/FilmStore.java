package it.tss.cinema.control;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.tss.cinema.entity.Film;

public class FilmStore extends AbstractStore<Film> {

    @PersistenceContext
    EntityManager em;

    public Stream<Film> search(String search) {
        return (search == null || search.isBlank()) ? em.createNamedQuery(Film.FIND_ALL, Film.class).getResultStream()
                : em.createNamedQuery(Film.FIND_BY_SEARCH, Film.class)
                        .setParameter("search", search)
                        .getResultStream();
    }

}
