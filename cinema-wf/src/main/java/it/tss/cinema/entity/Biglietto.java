package it.tss.cinema.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "biglietto",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"proiezione_id","utente_id","tipo"})})
public class Biglietto extends AbstractEntity{
    public static enum Tipo{
        INTERO(0),RIDOTTO(30),OMAGGIO(100);

        private int value;

        private Tipo(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }  
    }
    
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "proiezione_id")
    Proiezione proiezione;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "utente_id")
    Utente utente;

    @NotNull
    @Enumerated(EnumType.STRING)
    Tipo tipo;

    @Min(1)
    @Column(nullable = false)
    int quantita;

    public Biglietto() {
    }

    public Biglietto(Proiezione proiezione, Utente utente, Tipo tipo, @Min(1) int quantita) {
        this.proiezione = proiezione;
        this.utente = utente;
        this.tipo = tipo;
        this.quantita = quantita;
    }

    public Proiezione getProiezione() {
        return proiezione;
    }

    public void setProiezione(Proiezione proiezione) {
        this.proiezione = proiezione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    
}
