/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.interfacce;

/**
 *
 * @author ospite
 */
public class Filmato extends AbstractRiproducibile
        implements IRegolaLuminosita {

    private final int MAX_LUMINOSITA = 100;
    private int luminosita;

    public Filmato(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata, volume);
        this.luminosita = luminosita;
    }

    @Override
    public void play() {
        for (int i = 0; i < getDurata(); i++) {
            System.out.println(toString());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        for (int i = 0; i < getVolume(); i++) {
            sb.append("!");
        }
        for (int i = 0; i < getLuminosita(); i++) {
            sb.append("*");
        }
        return sb.toString();
    }

    
    @Override
    public int getLuminosita() {
        return this.luminosita;
    }

    @Override
    public void brighter() {
        if (luminosita < MAX_LUMINOSITA) {
            luminosita++;
        }
    }

    @Override
    public void darker() {
        if (luminosita > 0) {
            luminosita--;
        }
    }

}
