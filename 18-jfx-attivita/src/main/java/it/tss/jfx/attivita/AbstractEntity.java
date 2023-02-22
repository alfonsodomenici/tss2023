/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jfx.attivita;

import java.util.UUID;

/**
 *
 * @author alfonso
 */
public class AbstractEntity {
    private final String id;

    public AbstractEntity() {
        id = UUID.randomUUID().toString();
    }
    
    
    /*
    getters / setters
    */

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id=" + id + '}';
    }

   
    
}
