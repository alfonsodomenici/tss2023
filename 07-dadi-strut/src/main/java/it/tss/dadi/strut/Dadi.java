package it.tss.dadi.strut;

import java.util.Scanner;

public class Dadi {

    public static void main(String[] args) {

        int banco = 0;
        int giocatore = 0;
        int portafoglio = 10;
        boolean gioco = true;
        boolean error = false;
        String risposta = "";

        System.out.println("----------------Benvenuto al gioco dei dadi!----------------------------");
        if (portafoglio > 0) {
            gioco = true;
            while (gioco = true) {
                do {
                    try {
                        System.out.println("Se vuoi giocare scrivi <si> altrimenti scrivi <no>");
                        Scanner scanner = new Scanner(System.in);
                        risposta = scanner.nextLine();
                        if (risposta.equalsIgnoreCase("si") || risposta.equalsIgnoreCase("no") || risposta.equalsIgnoreCase("ciao")) {
                            error = false;
                        } else {
                            error = true;
                            System.out.println("Qualcosa è andato storto. Devi scrivere <si> o <no> per giocare.");
                        }
                    } catch (Exception e) {
                        error = true;
                        System.out.println("Qualcosa è andato storto. Devi scrivere <si> o <no> per giocare.");
                    }
                } while (error == true);

                if (risposta.equalsIgnoreCase("si")) {

                    banco = (int) (Math.random() * 7);
                    giocatore = (int) (Math.random() * 7);
                    System.out.println("Banco :" + banco);
                    System.out.println("Giocatore: " + giocatore);

                    if (banco > giocatore) {
                        portafoglio--;
                        System.out.println("Il banco ha vinto! Verrà sottratto 1€ dal tuo conto. Saldo rimanente = " + portafoglio + "€");

                    }
                    if (banco < giocatore) {
                        portafoglio++;
                        System.out.println("Hai vinto! Verrà aggiunto 1€ al tuo conto. Saldo rimanente = " + portafoglio + "€");
                    }

                    if (banco == giocatore) {
                        System.out.println("Pari!");
                    }

                }

                if (risposta.equalsIgnoreCase("no")) {
                    break;
                }
                if (risposta.equalsIgnoreCase("ciao")) {
                    portafoglio = 0;
                    gioco = false;
                }
                String giochiamo = "";
                Scanner scanner = new Scanner(System.in);
                do {
                    try {
                        System.out.println("Vuoi continuare a giocare?");
                        giochiamo = scanner.nextLine();
                        if (giochiamo.equalsIgnoreCase("si") || giochiamo.equalsIgnoreCase("no") || giochiamo.equalsIgnoreCase("ciao")) {
                            error = false;
                        } else {
                            error = true;
                            System.out.println("hmmm dovresti scrivere o <Si> o <No>");
                        }
                    } catch (Exception e) {
                        error = true;
                    }
                } while (error == true);

                if (giochiamo.equalsIgnoreCase("si")) {
                    gioco = true;
                }
                if (giochiamo.equalsIgnoreCase("no")) {
                    gioco = false;
                    break;
                }
                if (giochiamo.equalsIgnoreCase("ciao")) {
                    portafoglio = 0;
                    gioco = true;
                }

            }
        } else {
            System.out.println("Non hai abbastanza soldi per giocare!");
            gioco = false;

        }
    }
}


