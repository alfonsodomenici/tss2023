/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cinema;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author ospite
 */
public class LoggerProducer {
    
    @Produces
    public System.Logger getLogger(InjectionPoint ip){
        return System.getLogger(ip.getClass().getCanonicalName());
    }
}
