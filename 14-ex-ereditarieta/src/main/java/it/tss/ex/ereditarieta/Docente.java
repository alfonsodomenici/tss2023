/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.ereditarieta;

/**
 *
 * @author ospite
 */
public class Docente extends Persona {

    private final String materia;
    private final double salario;

    /**
     * 
     * @param materia non vuoto
     * @param salario maggiore si zero
     * @param nome non vuoto
     * @param cognome non vuoto
     * @param cf  non vuoto
     */
    public Docente( String nome, String cognome, String cf,String materia, double salario, Sesso sesso) {
        super(nome, cognome, cf,sesso);
        if(CheckParamsHelper.isNotValuedString(materia) ||
                CheckParamsHelper.isNotPositiveValued(salario)){
            throw new IllegalArgumentException("uno o più parametri non validi");
        }
        this.materia = materia;
        this.salario = salario;
    }

    /*
    getters/setters
     */

    public String getMateria() {
        return materia;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") + ", materia=" + materia + ", salario=" + salario + '}';
    }
    
    
}
