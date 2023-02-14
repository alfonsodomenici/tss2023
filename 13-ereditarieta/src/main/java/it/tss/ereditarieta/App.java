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

        A a = new A("xx");

        A a1 = new A("xx");

        ArrayList<A> lista = new ArrayList<>();
        lista.add(a);
        
        System.out.println(lista.contains(a1));
        
    }
}
