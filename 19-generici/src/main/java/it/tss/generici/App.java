/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.generici;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author ospite
 */
public class App {

    public static void main(String[] args) {
        ArrayList lista = new ArrayList();
        lista.add("mario");
        lista.add("maria");
        lista.add(10);

        String elemento = (String) lista.get(0);
        System.out.println(elemento.toUpperCase());

        List<String> nomi = new LinkedList<>();

        CoppiaMista<String, Integer> coppia
                = new CoppiaMista<>("maria", 10);

        System.out.println(coppia.getPrimo());

        nomi.add("mario");
        nomi.add("maria");
        nomi.add("gianni");
        nomi.add("monica");
        nomi.add("maria");

        System.out.println(nomi);

        Set<String> noDuplicati = new HashSet<>(nomi);

        System.out.println(noDuplicati);

        Map<String, List<Contatto>> rubrica = new HashMap<>();

        rubrica.put("mario", Stream.of(
                new Contatto(Contatto.Tipo.CASA, "12345678"),
                new Contatto(Contatto.Tipo.EMAIL, "xx@hotmail.com")
        ).collect(Collectors.toList()));
        
        System.out.println(rubrica.get("mario"));
        
        System.out.println("=" +somma(10,10));
        
        System.out.println("=" +somma(5.54,1010.34));
        
        Runnable r = () -> {
            System.out.println("runnable");
        };
        
        Predicate<String> p = (v) -> v.equals("ciao");
        
        Consumer<String> c = (v) -> System.out.println(v);
        
        c.accept("ciao");
        
        Consumer<String> c1 = System.out::println;
        
        c1.accept("ciao1");
        
        Consumer<String> c2 = App::mioConsumer;
        
        c2.accept("ciao2");
        
    }

    
    private static <T extends Number> double somma(T... numeri){
        double result = 0;
        
        for (T t : numeri) {
            result += t.doubleValue();
        }
        
        return result;
    }
    
    
    public static void mioConsumer(String s){
        System.out.println(s);
    }
}

class Contatto {

    public static enum Tipo{
        CASA,UFF,CELL,EMAIL,
    } 
    
    private Tipo tipo;
    private String valore;

    public Contatto(Tipo tipo, String valore) {
        this.tipo = tipo;
        this.valore = valore;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getValore() {
        return valore;
    }

    @Override
    public String toString() {
        return "Contatto{" + "tipo=" + tipo + ", valore=" + valore + '}';
    }

    
}
