/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.gestrent;

/**
 *
 * @author ospite
 */
public class Mezzo {
    private String type;
    private String targa;
    private float costo=0;
    private String modello;
    
    // costruttori

    public Mezzo(String type, String targa, String modello) {
        this.type = type;
        this.targa = targa;
        this.modello = modello;
    }

    // getter setter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTarga() {
        return targa;
    }

    /* per ora non attivato
    public void setTarga(String targa) {
        this.targa = targa;
    }*/

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }
    
    
    
}
