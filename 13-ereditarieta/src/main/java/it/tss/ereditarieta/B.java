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

    private String p2;

    public B(String p, String p2) {
        super(p);
        this.p2 = p2;
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

    @Override
    public String toString() {
        return "B{" + "p1=" + this.getP1() + "p2=" + p2 + '}';
    }

    
}
