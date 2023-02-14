/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.interfacce;

/**
 *
 * @author ospite
 */
public abstract class AbstractRiproducibile implements Riproducibile {

    private int volume;
    private int durata;

    public AbstractRiproducibile(int volume, int durata) {
        this.volume = volume;
        this.durata = durata;
    }

    public void weaker() {
        volume--;
    }

    public void louder() {
        volume++;
    }

    @Override
    public int durata() {
        return durata;
    }

    
    @Override
    public abstract void play();
    
    
}
