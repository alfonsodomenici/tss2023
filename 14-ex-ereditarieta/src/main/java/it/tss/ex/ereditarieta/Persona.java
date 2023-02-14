/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.ereditarieta;

import java.util.Objects;

/**
 *
 * @author ospite
 */
public class Persona {

    private final String nome, cognome, cf;

    /**
     * 
     * @param nome non vuoto
     * @param cognome non vuoto
     * @param cf non vuoto 
     */
    public Persona(String nome, String cognome, String cf) {
        if (CheckParamsHelper.isAnyNotValuedString(nome, cognome, cf)) {
            throw new IllegalArgumentException("uno o più parametri vuoti");
        }
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
    }

    /*
    getters/setters
     */
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCf() {
        return cf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.cf);
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
        final Persona other = (Persona) obj;
        return Objects.equals(this.cf, other.cf);
    }

    @Override
    public String toString() {
        return "{" + "nome=" + nome + ", cognome=" + cognome + ", cf=" + cf+ '}';
    }

}
