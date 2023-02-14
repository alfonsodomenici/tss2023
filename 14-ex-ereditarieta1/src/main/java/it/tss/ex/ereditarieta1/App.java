/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.ereditarieta1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

/**
 *
 * @author ospite
 */
public class App {
    public static void main(String[] args) {
        LocalDate data = LocalDate.of(2023,02,4);
        
        long giorni = ChronoUnit.DAYS.between(data,LocalDate.now());
        
        System.out.println(giorni);
    }
}
