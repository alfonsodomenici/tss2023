/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.esercizi.classiscuola;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author ospite
 */
public class Alunno {

    private String nome;
    private String cognome;
    private String email;
    private int annoNascita;
    Voto[] elencoVoti = new Voto[30];

    public Alunno(String nome, String cognome, String email, int annoNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.annoNascita = annoNascita;
    }

    public Alunno(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAnnoNascita() {
        return annoNascita;
    }

    public void setAnnoNascita(int annoNascita) {
        this.annoNascita = annoNascita;
    }

    public void info() {
        
        System.out.println("\n---Scheda Alunno---");
        System.out.println("Sono " + nome + " " + cognome);
        System.out.println("anno " + annoNascita + " " + email);
        System.out.println("I miei voti:\n");
        for (Voto v:elencoVoti){
            if (v==null) break;
                v.info();
        }
        
        
        /*String voti="";
        for (Voto v:elencoVoti){
            if (v==null) break;
            voti += v.getMateria() + " " + v.getVoto() + "\n";
        }
        System.out.println(" i miei voti:\n" + voti);
        */
        
        
    }

    public void insVoto(Voto esame) {
        for (int i = 0; i < elencoVoti.length; i++) {
            if (elencoVoti[i] == null) {
                elencoVoti[i] = esame;
                break;
            }

        }
        

    }

}
