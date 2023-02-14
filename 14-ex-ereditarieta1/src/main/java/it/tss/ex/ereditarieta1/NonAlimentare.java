/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.ereditarieta1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ospite
 */
public class NonAlimentare extends Prodotto {

    private final String materiale;
    private static final List<String> reciclabili;
    private static final double SCONTO = 0.1;

    static {
        reciclabili = new ArrayList<>();
        reciclabili.add("carta");
        reciclabili.add("vetro");
        reciclabili.add("plastica");
    }

    public NonAlimentare(String materiale, String descrizione, double prezzo) {
        super(descrizione, prezzo);
        this.materiale = materiale;
    }

    @Override
    public void applicaSconto() {
        if (reciclabili.contains(materiale.toLowerCase())) {
            prezzo -= prezzo * SCONTO;
        } else {
            super.applicaSconto();
        }
    }

    /*
    getter setter
     */
    public String getMateriale() {
        return materiale;
    }

}
