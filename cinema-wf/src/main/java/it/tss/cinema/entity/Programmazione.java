package it.tss.cinema.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

@NamedQueries({
    @NamedQuery(name = Programmazione.FIND_ALL, query = "select e from Programmazione e order by e.il"),
    @NamedQuery(name = Programmazione.FIND_BY_DATA,
            query = "select e from Programmazione e where e.il >= :data order by e.il"),
    @NamedQuery(name = Programmazione.FIND_BY_FILM,
            query = "select e from Programmazione e where e.film.id= :film_id"),
        @NamedQuery(name = Programmazione.FIND_BY_FILM_AND_DATA,
            query = "select e from Programmazione e where e.film.id= :film_id and e.il >= :data ")
})
@Entity
@Table(name = "programmazione",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"film_id", "il"})})
public class Programmazione extends AbstractEntity {

    public static final String FIND_ALL = "Programmazione.findAll";
    public static final String FIND_BY_DATA = "Programmazione.findByData";
    public static final String FIND_BY_FILM = "Programmazione.findByFilm";
    public static final String FIND_BY_FILM_AND_DATA = "Programmazione.findByFilmAndData";

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "film_id")
    Film film;

    @NotNull
    @Column(nullable = false)
    @FutureOrPresent
    LocalDate il;

    @NotNull
    @Column(precision = 4, scale = 2, nullable = false)
    BigDecimal prezzo;

    public Programmazione() {
    }

    public Programmazione(Film film, LocalDate il, BigDecimal prezzo) {
        this.film = film;
        this.il = il;
        this.prezzo = prezzo;
    }

    
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public LocalDate getIl() {
        return il;
    }

    public void setIl(LocalDate il) {
        this.il = il;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

}
