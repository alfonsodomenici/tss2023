package it.tss.esercizi.classiscuola;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ospite
 */
public class Corso {

    private String nomeCorso;
    private String fasciaOraria="";
    private int durataOre;
    private float costo;
    private String descrizione="";
    Alunno[] elencoAlunni = new Alunno[30];
    private ArrayList<Materia> elencoMaterieCorso = new ArrayList<Materia>();

    //int id_corso;
    public Corso() {
        //  id_corso=GestScuola.elencoCorsi.length;
    }

    public Corso(String nomeCorso, int durataOre, float costo) {
        this.nomeCorso = nomeCorso;
        this.durataOre = durataOre;
        this.costo = costo;
    }
 public Corso(String nomeCorso, int durataOre,
         float costo, String descrizione, String fasciaOraria) {
        this.nomeCorso = nomeCorso;
        this.durataOre = durataOre;
        this.costo = costo;
        this.descrizione=descrizione;
        this.fasciaOraria=fasciaOraria;    
    }

    public ArrayList<Materia> getElencoMaterieCorso() {
        return elencoMaterieCorso;
    }

    public void setElencoMaterieCorso(ArrayList<Materia> elencoMaterieCorso) {
        this.elencoMaterieCorso = elencoMaterieCorso;
    }
    
    public String getFasciaOraria() {
        return fasciaOraria;
    }

    public void setFasciaOraria(String fasciaOraria) {
        this.fasciaOraria = fasciaOraria;
    }
    
    public String getNomeCorso() {
        return nomeCorso;
    }

    public void setNomeCorso(String nomeCorso) {
        this.nomeCorso = nomeCorso;
    }

    public int getDurataOre() {
        return durataOre;
    }

