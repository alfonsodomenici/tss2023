/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.dadi.oo;

import java.util.Random;

/**
 *
 * @author ospite
 */
public class Dado {
    private int valore = 1;
    
    public int lancio(){
        Random r = new Random();
        valore = r.nextInt(6) + 1;
        return valore;
    }

    public int getValore() {
        return valore;
    }
    
    
}
