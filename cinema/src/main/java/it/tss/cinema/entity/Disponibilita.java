package it.tss.cinema.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "disponibilita")
public class Disponibilita extends AbstractEntity {

    @ManyToOne
    Proiezione proiezione;

    @ManyToOne
    Sala sala;

    int disponibilita;

    public Disponibilita() {
    }

    public Disponibilita(Proiezione proiezione, Sala sala, int disponibilita) {
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