    public void setDurataOre(int durataOre) {
        this.durataOre = durataOre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getDescrizione() {
        if (descrizione == null) {
            return "";
        } else {
            return descrizione;
        }
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    //inizio metodi specifici classe corso
    public void iscriviAlunno() {
        System.out.println("--ISCRIZIONE ALUNNO--");
        System.out.println("Corso: " + nomeCorso);
        //input da esterno
        Scanner scT = new Scanner(System.in);
        //chiedo dati alunno
        System.out.println("Dimmi nome: ");
        String nome = scT.nextLine();
        System.out.println("Dimmi cognome: ");
        String cognome = scT.nextLine();
        //creo alunno coni dati
        Alunno alunno = new Alunno(nome, cognome);
        //Alunno alunno = new Alunno(nome, cognome, "qwe@qwe.it", 1980);
        //inserisco alunno in primaposizione non vuota (null) 
        //e esco subito (break)
        //scorro tramite itutti gli elementi di elencoalunni.length
        for (int i = 0; i < elencoAlunni.length; i++) {
            if (elencoAlunni[i] == null) {
                //se l'iesimo elemento dell'elenco e' vuoto
                //assegno all'iesimo elemento l'alunno nuovo di zecca...
                elencoAlunni[i] = alunno;
                //ed esco se no lo inserirei anche per tutte 
                //le altre voci del registro
                break;
            }

        }

    }

    /**
     *
     * @param mat materia da aggiungere
     */
    public void addMateriaNoOreDef(Materia mat) {
        // mi assicuro che la materia venga caricata con 0 ore
        mat.setDurataOre(0);
        elencoMaterieCorso.add(mat);
    }

    public boolean addMateriaFullOre(Materia mat) {
        boolean ok = true;
        //200 ore la materia e 120 max corso
        //se troppo non aggiungo altrimenti aggiungo
        if (durataOre >= mat.getDurataOre()) {
            if (mat.getDurataOre() < getNumOreLeft()) {
                elencoMaterieCorso.add(mat);
                ok = true;
            } else {
                // se rimasto piu' di 0 ok la inserisco con il rimanente
                if (getNumOreLeft() > 0) {
                    // allamateria gli ho dato tutto il rimante
                    mat.setDurataOre(getNumOreLeft());
                    //finalmente la aggiungo
                    elencoMaterieCorso.add(mat);
                } else { // se neanche questa e' andata bene KO
                    ok = false;
                }
            }

        } else { //non faccio niente
            ok = false;
        }

        return ok;
    }

    public Voto createNewVoto() {
        System.out.println("--crea voto--");
        System.out.println("Corso: " + nomeCorso);
        System.out.println("--elenco materie--");

        for (Materia m : elencoMaterieCorso) {
            m.info();
        }

        Voto newvoto = null;
        // il voto da 0 a 100...
        int votazione = 0;
        // il nome dell'esame da verificare tra le materie del corso
        String nomeEsame = "";
        //la data dell'esame
        LocalDate data = LocalDate.now();

        System.out.println("Ins nome esame come lista sopra: ");
        Scanner scE = new Scanner(System.in);
        nomeEsame = scE.nextLine();
        System.out.println("Ins voto [0..100]: ");
        Scanner scN = new Scanner(System.in);
        try {
            votazione = scN.nextInt();
        } catch (Exception e) {
            votazione = 0;
        }

//controllo nomesame in lista materie corso
        //scorro lematerie con for
        for (Materia materiaCurr : elencoMaterieCorso) {
            // tiro fuori un mat alla volta
            if (nomeEsame.equals(materiaCurr.getNomeMateria())) {
                //posso costruire un voto con i dati corretti
                newvoto = new Voto(votazione, nomeEsame, data);
            }
        }

        return newvoto;

    }

    /**
     * metodo per avere rispetto alladurata del corso le ore rimaste da caricare
     * come ore di materie
     *
     * * @return numero di ore scoperte del corso
     */
    private int getNumOreLeft() {
        int num = 0;
        // ciclo tutte le materie e faccio la somma 
        // della loro durata in ore
        for (int i = 0; i < elencoMaterieCorso.size(); i++) {
            //prendo una materia per volta
            Materia mat = elencoMaterieCorso.get(i);
            num = num + mat.getDurataOre();
        }
        //altra versione piu' bella...

        num = 0;
        for (Materia mat : elencoMaterieCorso) {
            num = num + mat.getDurataOre();
        }

        return durataOre - num;
    }

    public void registraEsame(Voto esame) {
        System.out.println("--Registra ESAME ALUNNO--");
        System.out.println("Corso: " + nomeCorso);

        // chiedo nome  cognome alunno
        Scanner scT = new Scanner(System.in);
        System.out.println("ins nome esaminando: ");
        String nome = scT.nextLine();
        System.out.println("ins cognome esaminando: ");
        String cognome = scT.nextLine();

        // cerco alunno con ciclo for... se poi dovro' lavorare
        // con elemento trovato consiglio for int i=0
        for (int i = 0; i < elencoAlunni.length; i++) {
            // se trovo alunno mi segno la posizione iesima
            if (elencoAlunni[i] == null) {
                break;
            }
            Alunno al = elencoAlunni[i];

            if (nome.equals(al.getNome()) && cognome.equals(al.getCognome())) {
                //trovato 
                elencoAlunni[i].insVoto(esame);
                break;
            }

        }

    }
    
    //14:57
    
    public String infoCSV(){
        String ris="";
        ris=nomeCorso + ";" + durataOre +";";
        ris+= costo + ";" + descrizione +";" + fasciaOraria;
        String elMat=""; // "db mysql,java base,inglese"
        for (Materia m :elencoMaterieCorso){
            elMat+=m.getNomeMateria() + "|";
        }
        // elmat="db mysql,java base,inglese,"
        ris+=";" +elMat;
        return ris;
    }
    
    public void info() {
        System.out.println("corso: " + nomeCorso);
        System.out.println("durata: " + durataOre);
        System.out.println("descrizione: " + descrizione);
        // elenco materie
        for (Materia m : elencoMaterieCorso) {
            m.info();
        }
        for (Alunno al : elencoAlunni) {
            if (al == null) {
                break;
            }
            al.info();
        }
        //elenco alunni

    }

}
