/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.programmazione.strutturata;

/**
 *
 * @author ospite
 */
public class C3 {
    
    private final String x;
    private final String y;

    public C3(String x, String y) {
        checkContraints(x);
        checkContraints(y);
        this.x = x;
        this.y = y;
    }

    
    public String getX() {
        return x + "!*";
    }

    public String getY() {
        return y;
    }
    
    private void checkContraints(String p1){
        if(p1 == null || p1.length()<5){
            throw new IllegalArgumentException("Dalla versione x non sono più ammesse stringhe conlunghezza < di 5");
        }
    }
}
