/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ereditarieta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JFrame;

/**
 *
 * @author ospite
 */
public class App {

    public static void main(String[] args) throws IOException {

try{
        Scanner s = new Scanner(System.in);
        
        System.out.println("Dimmi il nome dell'intestatario?");
        String intestatario = s.nextLine();
        
        CCFido cc1 = new CCFido(100,intestatario);
        
        cc1.versamento(50);
        
        cc1.prelievo(100);
            
        System.out.println(cc1);
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            System.out.println("Scusa il programma verrà terminato");
        }

    }
}
