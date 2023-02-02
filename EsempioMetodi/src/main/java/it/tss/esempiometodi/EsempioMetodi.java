
package it.tss.esempiometodi;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class EsempioMetodi {
    
    static float x,y,z;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        initPark();
        printNumParks();
        printDati();
        aumentaPiani();
        printNumParks();
        printDati();
        
        // iniziare a usare ilparcheggio
        
        
        
        incrDati();
        incrDatiByValue(10);
        printDati();
        //z=somma2Valori(x, y);
        resetDati();
        printDati();
    }
    
    public static void initPark(){
        Scanner askNum= new Scanner(System.in);
        System.out.println("Ins numero park lato1: ");
        int lato1=askNum.nextInt();
        System.out.println("Ins numero park lato2: ");
        int lato2=askNum.nextInt();
        System.out.println("Ins numero piani: ");
        int npiani=askNum.nextInt();
        x=lato1;
        y=lato2;
        z=npiani;
        
    }
    
    public static void incrDati(){
        x=x+1;
        y++;
        z++;
    }
    public static void aumentaPiani(){
        z++;
    }
    public static void incrDatiByValue(float value){
        x=x+value;
        y+=value;
        z+=value;
    }
    public static float somma2Valori(float num1, float num2){
        //dichiaro la variabile con il lavoro fatto
        // che dovro fornire alla fine
        float result=0;
        result= num1+num2;
        // mando indietro il lavoro fatto ovvero la variabile
        //definita all'inizio
        return result;
    }
    
    public static float getNumParks(){
        float ris=0;
        ris=x*y*z;
        return ris;
    }
    
    public static float getNumParks(float lato1,float lato2, float numPiani){
        float ris=0;
        ris=lato1* lato2* numPiani;
        return ris;
    }
    
    
    public static void printDati(){
        System.out.println("");
        System.out.println("-- Stampa AreaParking --");
        System.out.println("Lato1:\t" + x);
        System.out.println("Lato2:\t" + y);
        System.out.println("Num Piani:\t" + z);
        System.out.println("-- fine Stampa --");
        System.out.println("");
        
    }
    
    public static void resetDati() {
        x=0;
        y=0;
        z=0;
    }
    
    public static void printNumParks(){
        int numPosti=(int)getNumParks();
        System.out.println();
        Date dataoggi= new Date();
        System.out.println(dataoggi.toString());
        System.out.println("Numero max posti parking = " + numPosti);
        System.out.println();
       /*
        numPosti=(int)getNumParks(x, y, z);
        System.out.println("nummax posti parking= " + numPosti);
       */
        
        
        
    }
    
}
