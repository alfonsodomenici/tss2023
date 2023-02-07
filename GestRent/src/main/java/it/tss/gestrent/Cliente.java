/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.gestrent;

/**
 *
 * @author ospite
 */
public class Cliente {
    private int cod_cliente;
    private String firstName;
    private String lastName;
    private String docType;
    private String numDoc;
    private String telephone="";
    private String mail="";

    public Cliente(int cod_cliente, String firstName, String lastName, String docType, String numDoc) {
        this.cod_cliente = cod_cliente;
        this.firstName = firstName;
        this.lastName = lastName;
        this.docType = docType;
        this.numDoc = numDoc;
    }
    
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocType() {
        return docType;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMail() {
        return mail;
    }
    
    
    
    
    
}
