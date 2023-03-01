/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jfx.attivita;

import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;

/**
 *
 * @author alfonso
 */
public class Attivita extends AbstractEntity {

    @PastOrPresent
    private LocalDate data;
    @Min(1)
    private int durata; //minuti
    private String descrizione;
    private int costo;

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

    @Override
    public String toString() {
        return "{" + super.toString().replace("}", "") + ", data=" + data + ", durata=" + durata + ", descrizione=" + descrizione + ", costo=" + costo + '}';
    }

}
