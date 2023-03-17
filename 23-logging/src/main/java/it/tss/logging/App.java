/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.logging;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 * 
 * 
 * 
 * 
 * @author ospite
 */
public class App {

    private static Logger logger = Logger.getLogger(App.class.getName());
     
    public static void main(String[] args) throws InterruptedException, IOException {
       
        Logger.getLogger("it.tss.logging").setLevel(Level.ALL);
        
        Logger.getLogger("it.tss.logging")
                .addHandler(new FileHandler("%tfiles.log"));
        
        logger.log(Level.INFO,"Start program....");
        
        Service service = new Service();
        
        service.doWork();
        
        logger.log(Level.INFO, "end program");
    }
}
