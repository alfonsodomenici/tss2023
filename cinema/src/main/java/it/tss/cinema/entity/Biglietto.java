package it.tss.cinema.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "biglietto")
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
    
    @ManyToOne
    Proiezione proiezione;
    
    @ManyToOne
    Sala sala;

    @ManyToOne
    Utente utente;

    @Enumerated(EnumType.STRING)
    Tipo tipo;

    public Biglietto() {
    }

    public Biglietto(Proiezione proiezione, Sala sala, Utente utente, Tipo tipo) {
        this.proiezione = proiezione;
        this.sala = sala;
        this.utente = utente;
        this.tipo = tipo;
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

    



}
