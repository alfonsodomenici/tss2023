/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

/**
 *
 * @author ospite
 */
@NamedQueries({
    @NamedQuery(name = Libro.FIND_BY_AUTHOR,
            query = "select e from Libro e where e.autore.cognome= :pcognome"),
    @NamedQuery(name = Libro.FIND_ALL,
            query = "select e from Libro e order by e.dataPubblicazione desc")
})
@Entity
public class Libro extends AbstractEntity {

    public final static String FIND_ALL = "Libro.findAll";
    public final static String FIND_BY_AUTHOR = "Libro.findByAutore";

    @NotBlank
    @Column(nullable = false)
    private String titolo;

    @NotNull
    @JsonbProperty(value = "data_pubblicazione")
    @PastOrPresent
    @Column(name = "data_pubblicazione")
    private LocalDate dataPubblicazione;

    //@JsonbTypeAdapter(AutoreLinkAdapter.class)
    @NotNull
    @ManyToOne(optional = false)
    private Autore autore;

    //@JsonbTypeAdapter(CategoriaLinkAdapter.class)
    @ManyToMany(fetch = FetchType.EAGER )
    private List<Categoria> categorie = new ArrayList<>();

    public Libro() {
    }

    public Libro(String titolo, LocalDate dataPubblicazione, Autore autore) {
        this.titolo = titolo;
        this.dataPubblicazione = dataPubblicazione;
        this.autore = autore;
    }

    public JsonObject toJsonSlice(){
        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("titolo", this.titolo)
                .build();
    }
    
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(LocalDate dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public List<Categoria> getCategorie() {
        return categorie;
    }

    public void setCategorie(List<Categoria> categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titolo=" + titolo + ", dataPubblicazione=" + dataPubblicazione + ", autore=" + autore + ", categorie=" + categorie + '}';
    }

}
