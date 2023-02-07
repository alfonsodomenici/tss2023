/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.dadi.strut;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class Gioco {

    private static int numeroMano;
    private static int soldi;
    private static int puntiB;
    private static int puntiG;

    public static void main(String[] args) {
        boolean isContinua = vuoiCountinuare("Vuoi giocare?");
        while (isContinua) {
            partita();
            System.out.println("------ partita finita ------");
            isContinua = vuoiCountinuare("Vuoi giocare un'altra partita?");
        }
    }

    public static void partita() {
        soldi = 10;
        do {
            gioca();
            stampaUltimaMano();
        } while (soldi > 0 && vuoiCountinuare("Vuoi giocare un'altra mano?"));
    }

    /**
     *
     * esegue una mano del gioco
     */
    private static void gioca() {
        puntiB = lanciaDado();
        puntiG = lanciaDado();
        if (puntiG > puntiB) {
            soldi++;
        } else {
            soldi--;
        }
    }

    /**
     * ritorna un numero random tra 1 e 6
     *
     * @return
     */
    private static int lanciaDado() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }

    private static void stampaUltimaMano() {
        numeroMano++;
        System.out.println("--------------- Mano Numero "
                + numeroMano + " -----------------------");
        System.out.println(String.format("Punti Giocatore: %s - Punti Banco: %s",
                puntiG, puntiB));
        System.out.println("Soldi giocatore: " + soldi);
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
