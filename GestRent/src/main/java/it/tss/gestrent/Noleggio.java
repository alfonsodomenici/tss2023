/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.gestrent;

import java.time.LocalDate;


/**
 *
 * @author ospite
 */
public class Noleggio {
    private int cod_cliente;
    private String targa;
    private LocalDate data_start_rent =LocalDate.now();
    private LocalDate data_end_rent;

    public Noleggio(int cod_cliente, String targa) {
        this.cod_cliente = cod_cliente;
        this.targa = targa;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    

    public String getTarga() {
        return targa;
    }

    
    public LocalDate getData_start_rent() {
        return data_start_rent;
    }

    
    public LocalDate getData_end_rent() {
        return data_end_rent;
    }

    public void setData_end_rent(LocalDate data_end_rent) {
        this.data_end_rent = data_end_rent;
    }
    
    
    
}
