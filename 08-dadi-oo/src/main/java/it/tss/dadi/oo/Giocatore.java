/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.dadi.oo;

/**
 *
 * @author ospite
 */
public class Giocatore {

    private int soldi;

    public Giocatore(int soldi) {
        this.soldi = soldi;
    }

    public int incrementaSoldi() {
        soldi++;
        return soldi;
    }

    public int decrementaSoldi() {
        soldi--;
        return soldi;
    }

    public int getSoldi() {
        return soldi;
    }

    @Override
    public String toString() {
        return "Giocatore{" + "soldi=" + soldi + '}';
    }

    
}
