/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.banca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ospite
 */
public class Banca {

    private final String nome;
    private final List<ContoCorrente> conti = new ArrayList<>();

    public Banca(String nome) {
        this.nome = nome;
    }

    public void apriConto(String intestatario) {
        ContoCorrente nuovoCc = new ContoCorrente(intestatario);
        conti.add(nuovoCc);
    }

    @Override
    public String toString() {
        return "Banca{" + "nome=" + nome + ", conti=" + conti + '}';
    }

}
