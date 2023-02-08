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
        
        Banca b = new Banca("sella");
        int nc = b.apriConto("mario");
        System.out.println(nc);
        System.out.println(b.saldo(nc));
        b.deposita(nc, 1000);
        System.out.println(b.saldo(nc));
    }
}
