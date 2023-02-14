/*
ESERCIZIO OPZIONALE
Un Elemento Multimediale è una Immagine, un Filmato o una registrazione Audio identificato da
un titolo (una stringa non vuota).
Un elemento è riproducibile se ha una durata (un valore positivo di tipo int) e un metodo play().
Una registrazione Audio è riproducibile e ha associato anche un volume (un valore positivo di tipo
int) e i metodi weaker() e louder() per regolarlo. Se riprodotta, ripete per un numero di volte pari
alla durata la stampa del titolo concatenato a una sequenza di punti esclamativi di lunghezza pari al
volume (una stampa per riga).
Un Filmato è riproducibile e ha associato un volume regolabile analogo a quello delle registrazioni
audio e anche una luminosità (un valore positivo di tipo int) e i metodi brighter() e darker() per
regolarla. Se riprodotta, ripete per un numero di volte pari alla durata la stampa del titolo
concatenato a una sequenza di punti esclamativi di lunghezza pari al volume e poi a una sequenza di
asterischi di lunghezza pari alla luminosità (una stampa per riga).
Una Immagine non è riproducibile, ma ha una luminosità regolabile analoga a quella dei filmati e un
metodo show() che stampa il titolo concatenato a una sequenza di asterischi di lunghezza pari alla
luminosità
Eseguire un oggetto multimediale significa invocarne il metodo show() se è un'immagine o il
metodo play() se è riproducibile.
Organizzare opportunamente con classi astratte, interfacce e classi concrete il codice di un lettore
multimediale che memorizza 5 elementi (creati con valori letti da tastiera) in un array e poi chiede
ripetutamente all'utente quale oggetto eseguire (leggendo un intero da 1 a 5 oppure 0 per finire) e
dopo ogni esecuzione fornisce la possibilità di regolarne eventuali parametri (volume / luminosità). 
 */
package it.tss.ex.interfacce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class App {

    public static void main(String[] args) {
        List<Multimediale> playlist = new ArrayList<>();
        playlist.add(new Audio("kiss", 5, 5));
        playlist.add(new Filmato("queen live", 10, 5, 50));
        playlist.add(new Immagine("linux", 50));
        int result;
        do {
            result = scegliCosaEseguire(playlist.size());
            if (result != 0) {
                Multimediale selection = playlist.get(result - 1);
                esegui(selection);
                if (selection instanceof IRegolaVolume) {
                    regolaVolume((IRegolaVolume) selection);
                }
                if (selection instanceof IRegolaLuminosita) {
                    regolaLuminosita((IRegolaLuminosita) selection);
                }
            }
        } while (result != 0);
    }

    private static void esegui(Multimediale m) {
        if (m instanceof IRiproducibile) {
            ((IRiproducibile) m).play();
        } else if (m instanceof Immagine) {
            ((Immagine) m).show();
        }
    }

    private static void regolaVolume(IRegolaVolume m) {
        String result = inputRegolazione("vuoi regolare il volume?");
        if (result.equals("+")) {
            m.louder();
        } else if (result.equals("-")) {
            m.weaker();
        }
    }

    private static void regolaLuminosita(IRegolaLuminosita m) {
        String result = inputRegolazione("vuoi regolare la luminosità?");
        if (result.equals("+")) {
            m.brighter();
        } else if (result.equals("-")) {
            m.darker();
        }
    }

    private static int scegliCosaEseguire(int max) {
        Scanner s = new Scanner(System.in);
        int result;
        do {
            System.out.println("Cosa vuoi eseguire? 0 esci");
            result = s.nextInt();
        } while (result < 0 || result > max);
        return result;
    }

    private static String inputRegolazione(String msg) {
        Scanner s = new Scanner(System.in);
        String result;
        do {
            System.out.println(msg + " (+,-,n");
            result = s.nextLine();
        } while (!result.equals("+") && !result.equals("-") && !result.equals("n"));
        return result;
    }

}
