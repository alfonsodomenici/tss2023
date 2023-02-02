package it.tss.esempiometodi;

import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class EsercizioMetodi {

    static String nome, cognome;
    static int qta;
    static float spesa;
    static String[] listaSpesa;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        nome = chiediTesto("ins nome: ");
        cognome = chiediTesto("Ins. il Cognome: ");
        stampaPersona();
        int importo = chiediInt("ins importo bmat: ", 1, 1000);
        qta = chiediInt("ins quantita': ");
        spesa = chiediFloat("ins spesa: ");
        int atesta = cadauno(1234, 6);
        int totale = somma(2, 4, 3);
    }

    static void stampaPersona() {

        System.out.println("");
        System.out.println("---- Stampa Persona ----");
        System.out.println("NOME: " + nome);
        System.out.println("COGNOME: " + cognome);
        System.out.println("---- Fine Stampa ----");

    }

    static int somma(int num1, int num2, int num3) {
        int ris = 0;
        ris = num1 + num2 + num3;
        return ris;
    }

    static int cadauno(int tot, int quanti) {
        int ris = 0;
        //faccio il calcolo a testa...
        //totalediviso quanti sonop
        ris = tot / quanti;
        return ris;
    }

    static String chiediTesto(String testo_domanda) {
        String ris = "";
        System.out.println(testo_domanda);
        Scanner sc = new Scanner(System.in);
        ris = sc.nextLine();
        return ris;
    }

    private static int chiediInt(String testo_domanda) {
        int ris = 0;
        while (true) {
            try {
                System.out.println(testo_domanda);
                Scanner sc = new Scanner(System.in);
                ris = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("not a number!!!");
            }
        }
        return ris;
    }

    private static int chiediInt(String testo_domanda, int min, int max) {
        int ris = 0;
        while (true) {
            try {
                System.out.println(testo_domanda);
                Scanner sc = new Scanner(System.in);
                ris = sc.nextInt();
                if (ris >= min && ris <= max) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("not a number!!!");
            }
        }
        return ris;
    }

    private static float chiediFloat(String testo_domanda) {
        float ris = 0;
        while (true) {
            try {
                System.out.println(testo_domanda);
                Scanner sc = new Scanner(System.in);
                ris = sc.nextFloat();
                break;
            } catch (Exception e) {
                System.out.println("not a number!!!");

            }
        }
        return ris;
    }

}
