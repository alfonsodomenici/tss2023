/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.interfacce;

import java.util.Objects;

/**
 *
 * @author ospite
 */
public class Multimediale {

    private final String titolo;

    public Multimediale(String titolo) {
        this.titolo = titolo;
    }

    /*
    getter setter
     */
    public String getTitolo() {
        return titolo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.titolo);
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
        final Multimediale other = (Multimediale) obj;
        return Objects.equals(this.titolo, other.titolo);
    }

    @Override
    public String toString() {
        return titolo;
    }

}
