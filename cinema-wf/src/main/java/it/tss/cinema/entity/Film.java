package it.tss.cinema.entity;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@NamedQueries({
        @NamedQuery(name = Film.FIND_ALL, query = "select e from Film e order by e.titolo"),
})

@Entity
@Table(name = "film")
public class Film extends AbstractEntity {

    public static final String FIND_ALL = "Film.findAll";

    @NotBlank
    @Column(nullable = false)
    String titolo;

    String descrizione;

    String regista;

    @JsonbProperty("eta_minima")
    @Column(name = "eta_minima", nullable = false)
    @Min(0)
    int etaMinima;

    public Film() {
    }

    public Film(String titolo, String descrizione, String regista, int etaMinima) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.regista = regista;
        this.etaMinima = etaMinima;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    public int getEtaMinima() {
        return etaMinima;
    }

    public void setEtaMinima(int etaMinima) {
        this.etaMinima = etaMinima;
    }

}
