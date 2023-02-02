/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.programmazione.strutturata.matematica;

/**
 *
 * @author ospite
 */
public class Calcolatrice {

    public static int somma(int... numeri) {
        System.out.println("eseguo somma di n interi");
        int result = 0;
        for (int i = 0; i < numeri.length; i++) {
            result += numeri[i];
        }
        return result;

    }

    public static double somma(double... numeri) {
        System.out.println("eseguo somma di n interi");
        int result = 0;
        for (int i = 0; i < numeri.length; i++) {
            result += numeri[i];
        }
        return result;

    }

    /*
    public static int somma(int[] numeri) {
        System.out.println("eseguo somma di un array di interi");
        int result = 0;
        for (int i = 0; i < numeri.length; i++) {
            result += numeri[i];
        }
        return result;
    }
     */
    public static double somma(double p1, double p2) {
        System.out.println("eseguo somma di double");
        return p1 + p2;
    }

}
