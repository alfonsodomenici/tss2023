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
        try{
        Scanner s = new Scanner(System.in);
        
        System.out.println("Dimmi il nome dell'intestatario?");
        String intestatario = s.nextLine();
        
        ContoCorrente cc1 = new ContoCorrente(intestatario);
        
        
        System.out.println(cc1);
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            System.out.println("Scusa il programma verrà terminato");
        }
        
    }
}
