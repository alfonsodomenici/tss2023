package it.tss.cinema.entity;

import java.math.BigDecimal;
import java.util.function.Predicate;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NamedQueries({
    @NamedQuery(name = Biglietto.FIND_BY_PROIEZIONE,
            query = "select e from Biglietto e where e.proiezione.id= :proiezione_id"),
    @NamedQuery(name = Biglietto.FIND_BY_PROIEZIONE_UTENTE,
            query = "select e from Biglietto e where e.proiezione.id= :proiezione_id and e.utente.id= :utente_id "),})

@Entity
@Table(name = "biglietto",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"proiezione_id", "utente_id", "tipo"})})
public class Biglietto extends AbstractEntity {

    public static final String FIND_BY_PROIEZIONE = "Biglietto.findByProiezione";
    public static final String FIND_BY_PROIEZIONE_UTENTE = "Biglietto.findByProiezioneUtente";

    public static final BigDecimal CENTO = new BigDecimal(100);

    public static enum Tipo {
        INTERO(0, 0), RIDOTTO(30, 14), OMAGGIO(100, 8);

        private int sconto;
        private int eta;

        private Tipo(int sconto, int eta) {
            this.sconto = sconto;
            this.eta = eta;
        }

        public int getSconto() {
            return sconto;
        }

        public int getEta() {
            return eta;
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

    @JsonbTransient
    @AssertTrue(message = "dati biglietto non validi")
    public boolean isValid() {
        boolean invalidTipo = tipo != Tipo.INTERO && utente.eta() > tipo.eta;
        boolean invalidEta = proiezione
                .getProgrammazione()
                .getFilm()
                .getEtaMinima() > utente.eta();
        return !invalidEta && !invalidTipo;
    }

    public BigDecimal getImporto() {
        BigDecimal sconto = proiezione.getProgrammazione()
                .getPrezzo()
                .multiply(new BigDecimal(tipo.getSconto()))
                .divide(CENTO);
        BigDecimal prezzo = proiezione.getProgrammazione()
                .getPrezzo()
                .subtract(sconto);
        return prezzo.multiply(new BigDecimal(quantita));
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
