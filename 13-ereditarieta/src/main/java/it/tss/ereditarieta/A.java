/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ereditarieta;

import java.util.Objects;

/**
 *
 * @author ospite
 */
public class A extends Object {

    private String p1;

    public A(String p) {
        this.p1 = p;
        System.out.println("costruttore di A");
    }

    public void m1() {
        System.out.println("sono il metodo m1 del tipo A");
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.p1);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final A other = (A) obj;
        return Objects.equals(this.p1, other.p1);
    }

    @Override
    public String toString() {
        return "A{" + "p1=" + p1 + '}';
    }

}
