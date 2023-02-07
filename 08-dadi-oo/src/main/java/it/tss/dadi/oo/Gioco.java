/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.dadi.oo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class Gioco {

    private static int numeroMano;
    private static Giocatore giocatore;
    private static Dado dadoB;
    private static Dado dadoG;

    public static void main(String[] args) {
        dadoB = new Dado();
        dadoG = new Dado();
        boolean isContinua = vuoiCountinuare("Vuoi giocare?");
        while (isContinua) {
            giocatore = new Giocatore(10);
            partita();
            System.out.println("------ partita finita ------");
            isContinua = vuoiCountinuare("Vuoi giocare un'altra partita?");
        }
    }

    public static void partita() {
        do {
            gioca();
            stampaUltimaMano();
        } while (giocatore.getSoldi() > 0 && vuoiCountinuare("Vuoi giocare un'altra mano?"));
    }

    /**
     *
     * esegue una mano del gioco
     */
    private static void gioca() {
        dadoB.lancio();
        dadoG.lancio();
        if (dadoG.getValore() > dadoB.getValore()) {
            giocatore.incrementaSoldi();
        } else {
            giocatore.decrementaSoldi();
        }
    }


    private static void stampaUltimaMano() {
        numeroMano++;
        System.out.println("--------------- Mano Numero "
                + numeroMano + " -----------------------");
        System.out.println(String.format("Punti Giocatore: %s - Punti Banco: %s",
                dadoG.getValore(), dadoB.getValore()));
        System.out.println("Soldi giocatore: " + giocatore.getSoldi());
    }

    /**
     * ritorna true se la risposta è S
     *
     * @return
     */
    private static boolean vuoiCountinuare(String frase) {
        final String SI = "S";
        final String NO = "N";
        String result;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println(frase + " (S/N)");
            result = s.nextLine().toUpperCase();
        } while (!result.equals(NO) && !result.equals(SI));
        return result.equals(SI);
    }

}

