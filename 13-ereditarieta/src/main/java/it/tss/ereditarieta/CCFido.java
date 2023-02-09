/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ereditarieta;

/**
 *
 * @author ospite
 */
public class CCFido extends CCBase {

    private int fido;

    public CCFido(int fido, String intestatario) {
        super(intestatario);
        this.fido = fido;
    }

    @Override
    public void prelievo(double importo) {
        if (this.saldo + fido < importo) {
            throw new IllegalArgumentException("saldo + fido non sufficiente");
        }
        this.saldo -= importo;
    }

    public int getFido() {
        return fido;
    }

    @Override
    public String toString() {
        return super.toString() + " fido=" + fido;
    }

}
