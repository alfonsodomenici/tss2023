/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.ereditarieta;

/**
 *
 * @author ospite
 */
public class Studente extends Persona {

    private final String matricola, universita;

    /**
     *
     * @param matricola non vuoto
     * @param universita non vuoto
     * @param nome non vuoto
     * @param cognome non vuoto
     * @param cf non vuoto
     */
    public Studente(String nome, String cognome, String cf, String matricola, String universita) {
        super(nome, cognome, cf);
        if (CheckParamsHelper.isAnyNotValuedString(matricola, universita)) {
            throw new IllegalArgumentException("uno o più parametri vuoti");
        }
        this.matricola = matricola;
        this.universita = universita;
    }

    /*
    getters/setters
     */
    public String getMatricola() {
        return matricola;
    }

    public String getUniversita() {
        return universita;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") + ", matricola=" + matricola + ", universita=" + universita + '}';
    }

}
