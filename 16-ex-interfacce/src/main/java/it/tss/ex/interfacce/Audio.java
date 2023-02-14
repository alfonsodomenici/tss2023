/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.interfacce;

/**
 *
 * @author ospite
 */
public class Audio extends AbstractRiproducibile {

    public Audio(String titolo, int durata, int volume) {
        super(titolo, durata, volume);
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
        return sb.toString();
    }
}
