/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.tss.esercizi.classi.base;

/**
 *
 * @author ospite
 */
public class GestMatematica {
    
 Punto[] elencoPunti;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Punto[] park = new Punto[10];
        Punto p1 = new Punto();
        p1.info();
        String coord =p1.printPunto();
        System.out.println("coordinate: " + coord);
        p1.move(200,200);
        p1.move(p1.getX()-20, p1.getY());
            
        Punto p2 = new Punto(100,100);
        p2.info();
        
        float dist=p2.distanzaDaPunto(p1);
        System.out.println("dist punti " + dist);
        
    }
    
}
