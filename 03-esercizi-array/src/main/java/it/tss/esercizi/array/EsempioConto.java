
package it.tss.esercizi.array;

import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class EsempioConto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inputMov = new Scanner(System.in);
        System.out.println("Quanto movimenti per il tuo conto?");
        int maxMov =inputMov.nextInt();
        int[] conto = new int[maxMov];
        //gestire caricamento scontrini
        for (int i=0; i<conto.length;i++){
            System.out.println("inserisci movimento [es -200 per prelievo]");
            int importo = inputMov.nextInt();
            if (importo==0) break;
            conto[i]=importo;
        }
        //finito caricamento
        
        //inizio stampamovimennti e calcolo saldo
        int saldo=0;
        
        for (int i=0;i<conto.length;i++){
            if (conto[i]==0) break;
            System.out.println("#" + (i+1) + " :  " + conto[i]);
            saldo = saldo+conto[i];
        }
        System.out.println("il tuo saldo e': " + saldo);
        
    }
    
}
