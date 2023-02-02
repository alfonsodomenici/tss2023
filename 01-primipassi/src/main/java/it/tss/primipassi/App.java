/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.primipassi;

import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numero_trofei;
        System.out.println("quanti trofei oggi? ");
        numero_trofei = scanner.nextInt();

// lavoro da eseguire piu' volte
        // quante ??? boh 10
        // come si fa il lavoro0?
        //c'e' scritto sotto
        // per 10 volte fai quello che c'e' scritto sotto
        for (int i = 1; i <= numero_trofei; i++) {
            System.out.println("giro: " + i);
            System.out.println("dammi il punteggio play1: ");
            int x = scanner.nextInt();
            System.out.println("dammi il punteggio di play2: ");
            int y = scanner.nextInt();
            System.out.println("il massimo è:");
            if (x > y) {
                System.out.println(x + " di play1");
            } else {
                System.out.println(y + " di play2");
            }
        }
        System.out.println("HO FINITOOOO!!!!! di dare i trofei");

        // inizio lavoro ripetitivo finche non ho finio
        // finito e' falso
        //ciclo while finche' vera una condizione  gira loop
        // finche' non finito gira
        boolean finito;
        finito = false;
        // mi interessa la somma totale
        int totale = 0;
        // mi interessa il numero persone per poi dividere
        int contapersone = 0;

        while (finito == false) {
            System.out.println("Quanto hai speso? ");
            int spesa = scanner.nextInt();
            if (spesa == -1) {
                finito = true;
            } else {
                totale = totale + spesa;
                //  totale += spesa
                //contapersone = contapersone+1;
                contapersone++;
            }
        }
        // fine while
        System.out.println("il totale e' :" + totale);
        float atesta;
        atesta = totale / contapersone;
        System.out.println("eravate " + contapersone + " e a testa fa : " + atesta);

    }
}
