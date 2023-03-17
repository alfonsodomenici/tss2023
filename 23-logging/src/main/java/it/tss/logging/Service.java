/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ospite
 */
public class Service {
    private Logger logger = Logger.getLogger(getClass().getName());
    
    
    public void doWork() throws InterruptedException{
        long start = System.nanoTime();
        logger.log(Level.INFO, "working....");
        Thread.sleep(1000);
        long duration = System.nanoTime() - start;
        logger.log(Level.INFO, "daration: " + duration );
    }
}
