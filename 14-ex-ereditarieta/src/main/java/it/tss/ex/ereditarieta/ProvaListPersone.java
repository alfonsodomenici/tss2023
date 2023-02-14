/*
Si scriva una classe Persona dotata dei campi
CodiceFiscale , Nome , Cognome e dei metodi per leggere tali valori. 
Il costruttore di Persona deve richiedere CodiceFiscale , Nome , Cognome e controllare che questi valori non siano vuoti.  
La classe inoltre dovrà essere dotata del metodo toString(),equals() e hashCode(), tenendo conto che due persone sono uguali se hanno CodiceFiscale uguale . 
Si definisca poi una classe Studente come estensione di Persona ; i campi aggiuntivi di Studente rispetto a Persona sono matricola e università ed andranno richiesti nel Costruttore . Inoltre la classe Studente dovrà avere i metodi per  leggere tali campi e dovrà sovrascrivere il metodo toString() . 
Si definisca infine la classe Docente che estende Persona con campi aggiuntivi materia e salario ed andranno richiesti nel Costruttore. Anche in questo caso la classe dovrà avere metodi per leggere i vari attributi e dovrà sovrascrivere il metodo toString() .

Esercizio 2  Sfruttando le classi dell'Esercizio 1 si scriva la classe
ElencoPersone le cui istanze rappresentano elenchi di persone. 
La classe avrà i seguenti metodi:
    • un metodo aggiungi(Persona p) che aggiunge p all'elenco;
    • un metodo toString() che ritorni l’elenco di persone in formato String.
Si scriva poi una classe ProvaListaPersone con il solo metodo main che crea una lista di
persone la cui dimensione è scelta dall'utente; chiede poi ripetutamente all'utente di inserire, a
sua scelta, una Persona , uno Studente o un Docente , chiedendo i dati opportuni; infine
stampa la lista delle persone inserite. 
 */
package it.tss.ex.ereditarieta;

import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class ProvaListPersone {

    private static ElencoPersone elenco = new ElencoPersone();

    public static void main(String[] args) {
        int azione;
        do {
            azione = menu();
            try {
                esegui(azione);
            } catch (IllegalArgumentException ex) {
                System.err.println("Si è verificato un errore...");
                System.err.println(ex.getMessage());
            }
        } while (azione != 5);
    }

    private static int menu() {
        System.out.println("------------- Menu ------------------");
        System.out.println("\t 1-Aggiungi Persona");
        System.out.println("\t 2-Aggiungi Studente");
        System.out.println("\t 3-Aggiungi Docente");
        System.out.println("\t 4-Stampa persone");
        System.out.println("\t 5-Stampa persone ed esci");
        System.out.println("");
        System.out.println("Cosa vuoi fare?");
        Scanner s = new Scanner(System.in);
        int azione;
        boolean isSceltaErrata;
        do {
            azione = s.nextInt();
            isSceltaErrata = azione < 1 || azione > 5;
            if (isSceltaErrata) {
                System.out.println("scelta non riconosciuta");
            }
        } while (isSceltaErrata);
        return azione;
    }

    private static void esegui(int azione) {
        switch (azione) {
            case 1:
                elenco.aggiungi(inputPersona());
                break;
            case 2:
                elenco.aggiungi(inputStudente());
                break;
            case 3:
                elenco.aggiungi(inputDocente());
                break;
            case 4:
            case 5:
                System.out.println(elenco);
        }
    }

    private static Persona inputPersona() {
        return new Persona(
                inputString("nome?"),
                inputString("cognome?"),
                inputString("codice fiscale?")
        );
    }

    private static Studente inputStudente() {
        return new Studente(
                inputString("nome?"),
                inputString("cognome?"),
                inputString("codice fiscale?"),
                inputString("matricola?"),
                inputString("università?")
        );
    }

    private static Docente inputDocente() {
        return new Docente(
                inputString("nome?"),
                inputString("cognome?"),
                inputString("codice fiscale?"),
                inputString("materia?"),
                inputDouble("salario?")
        );
    }

    private static String inputString(String msg) {
        Scanner s = new Scanner(System.in);
        System.out.println(msg);
        String value = s.nextLine();
        return value;
    }

    private static double inputDouble(String msg) {
        Scanner s = new Scanner(System.in);
        System.out.println(msg);
        double value = s.nextDouble();
        return value;
    }

}
