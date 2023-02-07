/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.gestrent;

/**
 *
 * @author ospite
 */
public class Bike extends Mezzo {
    int peso;
    
    public Bike(int peso, String type, String targa, String modello) {
        super(type, targa, modello);
        this.peso = peso;
    }
    
}
