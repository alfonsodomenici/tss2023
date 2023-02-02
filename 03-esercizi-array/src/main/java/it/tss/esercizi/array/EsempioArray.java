/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.tss.esercizi.array;

import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class EsempioArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // esempio array base
        //int[] elVoti= {8,10,3,6,5,4,8,7,8,9,6,6,7,8,6,7};
        
        // array dimensione scelta da utente?
        //creo oggetto scanner interi prompt per utente
        Scanner inputVoto = new Scanner(System.in);
        
        
        int maxvoti=6; //massimo voti caricabili
        //creo elenco per i voti grande maxvoti
        int[] elVoti = new int[maxvoti];
        
        for (int i=0;i<elVoti.length;i++) {
            System.out.println("ins voto esame: ");
            int voto =inputVoto.nextInt();
            elVoti[i]=voto;
        }
        
        for (int i=0;i<elVoti.length;i++){
            System.out.println("#" + (i+1) + " - " + elVoti[i]);
        }
        
        
    }
    
}
