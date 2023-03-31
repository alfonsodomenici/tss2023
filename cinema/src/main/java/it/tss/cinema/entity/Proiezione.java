package it.tss.cinema.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "proiezione")
public class Proiezione extends AbstractEntity {
    @ManyToOne
    Film film;

    @NotEmpty
    @ManyToMany
    @JoinTable(name = "posti", 
        joinColumns = {@JoinColumn(name = "proiezione_id")},
        inverseJoinColumns = {@JoinColumn(name = "disponibilita_id")})
    Set<Disponibilita> posti = new HashSet<>();

    LocalDateTime il;

    @Column(precision = 4, scale = 2)
    BigDecimal prezzo;

    public Proiezione() {
    }

    public Proiezione(Film film, Set<Disponibilita> posti, LocalDateTime il, BigDecimal prezzo) {
        this.film = film;
        this.posti = posti;
        this.il = il;
        this.prezzo = prezzo;
    }

    public boolean isEsaurito(){
        return posti.stream()
            .allMatch(v -> v.getDisponibilita()==0);
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Set<Disponibilita> getPosti() {
        return posti;
    }

    public void setPosti(Set<Disponibilita> posti) {
        this.posti = posti;
    }

    public LocalDateTime getIl() {
        return il;
    }

    public void setIl(LocalDateTime il) {
        this.il = il;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }



}
