package it.tss.cinema.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NamedQueries({
    @NamedQuery(name = Proiezione.FIND_BY_PROGRAMMAZIONE, 
            query = "select e from Proiezione e where e.programmazione.id= :id"),})

@Entity
@Table(name = "proiezione",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"programmazione_id", "sala_id"})})
public class Proiezione extends AbstractEntity {

    public static final String FIND_BY_PROGRAMMAZIONE = "Proiezione.findByProgrammazione";

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "programmazione_id")
    Programmazione programmazione;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "sala_id")
    Sala sala;

    @Min(0)
    @Column(nullable = false)
    int disponibilita;

    public Proiezione() {
    }

    public Proiezione(Programmazione programmazione, Sala sala, int disponibilita) {
        this.programmazione = programmazione;
        this.sala = sala;
        this.disponibilita = disponibilita;
    }

    public Programmazione getProgrammazione() {
        return programmazione;
    }

    public void setProgrammazione(Programmazione programmazione) {
        this.programmazione = programmazione;
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
