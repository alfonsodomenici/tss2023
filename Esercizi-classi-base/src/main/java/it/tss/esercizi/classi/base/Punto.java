/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.esercizi.classi.base;

/**
 *
 * @author ospite
 */
public class Punto {

    //elenco attributi inizializzati e non
    private int x = 0;
    private int y = 0;
    String note;

    // elenco di capacita' dette metodi
    //costruttore senza parametri
    public Punto() {

    }

    //costruttore con parametri
    public Punto(int x, int y) {
        if (x >= 0 && x <= 1000) {
            this.x = x;
        }
        if (y >= 0 && y <= 1000) {
            this.y = y;
        }

    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    //incrX e incrY
    //setX o setY
    public void incrX() {
        if (x <= 1000) {
            this.x++;
        }
    }

    public void incrY() {
        if (y <= 1000) {
            y++;
        }
    }

    public void setX(int x) {
        if (x >= 0 && x <= 1000) {
            this.x = x;
        }
    }

    public void setY(int y) {
        if (y >= 0 && y <= 1000) {
            this.y = y;
        }
    }

    public float distOrigine() {
        //crearevar per risultato
        float ris = 0;
        float somma = x * x + y * y;
        //fare somma di quadrati dei lati x e y
        // somma= x*x + y *y
        // farne la radice quadrata radice di somma
        ris = (float) Math.sqrt(somma);
        // con Math.sqrt(somma)
        //ritornare il risultato
        return ris;
        // esempio di utilizzo nel main
        //float dist= p1.distanzaOrigine();
    }

    public float distanzaDaPunto(Punto p2) {
        float ris = 0;
        float x1 = x;
        float y1 = y;
        float x2 = p2.x;
        float y2 = p2.y;
        float somma = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        ris = (float) Math.sqrt(somma);
        return ris;
    }

    public void info() {
        System.out.println("Questo punto e' in x: "
                + x + " e y: " + y
                + " e dista " + distOrigine() + " da 0,0");
    }

    /**
     * ritorna il punto in formato testo (x,y)
     *
     * @return String (12,23)
     */
    public String printPunto() {
        String ris = "";
        ris = "(" + x + "," + y + ")";

        return ris;
    }

    // p1.move(12,23)
    public void move(int x, int y) {
        //il parametro x del metodo lo assegno alla x 
        //di questo oggetto (this)
        if (x >= 0 && x <= 1000 && y>=0 && y<=1000) {
            this.x = x;
            this.y = y;
        }
    }

}
