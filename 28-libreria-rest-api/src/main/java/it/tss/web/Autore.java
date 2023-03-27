/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web;

import java.io.Serializable;
import java.util.Objects;
import javax.enterprise.context.Dependent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author ospite
 */
@NamedQueries({
    @NamedQuery(name = Autore.FIND_ALL,
            query = "select e from Autore e order by e.cognome")
})
@Entity
public class Autore extends AbstractEntity {

    public final static String FIND_ALL = "Autore.findAll";
    
    @NotBlank(message = "nome non può essere vuoto")
    @Column(nullable = false)
    private String nome;
    @NotBlank(message = "cognome non può essere vuoto")
    @Column(nullable = false)
    private String cognome;

    private String nazionalita;

    public Autore() {
    }

    public Autore(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    @Override
    public String toString() {
        return "Autore{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", nazionalita=" + nazionalita + '}';
    }

}
