/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.ereditarieta1;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ospite
 */
public class App {
    public static void main(String[] args) {
        
        List<Prodotto> prodotti = new ArrayList<>();
        prodotti.add(new Alimentare(LocalDate.now(), "zucchero", 10));
        prodotti.add(new Alimentare(
                LocalDate.of(2023,Month.FEBRUARY,25), 
                "caffe", 15));
        prodotti.add(new NonAlimentare("plastica", "sacchetti freezer", 5));
        prodotti.add(new NonAlimentare("metallo", "posate", 20));
        
        System.out.println("Spesa con tessera: " + 
                calcolaSpesa(prodotti, true));      
        
    }
    
    private static double calcolaSpesa(List<Prodotto> prodotti,boolean tesseraFedelta){
        double tot = 0;     
        for (Prodotto p : prodotti) {
            if(tesseraFedelta){
                p.applicaSconto();
                System.out.println("Prezzo scontato: " + p.getPrezzo());
            } 
            tot += p.getPrezzo();
        }
        return tot;
    }
}
