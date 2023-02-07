/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.tss.gestrent;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class NoleggioMezzi {

    static ArrayList<Mezzo> elMezzi = new ArrayList<Mezzo>();
    static ArrayList<Cliente> elClienti = new ArrayList<Cliente>();
    static ArrayList<Noleggio> elNoleggi = new ArrayList<Noleggio>();
    static ArrayList<String> elType = new ArrayList<>();

    public static void main(String[] args) {
        elType.add("mtb");
        elType.add("gravel");
        elType.add("scooter");

        createMezzo();

    }

    static Mezzo createMezzo() {
        // inserire marca e modello
        Mezzo ris = null;
        Scanner scT;
        scT = new Scanner(System.in);
        System.out.println("ins marca e modello: ");
        String newmodello = scT.nextLine();
        String newtype = askCheckinList("ins tipo da lista: ", elType, true);
        
        String newtarga = askCheckinList("ins targa non in lista: ", getAllTarghe(), false);
        
        ris = new Mezzo(newtype, newtarga, newmodello);
        return ris;

    }

    static ArrayList<String> getAllTarghe(){
        
        ArrayList<String> eltarghe = new ArrayList<String>();
        for (Mezzo m : elMezzi) {
            eltarghe.add(m.getTarga());
        }
        return eltarghe;
    }
    static String askCheckinList(String question,
            ArrayList<String> listCheck, boolean inList) {
        Scanner scT = new Scanner(System.in);
        String ris = "";
        //chiedo info string e verifico in lista
        while (true) {
            // inserire tipo corretto solo da lista
            System.out.println("\nElenco valori:");
            for (String val : listCheck) {
                System.out.print(val + " - ");
            }
            System.out.println();

            System.out.println(question);
            // chiedo il valore
            ris = scT.nextLine();
            // verifico che nella lista ci sia newtype
            boolean ok = false;
            for (String val : listCheck) {
                if (val.equalsIgnoreCase(ris)) {
                    ok = true;
                    break;
                }
            }
            // sono in ciclo while infinito
            // caso inlista trovato e va bene
            if (inList == true) {
                if (ok) {
                    break; // esco dal while true
                }
            } else { // caso non deve essere nella lista
                if (!ok) {
                    break;
                }
            }
        }

        return ris;

    }

}
