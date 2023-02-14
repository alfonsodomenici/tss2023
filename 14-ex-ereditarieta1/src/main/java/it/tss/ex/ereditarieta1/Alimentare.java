/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.ereditarieta1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author ospite
 */
public class Alimentare extends Prodotto {

    private final LocalDate dataScadenza;
    private static final double SCONTO = 0.2;
    private static final int GIORNI_PER_SUPER_SCONTO = 10;

    public Alimentare(LocalDate dataScadenza, String descrizione, double prezzo) {
        super(descrizione, prezzo);
        this.dataScadenza = dataScadenza;
    }

    @Override
    public void applicaSconto() {
        long giorniDallaScadenza = ChronoUnit.DAYS.between(LocalDate.now(), dataScadenza);
        if (giorniDallaScadenza < GIORNI_PER_SUPER_SCONTO) {
            prezzo -= prezzo * SCONTO;
        } else {
            super.applicaSconto();
        }
    }

    /**
     * getter setter
     * @return 
     */
    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

}
