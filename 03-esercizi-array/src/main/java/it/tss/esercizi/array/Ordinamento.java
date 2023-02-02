/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.esercizi.array;

import java.util.Arrays;

/**
 *
 * @author ospite
 */
public class Ordinamento {

    public static void main(String[] args) {
        int[] numeri = {5, 4, 3, 2, 1, 4, 6, 78, 56, 76, 34, 23, 1, 5, 78, 90, 87, 56, 4, 23, 12, 234, 46};
        //ordinaBubbleSort(numeri);
        Arrays.sort(numeri);
        stampa(numeri);
    }

    private static void ordinaBubbleSort(int[] numeri) {
        int indice;
        boolean hoScambiato;
        do {
            hoScambiato = false;
            indice = 0;
            while (indice < numeri.length - 1) {
                if (numeri[indice] > numeri[indice + 1]) {
                    hoScambiato = true;
                    int temp = numeri[indice];
                    numeri[indice] = numeri[indice + 1];
                    numeri[indice + 1] = temp;
                }
                indice++;
            }
        } while (hoScambiato);
    }

    private static void ordinaQuickSort(int[] numeri) {
        
    }
    
    private static void stampa(int[] numeri) {
        int indice = 0;
        while (indice < numeri.length) {
            System.out.println(numeri[indice]);
            indice++;
        }
    }
}
