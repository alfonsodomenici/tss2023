/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.esercizi.classiscuola;

/**
 *
 * @author ospite
 */
public class Ticket {
    private String nome;
    private int costo;
    private String destinazione;

    public Ticket() {
    }
    
    public Ticket(String nome, int costo, String destinazione) {
        this.nome = nome;
        this.costo = costo;
        this.destinazione = destinazione;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }
    
}
