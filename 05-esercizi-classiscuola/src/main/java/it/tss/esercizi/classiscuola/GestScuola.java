/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.tss.esercizi.classiscuola;

/**
 *
 * @author ospite
 */
public class GestScuola {

    static Corso[] elencoCorsi;
    //static final int maxCorsi = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Creo elenco da max 10 corsi
        elencoCorsi = new Corso[10];

        Corso c1 = new Corso("java", 120, 10);
        
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
        
        
    }

    private static void insNewCorso(Corso c1) {
         for (int i=0 ;i<elencoCorsi.length;i++){
            if (elencoCorsi[i]== null){
                elencoCorsi[i]=c1;
                break;
            }
            
        }
    
    }
    static public void info(){
        for (Corso corso:elencoCorsi){
            if (corso==null) break;
            corso.info();
        }
    }

}
