/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.tss.interfacce.esempi_base;

/**
 *
 * @author ospite
 */
public interface Z {
    public double PI = 3.14; 
    
    public static void z4(){
        System.out.println("metodo z4");
    }
    public void z1();
    public int z2(int p1);
    public String z3(String msg);
    public default void z5(){
        
    };
}
