/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.tss.esempioverifica;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class NewMain {

    static ArrayList<Integer> elSp = new ArrayList<Integer>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ciclo per chiedere dati e add su lista
        while (true) {
            //chiedo dati 
            Scanner sci = new Scanner(System.in);
            System.out.println("dimmi spesa [0 per exit]: ");
            int sp = sci.nextInt();
            if (sp == 0) {
                break;
            }
            elSp.add(sp);
        }
        stampaspese();

        int num1, num2;
        Scanner sci = new Scanner(System.in);
        System.out.println("dimmi num1: ");
        num1 = sci.nextInt();
        System.out.println("dimmi num2: ");
        num2 = sci.nextInt();
   
        int risSottrazione = sottrazione(num1,num2);
        int per= laPer(num1, num2);
        
    }

    static int sottrazione(int n1, int n2){
        int ris=0;
        ris= n1 - n2;    
        return ris;
    }
    static int laPer(int n1, int n2){
        return n1 * n2;
    }
    
    static void stampaspese() {
        //stampo e intanto calcolo il totale
        int tot = 0;
        for (int i = 0; i < elSp.size(); i++) {
            tot += elSp.get(i);
            System.out.println(elSp.get(i));
        }
        System.out.println("il totale e' : " + tot);

    }

}
