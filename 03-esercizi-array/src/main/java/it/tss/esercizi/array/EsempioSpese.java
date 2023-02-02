package it.tss.esercizi.array;

import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class EsempioSpese {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // array per i nome e un array per le spese
        // prima cosa chiedo il numero dei partecipanti

        //scanner per chiedere un intero sensato con trappola di errori
        boolean errore = false;
        int numpax = 0;
        do {
            try {
                Scanner scNum = new Scanner(System.in);
                System.out.println("ins numero partecipanti:[valori possibili tra 1 e 150]");
                numpax = scNum.nextInt();
                // valutare se numero sensato
                if (numpax > 0 && numpax <= 150) {
                    errore = false;

                } else {
                    errore = true;
                    System.out.println("ATTENZIONE!!! numero non compreso tra 1 e 150!!!");
                }

            } catch (Exception e) {
                errore = true;
                System.out.println("ATTENZIONE!!! ins un numero!!!");

            }
        } while (errore == true);

        // creato array per i dati
        String[] listaNomi = new String[numpax];
        float[] listaSpese = new float[numpax];

        //fase di caricamentodati array
        //ciclo perchiedere i dati a tutti
        for (int i = 0; i < listaNomi.length; i++) {
            //chiedo nome
            Scanner scNome = new Scanner(System.in);
            System.out.println("Come ti chiami?");
            String nome = scNome.nextLine();
            //se lasciv uoto come nome gli metto io una voce tipo "nome4"
            // a seconda dell'i-esimo giro che stavo facendo
            if (nome.equals("")){
                nome="nome" + (i+1);
            }
            listaNomi[i] = nome;
            boolean aposto = false;
            while (!aposto) {
                //chiedo spesa
                try {
                    Scanner scSpesa = new Scanner(System.in);
                    System.out.println("quanto hai speso [es 12,55]? ");
                    float spesa = scSpesa.nextFloat();
                    if (spesa >= 0 && spesa <= 2000) {
                        aposto = true;
                        listaSpese[i] = spesa;
                    }
                } catch (Exception e) {
                    aposto = false;
                    System.out.println("hai scritto un numero sbagliato!!!");
                }
            }

        }
        // fine ciclo for per carica le numpax spese nomi e valori 

        //ciclo for per stampare le singole spese
        for (int i = 0; i < listaNomi.length; i++) {
            String riga =listaNomi[i] + " : " + listaSpese[i];
            System.out.println(riga);
        }
        
        // calcolare spesatot e spesasingola
        float spesaTot=0;
        float spesaSingolo=0;
        //scorro le singole spese e le aggiungo al mio totale
        for (int i = 0; i < listaSpese.length; i++) {
            spesaTot =spesaTot+listaSpese[i];
        }
        spesaSingolo=spesaTot/listaSpese.length;
        System.out.println("-----SPESE-----");
        System.out.println("SpesaTotale= " + spesaTot);
        System.out.println("Spesa cadauno= " + spesaSingolo);
        
        //ciclo for per stampare le singole spese e debito/credito
           
        for (int i = 0; i < listaNomi.length; i++) {
            String riga = listaNomi[i] + " : spesi " + listaSpese[i] + " : debito "
                    + (spesaSingolo- listaSpese[i]) 
                    + " : %debito " + Math.round((listaSpese[i]/spesaSingolo)*100) + "%";
            System.out.println(riga);
        }
    }
}
