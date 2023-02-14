/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.interfacce;

/**
 *
 * @author ospite
 */
public abstract class AbstractRiproducibile extends Multimediale
        implements
        IRiproducibile,
        IRegolaVolume {

    private final int MAX_VOLUME = 10;
    private final int durata;
    private int volume;

    public AbstractRiproducibile(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    @Override
    public int getDurata() {
        return this.durata;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void weaker() {
        if (volume > 0) {
            volume--;
        }
    }

    @Override
    public void louder() {
        if (volume < MAX_VOLUME) {
            volume++;
        }
    }

}
