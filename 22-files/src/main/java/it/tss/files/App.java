/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.files;

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
 * @author ospite
 */
public class App {

    public static void main(String[] args) {
        try {
            //File nel filesystem della macchina
            Path path = Paths.get("/home/ospite/prova.txt");
            //File in resources del progetto
            URL url = App.class.getResource("/prova.txt");
            if (url == null) {
                System.out.println("Il programma non può leggere il file..");
                System.exit(1);
            }

            Path path1 = Paths.get(url.toURI());

            List<String> lines = Files.readAllLines(path1);
            for (String line : lines) {
                String[] campi = line.split(",");
                System.out.println(Arrays.asList(campi));
            }

        } catch (IOException | URISyntaxException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
