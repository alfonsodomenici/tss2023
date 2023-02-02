package it.tss.esercizi.array;

import java.util.Scanner;

/*
gestire lista vip
decidere la dimensione elenco invitati
creo un array grande come sopra di nomi (String)
chiamato "listaVip"
prendere nominativi e metterli in listaVip

almeno stamparli

ricerca tramite nome


 */
/**
 *
 * @author ospite
 */
public class EsempioListaVip {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //strumento per chiedere testi all'utente
        Scanner insTesto = new Scanner(System.in);
        Scanner insNumero = new Scanner(System.in);
        //dimensione lista
        System.out.println("######## LISTA VIP ########");
        System.out.println("Ins numero invitati in listaVip: ");
        int dimLista = insNumero.nextInt();
        //creolista array
        String[] listaVip = new String[dimLista];
        // caricamento vip
        //ciclo per caricare vips
        for (int i = 0; i < listaVip.length; i++) {
            System.out.println("\n######## LOAD LISTA VIP ########");
            System.out.println("Ins nome invitato: ");
            //chiedo nome vip
            String nome = insTesto.nextLine();
            //verifica inserimento o vuoto per uscire
            if (nome.equals("")) { //lasciato vuoto basta esco
                break;
            } else {
                //assegno all'i-esimo elemento della listail nome fornito
                listaVip[i] = nome;
            }
        }

        //fase stampa 
        System.out.println("\n######## STAMPA LISTA VIP ########");

        for (int i = 0; i < listaVip.length; i++) {
            System.out.println("# " + listaVip[i]);
        }

        // fase ricerca
        while (true) {
            System.out.println("\n######## CERCA  LISTA VIP ########");
            System.out.println("Ins 'nome' VIP, '' exit, 'lista' per lista : ");
            //chiedo nome vip
            String nome = insTesto.nextLine();
            //verifica inserimento o vuoto per uscire
            if (nome.equals("")) {
                break;
            }
            if (nome.equals("lista")) {
                //fase stampa e ricerca
                System.out.println("\n######## STAMPA LISTA VIP ########");
                for (int i = 0; i < listaVip.length; i++) {
                    System.out.println("# " + listaVip[i]);
                }
                continue; //direttamente al prossimo while
            }
            //scorro lista e cerco se c'e' 
            for (int i = 0; i < listaVip.length; i++) {
                if (nome.equals(listaVip[i])) { //caso trovato sono uguali
                    //confronto nome con elemento in lista
                    System.out.println("\n######## TROVATO VIP IN LISTA ########");
                    System.out.println("#OK ENTRA " + listaVip[i]);
                    listaVip[i] = listaVip[i] + " OK ENTRATO";
                    break;
                }
                if (i == listaVip.length - 1) //ultimo giro e non trovato e non break
                {
                    System.out.println("\n######## NON TROVATO VIP IN LISTA ########");
                    System.out.println("# KO!!! NON ENTRA " + nome);
                }

            }
        }
    }
}
