/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author ospite
 */
public class App {

    public static void main(String[] args) {

        List<String> colori = new ArrayList<>();
        colori.add("bianco");
        colori.add("rosso");
        colori.add("verde");
        colori.add("blu");
        colori.add("bianco");

        //Stream<String> s1 = colori.stream();
        //Stream<String> s2 = Stream.of("blu","marrone","rosso");
        List<String> colori1 = Stream.of("viola", "marrone", "grigio")
                .collect(Collectors.toList());

        Consumer<String> mioConsumer = (v) -> {
            System.out.println(v.toUpperCase());
        };

        colori.stream()
                .forEach(v -> System.out.println(v));

        colori.stream()
                .forEach(mioConsumer);

        colori.stream()
                .forEach(App::repeatConsumer);

        System.out.println("------------- distinct sorted ------------");
        colori.stream()
                .distinct()
                .sorted()
                .forEach(mioConsumer);

        System.out.println("------------- filter sorted ------------");
        colori.stream()
                .filter(v -> colori1.contains(v))
                .sorted()
                .forEach(mioConsumer);

        Optional<Integer> max = colori.stream()
                .filter(v -> colori1.contains(v))
                .map(v -> v.length())
                .max((a, b) -> a > b ? 1 : a < b ? -1 : 0);
        System.out.println("max length: " + max);

        Map<Integer, List<String>> raggruppaPerNumeroCaratteri
                = colori.stream()
                        .distinct()
                        .collect(Collectors.groupingBy(v -> v.length()));

        System.out.println(raggruppaPerNumeroCaratteri);
        
        Double mediaCaratteri = colori.stream()
                .collect(Collectors.averagingInt(v -> v.length()));
        IntSummaryStatistics stat = colori.stream()
                .collect(Collectors.summarizingInt(v -> v.length()));
        System.out.println("media caratteri: " + mediaCaratteri);
        System.out.println("stats: " + stat);
    }

    private static void repeatConsumer(String s) {
        System.out.println(s.repeat(2));
    }
}
