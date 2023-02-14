/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.ereditarieta;

import java.util.ArrayList;

/**
 *
 * @author ospite
 */
public class ElencoPersone {
    private final ArrayList<Persona> persone = new ArrayList();
    
    public void aggiungi(Persona p){
        persone.add(p);
    }

    @Override
    public String toString() {
        return persone.toString();
    }
    
    
}
