/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.libreria;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
})
@Entity
public class Libro implements Serializable {
    
    public final static String FIND_BY_AUTHOR = "Libro.findByAutore";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String titolo;

    @PastOrPresent
    @Column(name = "data_pubblicazione")
    private LocalDate dataPubblicazione;

    @NotNull
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Autore autore;

    @ManyToMany()
    private Set<Categoria> categorie = new HashSet<>();

    public Libro() {
    }

    public Libro(String titolo, LocalDate dataPubblicazione, Autore autore) {
        this.titolo = titolo;
        this.dataPubblicazione = dataPubblicazione;
        this.autore = autore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Categoria> getCategorie() {
        return categorie;
    }

    public void setCategorie(Set<Categoria> categorie) {
        this.categorie = categorie;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titolo=" + titolo + ", dataPubblicazione=" + dataPubblicazione + ", autore=" + autore + ", categorie=" + categorie + '}';
    }



}
