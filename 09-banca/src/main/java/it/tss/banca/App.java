/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.banca;

import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class App {

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            Banca banca = new Banca("Sella");
            System.out.println("Dimmi il nome dell'intestatario?");
            String intestatario = s.nextLine();

            banca.apriConto(intestatario);

            banca.apriConto("alfonso");
            
            System.out.println(banca);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Scusa il programma verrà terminato");
        }

    }
}
