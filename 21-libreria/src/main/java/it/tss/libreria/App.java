/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.libreria;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ospite
 */
public class App {

    public static void main(String[] args) {

        Autore autore = new Autore("emilio", "salgari");

        autore = Store.save(autore);

        Libro libro = new Libro("Sandokan", LocalDate.now(), autore);

        libro = Store.save(libro);

        Stream.of("ROMANZI", "GIALLI", "ANTOLOGIA", "STORIA", "INFORMATICA")
                .map(Categoria::new)
                .forEach(Store::save);

        libro.setCategorie(Store.allCategorie()
                .stream()
                .limit(2)
                .collect(Collectors.toSet()));
        Store.save(libro);
        
        Store.libriByAutore("salgari")
                .forEach(System.out::println);

        
    }
}
