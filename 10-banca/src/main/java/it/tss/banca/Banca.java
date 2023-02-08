/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.banca;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.naming.OperationNotSupportedException;

/**
 *
 * @author ospite
 */
public class Banca {

    private final String nome;
    private final List<ContoCorrente> conti = new ArrayList<>();

    public Banca(String nome) {
        this.nome = nome;
    }

    public int apriConto(String intestatario) {
        ContoCorrente nuovoCc = new ContoCorrente(intestatario);
        conti.add(nuovoCc);
        return nuovoCc.getNumero();
    }

    public double preleva(int nconto, double importo) {
        ContoCorrente found = cerca(nconto)
                .orElseThrow(() -> new IllegalArgumentException("conto inesistente"));
        return found.prelievo(importo);
    }

    public double deposita(int nconto, double importo) {
        ContoCorrente found = cerca(nconto)
                .orElseThrow(() -> new IllegalArgumentException("conto inesistente"));

        return found.versamento(importo);
    }

    public double saldo(int nconto) {
        ContoCorrente found = cerca(nconto)
                .orElseThrow(() -> new IllegalArgumentException("conto inesistente"));
        return found.getSaldo();
    }

    private Optional<ContoCorrente> cerca(int nconto) {
        for (ContoCorrente conto : conti) {
            if (conto.numero == nconto) {
                return Optional.of(conto);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "Banca{" + "nome=" + nome + ", conti=" + conti + '}';
    }

    private static class ContoCorrente {

        private static int contatore = 1;
        private double saldo;
        private final String intestatario;
        private final int numero;

        private ContoCorrente(String intestatario) {
            if (intestatario == null || intestatario.isBlank()) {
                throw new IllegalArgumentException("intestatario vuoto non permesso");
            }
            this.intestatario = intestatario;
            this.numero = contatore++;
        }

        private double versamento(double importo) {
            if (importo <= 0) {
                throw new IllegalArgumentException("importo negativo non permesso");
            }
            this.saldo += importo;
            return this.saldo;
        }

        private double prelievo(double importo) {
            if (importo > saldo) {
                throw new IllegalArgumentException("saldo non sufficiente");
            }
            this.saldo -= importo;
            return this.saldo;
        }

        /*
        getters / setters
         */
        private double getSaldo() {
            return saldo;
        }

        private String getIntestatario() {
            return intestatario;
        }

        private int getNumero() {
            return numero;
        }

        @Override
        public String toString() {
            return "ContoCorrente{" + "saldo=" + saldo + ", intestatario=" + intestatario + ", numero=" + numero + '}';
        }

    }
}
