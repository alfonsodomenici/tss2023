/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.esercizi.classiscuola;

/**
 *
 * @author ospite
 */
public class Materia {

    private String nomeMateria;
    private int durataOre = 0;
    private String docente = "";

    public Materia(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public Materia(String nomeMateria, int durata) {
        this.nomeMateria = nomeMateria;
        // durata sempre compresa tra 0 e 1000
        durataOre = durata;
        if (durataOre < 0) {
            durataOre = 0;
        }
        if (durataOre > 1000) {
            durataOre = 1000;
        }

    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public int getDurataOre() {
        return durataOre;
    }

    public void setDurataOre(int durata) {
        durataOre=durata;
        if (durata < 0) {
            durataOre = 0;
        }
        if (durata > 1000) {
            durataOre = 1000;
        }
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public void info() {
        System.out.println("materia: " + nomeMateria + " - durata: " + durataOre);
    }
}
