/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.tss.esempioverifica;

import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nom,cog;
        Scanner scT = new Scanner(System.in);
        System.out.println("ins nome: ");
        nom=scT.nextLine();
        System.out.println("ins cognome: ");
        cog=scT.nextLine();
        Scanner scN = new Scanner(System.in);
        System.out.println("ins anno: ");
        int anno=scT.nextInt();
        int age = 2023-anno;
        boolean ok= stampaScheda(nom, cog,anno);
        stampaTipo(age);
        
    }
    private static boolean stampaScheda(String nom, String cog, int anno) {
        System.out.println("nome: " + nom + cog + anno);
        return true;
        
    }

     static void stampaTipo(int anni) {
        System.out.println("tipo:" + getTipo(anni));
    }
    static String getTipo(int age){
        String tipo="";
        if (age <18)
            tipo = "giovane";
        if (age >=18 && age <60)
            tipo="adulto";
        if (age>=60)
            tipo="senior";
        return tipo;
    }
    
}
