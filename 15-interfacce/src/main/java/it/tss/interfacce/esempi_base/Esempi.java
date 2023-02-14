/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.interfacce.esempi_base;

import it.tss.interfacce.esempi_base.Z;
import it.tss.interfacce.esempi_base.A;
import it.tss.interfacce.esempi_base.C;
import it.tss.interfacce.esempi_base.B;

/**
 *
 * @author ospite
 */
public class Esempi {
    public static void main(String[] args) {
        C c = new C(); //m1,m2,z1,z2,z3,z5
        B b = new C(); //m1,m2
        A a = new C(); //m1,m2
        Z z = new C(); //z1,z2,z3,z5
        //Z z1 = new B(); no perchè B non implementa Z
        Z.z4(); //metodo default statico
    }
}
