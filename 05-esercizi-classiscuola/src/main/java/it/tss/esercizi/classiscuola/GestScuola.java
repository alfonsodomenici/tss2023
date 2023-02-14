/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.tss.esercizi.classiscuola;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author ospite
 */
public  class GestScuola {

    static Corso[] elencoCorsi;
    //static final int maxCorsi = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Creo elenco da max 10 corsi
        
        caricaCorsi();
        Corso c1 = new Corso("java tss", 120, 100);
        c1.setDescrizione("corso java");
        Corso c2 = new Corso("database tss", 90, 100);
        c2.setDescrizione("db mysql mssql");
        Corso c3 = new Corso("web tss", 150, 200);
        c3.setDescrizione("html js css");
        insNewCorso(c1);
        insNewCorso(c2);
        insNewCorso(c3);
        info();
        salvaCorsi();
        /*
        Materia matnew= new Materia("java",60);
        c1.addMateriaFullOre(matnew);
        matnew= new Materia("db",40);
        c1.addMateriaFullOre(matnew);
        matnew= new Materia("web",40);
        c1.addMateriaFullOre(matnew);
        matnew= new Materia("3d",40);
        c1.addMateriaFullOre(matnew);
        //iscrivo 3 alunni 
        c1.iscriviAlunno();
        c1.iscriviAlunno();
        c1.iscriviAlunno();
        //faccio due esami per questo corso c1
        Voto newesame= c1.createNewVoto();
        c1.registraEsame(newesame);
        newesame= c1.createNewVoto();
        c1.registraEsame(newesame);
        
        //aggiungiamo il nuovo corso c1 alla scuola
        insNewCorso(c1);
        //creo altro corso
        c1 = new Corso("cucina", 60, 10);
        insNewCorso(c1);
        //una sola materia
        matnew = new Materia("fritto", 60);
        c1.addMateriaFullOre(matnew);
        //due alunni
        c1.iscriviAlunno();
        c1.iscriviAlunno();
        //ins due voti
        newesame= c1.createNewVoto();
        c1.registraEsame(newesame);
        newesame= c1.createNewVoto();
        c1.registraEsame(newesame);
        //aggiungo il corso alla scuola
        
        info();
        
         */
    }

    private static void insNewCorso(Corso c1) {
        for (int i = 0; i < elencoCorsi.length; i++) {
            if (elencoCorsi[i] == null) {
                elencoCorsi[i] = c1;
                break;
            }

        }

    }

    static public void info() {
        for (Corso corso : elencoCorsi) {
            if (corso == null) {
                break;
            }
            corso.info();
        }
    }

    private static void salvaCorsi() {
        /* 
        un file di testo che si chiama "Corsi.txt"
        java;120,100
        database;90;100
        web;150;200
         */
        String testoXfile = "";
        for (Corso c : elencoCorsi) {
            if (c == null) {
                break; // scatola vuota esco da for
            }
            String riga = c.getNomeCorso() + ";" + c.getDurataOre() + ";";
            riga += c.getCosto() + ";" + c.getDescrizione();
            riga += "\n";
            // riga ok  "java;120;100;corso java\n"
            testoXfile += riga;
        }
        //fase salvataggio file CSV
        try {
            FileWriter filecsv = new FileWriter("Corsi.csv");
            filecsv.write(testoXfile);
            filecsv.close();
        } catch (Exception e) {
            System.out.println("ERRORE: " + e.getLocalizedMessage());
        }

    }

    public static void caricaCorsi() {
        /*dovrei aprire il file Corsi.csv
        leggere una riga per volta 
        caricare i dati in un corso e aggiungerlo alla lista corsi
        alla fine liberare il file
         */
        // puntatore al file corretto
        try {
            //azzero il mio elenco corsi ricostruendolo
            elencoCorsi = new Corso[10];
            File filecsv = new File("Corsi.csv");
            // creo lettore che puntera' cursore inizio file
            Scanner lettore = new Scanner(filecsv);
            while (lettore.hasNextLine()){
                //in riga la riga di dati fino al \n
                String riga=lettore.nextLine();
                // creo array dei singoli dati separsati dal ;
                String[] dati = riga.split(";");
                // dati[0] contiene nomecorso dati[1] durata ...
                String ncorso = dati[0];
                String descr = dati[3];
                // converto dati[1] da string a int
                int durata = Integer.parseInt(dati[1]);
                float costo= Float.parseFloat(dati[2]);
                // ho tutt i dati per costruire un corso
                Corso newcorso= new Corso(ncorso,durata,costo);
                newcorso.setDescrizione(descr);
                // lo inserisco in elenco
                insNewCorso(newcorso);
                
            }
            
            
        } catch (Exception e) {
            System.out.println("Erroe: " + e.getMessage());
        }

    }

}
