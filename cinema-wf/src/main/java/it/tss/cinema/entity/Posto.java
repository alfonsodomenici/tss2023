package it.tss.cinema.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "posto",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"proiezione_id","sala_id"})})
public class Posto extends AbstractEntity {

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "proiezione_id")
    Proiezione proiezione;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "sala_id")
    Sala sala;

    @Min(0)
    @Column(nullable = false)
    int disponibilita;

    public Posto() {
    }

    public Posto(Proiezione proiezione, Sala sala, int disponibilita) {
        this.proiezione = proiezione;
        this.sala = sala;
        this.disponibilita = disponibilita;
    }

    public Proiezione getProiezione() {
        return proiezione;
    }

    public void setProiezione(Proiezione proiezione) {
        this.proiezione = proiezione;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    

}
