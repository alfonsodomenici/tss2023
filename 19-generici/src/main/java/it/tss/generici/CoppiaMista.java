/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.generici;

/**
 *
 * @author ospite
 * @param <T> tipo del primo
 * @param <K> tipo del secondo
 */
public class CoppiaMista<T,K extends Number> implements Runnable{
    
    private final T primo;
    private final K secondo;

    public CoppiaMista(T primo, K secondo) {
        this.primo = primo;
        this.secondo = secondo;
    }

    public T getPrimo() {
        return primo;
    }

    public K getSecondo() {
        return secondo;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
