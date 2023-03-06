/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jfx.attivita;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

/**
 *
 * @author alfonso
 */
@Entity
@Table(name = "t_attivita")
public class Attivita extends AbstractEntity implements Serializable{

    @ManyToOne
    private Utente utente;
    
    @NotNull
    @PastOrPresent(message = "la data non essere nel futuro")
    @Column(name = "il")
    private LocalDate data;
    
    @Positive(message = "la durata deve essere > 0")
    private int durata; //minuti
    @Column(name = "descr",length = 1024)
    
    @NotBlank(message = "la descrizione non può essere vuota")
    private String descrizione;
    
    private int costo;
    
    @ManyToMany()
    @JoinTable(name = "t_attivita_tag", 
            joinColumns = {@JoinColumn(name = "attivita_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();
    
    public Attivita() {
        data = LocalDate.now();
    }

    public Attivita(LocalDate data, int durata, int costo, String descrizione) {
        this.data = data;
        this.durata = durata;
        this.costo = costo;
        this.descrizione = descrizione;
    }


    /*
    getters / setters
     */
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
    
    
    @Override
    public String toString() {
        return "{" + super.toString().replace("}", "") + ", data=" + data + ", durata=" + durata + ", descrizione=" + descrizione + ", costo=" + costo + '}';
    }

}
