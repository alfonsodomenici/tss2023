/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.tss.esercizi.classi.base;

/**
 *
 * @author ospite
 */
public class GestMagazzino {
    // creo struttra magazzino
    //elenco prodotti
    static Prodotto[] magazzino;
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int maxProd=10;
        magazzino = new Prodotto[maxProd];
        Prodotto prod1 = new Prodotto();
        prod1.nome="glassex";
        prod1.categoria="detersivo";
        prod1.prezzo=2;
        Prodotto prod2 = new Prodotto();
        prod2.nome="glassex";
        prod2.categoria="detersivo";
        prod2.prezzo=2;
        if(prod1 == prod2){
            System.out.println("prodotti uguali");
        }else{
            System.out.println("prodotti diversi");
        }
        int x =10;
        int y = 10;
        if(x == y){
            System.out.println("numeri uguali");
        }else{
            System.out.println("numeri diversi");
        }
        
//        magazzino[0]=prod1;
//        magazzino[1]=prod2;
//        
//        magazzino[0].info();
//        System.out.println(magazzino[1].nome);
        
        
    }
    
}
