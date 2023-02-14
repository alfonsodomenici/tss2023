/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.ereditarieta1;

import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author ospite
 */
public class Prodotto {

    private static final double SCONTO = 0.05;
    private final String codiceBarre;
    private final String descrizione;
    protected double prezzo;

    public Prodotto(String descrizione, double prezzo) {
        this.codiceBarre = UUID.randomUUID().toString();
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public void applicaSconto() {
        prezzo -= prezzo * SCONTO;
    }

    /**
     * getter setter
     */
    public String getCodiceBarre() {
        return codiceBarre;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.codiceBarre);
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
        final Prodotto other = (Prodotto) obj;
        return Objects.equals(this.codiceBarre, other.codiceBarre);
    }

    @Override
    public String toString() {
        return  "codiceBarre=" + codiceBarre + ", descrizione=" + descrizione + ", prezzo=" + prezzo ;
    }

    
}
