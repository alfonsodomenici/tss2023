/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ereditarieta;

/**
 *
 * @author ospite
 */
public class B extends A {

    public B() {
        System.out.println("costruttore di B");
    }

    public void m2() {
        System.out.println("sono il metodo m2 del tipo B");
    }

    @Override
    public void m1() {
        super.m1();
        System.out.println("sono il metodo m1 del tipo A riscritto in B");
    }

}
