package it.tss.esempiometodi;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class GestParking {

    //elenco attributi classe/programma
    static float x, y, z;
    static int numPostiDisponibili;

    //elenco metodi del programma / classe
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //configuro il parcheggio
        initPark();
        // posso aprire il parcheggio
        startPark();

    }

    public static void initPark() {
        Scanner askNum = new Scanner(System.in);
        System.out.println("Ins numero park lato1: ");
        int lato1 = askNum.nextInt();
        System.out.println("Ins numero park lato2: ");
        int lato2 = askNum.nextInt();
        System.out.println("Ins numero piani: ");
        int npiani = askNum.nextInt();
        x = lato1;
        y = lato2;
        z = npiani;
        numPostiDisponibili = (int) getNumParks();

    }

    

    public static float getNumParks() {
        float ris = 0;
        ris = x * y * z;
        return ris;
    }

    

    public static void startPark() {
        //ciclo infinito accendo cancelli
        boolean open=true;
        while (open) {
            //aggiorno display al cancello posti disponibili
            infoParking();
            //gestisco richieste cancelli in e out
            open=gestGate();
        }
    }

    static void infoParking() {
        //cartellone aggiornato  all'ingresso
        System.out.println("Parking OPEN " + "- posti liberi: "
                + numPostiDisponibili +" su "+(int)getNumParks());
        // se ci sono posti solito messaggio
        if (numPostiDisponibili > 0) {
            System.out.println("Scrivi IN per entrare o OUT per uscire");
        } // altrimenti no posti e scrivere solo out
        else {
            System.out.println("COMPLETO!!! Scrivi OUT per uscire");
        }

    }

    static boolean gestGate() {
        boolean ris = true;
        //mi serve un modo perparlare con l'utente
        Scanner pulsante = new Scanner(System.in);
        String comando = pulsante.nextLine();
        if (comando.equalsIgnoreCase("IN")) {
            //decremento il numpostiliberi solo se possibile
            // non basta scrivere in
            if (numPostiDisponibili > 0) {
                numPostiDisponibili--;
            } else {
                System.out.println("PARKING COMPLETO!!! - ingresso vietato");
            }
        }
        if (comando.equalsIgnoreCase("OUT")) {
            if (numPostiDisponibili < getNumParks()) {
                numPostiDisponibili++;
            } else {
                System.out.println("PARKING VUOTO!!! - uscita negata");
            }
        }
        if (comando.equals("EscI")) {
            ris=false;
        }

        return ris;
    }

}
