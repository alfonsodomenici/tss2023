/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.interfacce;

/**
 *
 * @author ospite
 */
public class Immagine extends Multimediale implements IRegolaLuminosita {

    private final int MAX_LUMINOSITA = 100;
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public void show() {
        StringBuilder sb = new StringBuilder(toString());
        for (int i = 0; i < getLuminosita(); i++) {
            sb.append("*");
        }
        System.out.println(sb.toString() );
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
