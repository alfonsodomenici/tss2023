/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.prova;

import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ospite
 */
@RequestScoped
public class MessageService {
    
    public String getHelloMessageByHour(int hour){
        return "ciao";
    }
}
