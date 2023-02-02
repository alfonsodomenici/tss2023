/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.esercizi.classiscuola;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author ospite
 */
public class Voto {
    private int voto;
    private String materia;
    private LocalDate data;

    public Voto(int voto, String materia, LocalDate data) {
        this.voto = voto;
        this.materia = materia;
        this.data = LocalDate.now();
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
public void info(){
    System.out.println("esame: " + materia + "- voto: " + voto  + " il " +data.toString() );
}
    
    
}
