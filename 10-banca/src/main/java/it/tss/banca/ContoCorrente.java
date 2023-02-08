/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.banca;

import java.util.Objects;

/**
 *
 * @author ospite
 */
public class ContoCorrente {

    private static int contatore = 1;
    private double saldo;
    private final String intestatario;
    private final int numero;

    public ContoCorrente(String intestatario) {
        if(intestatario==null || intestatario.isBlank()){
            throw new IllegalArgumentException("intestatario vuoto non permesso");
        }
        this.intestatario = intestatario;
        this.numero = contatore++;
    }

    public void versamento(double importo) {
        if(importo<=0){
            throw new IllegalArgumentException("importo negativo non permesso");
        }
        this.saldo += importo;
    }

    public void prelievo(double importo) {
        if(importo>saldo){
            throw new IllegalArgumentException("saldo non sufficiente");
        }
        this.saldo -= importo;
    }

    /*
    getters / setters
     */
    public double getSaldo() {
        return saldo;
    }

    public String getIntestatario() {
        return intestatario;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "ContoCorrente{" + "saldo=" + saldo + ", intestatario=" + intestatario + ", numero=" + numero + '}';
    }

    
}
