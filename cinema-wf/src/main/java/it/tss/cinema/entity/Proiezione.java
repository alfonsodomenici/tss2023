package it.tss.cinema.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "proiezione", 
    uniqueConstraints = {@UniqueConstraint(columnNames = {"film_id","il"} )})
public class Proiezione extends AbstractEntity {
    
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "film_id")
    Film film;

    @NotNull
    @Column(nullable = false)
    @FutureOrPresent
    LocalDate il;

    @NotNull
    @Column(precision = 4, scale = 2,nullable = false)
    BigDecimal prezzo;

    public Proiezione() {
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
