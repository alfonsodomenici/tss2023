/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.programmazione.strutturata;

import it.tss.programmazione.strutturata.matematica.C2;
import it.tss.programmazione.strutturata.matematica.Calcolatrice;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

/**
 *
 * @author ospite
 */
public class App {

    public static void main(String[] args) {

        Date adesso = new Date();
        
        LocalDate adesso1 = LocalDate.now();
                
        LocalDate data = LocalDate.of(2018, Month.MARCH, 01);
        
        System.out.println(adesso);
        System.out.println(adesso1);
        System.out.println(data);
        
        C1.m3();

        C3 o = new C3("ciaobelli", "yyyyyyy");

        C5 oggetto = new C5.Builder("ciao", "builder")
                .x5("fdfg")
                .x9("valore x9")
                .n2(10)
                .build();
        
        System.out.println("stato di c5: " + oggetto.toString());
        
        System.out.println("inizio programma");
        String msg = "ciao";
        m1();
        String msgMaiuscolo = m2(msg);
        System.out.println("messaggio trasformato: " + msgMaiuscolo);
        C1.m3();
        C2.m4();
        System.out.println("test somma interi: "
                + Calcolatrice.somma(10, 20, 30));
        System.out.println("test somma virgola: "
                + Calcolatrice.somma(10.5f, 20.35F, 35.2));
        int[] numeri = {10, 45, 6, 3, 8, 98};
        System.out.println("test somma array interi: "
                + Calcolatrice.somma(2, 5, 8, 23, 56));
        System.out.println("test somma array interi: "
                + Calcolatrice.somma(numeri));

        System.out.println("fine programma");
    }

    private static void m1() {
        System.out.println("esecuzione metodo m1");
    }

    private static String m2(String p1) {
        System.out.println("esecuzione metodo m2");
        System.out.println("valore parametro p1=" + p1);
        return p1.toUpperCase();
    }

}
