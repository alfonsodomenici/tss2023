/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.book.library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author ospite
 */
public class Library {

    private final ArrayList<Prestito> prestiti = new ArrayList<>();

    /**
     * Il metodo addBook aggiunge un libro alla biblioteca. Se il libro era già
     * stato aggiunto,restituisce false.
     *
     * @param b
     * @return
     */
    public boolean addBook(Book b) {
        if (search(b).isPresent()) {
            return false;
        }
        return prestiti.add(new Prestito(b));
    }

    /**
     * Il metodo loanBook prende un libro come argomento e lo dà in prestito, a
     * patto che sia disponibile. Se quel libro è già in prestito, restituisce
     * false. Se quel libro non è mai stato inserito nella biblioteca, lancia
     * un'eccezione.
     *
     * @param b
     * @return
     */
    public boolean loanBook(Book b) {
        Prestito daPrestare = search(b)
                .orElseThrow(() -> new IllegalArgumentException("libro nonpresente"));
        if (daPrestare.isDisponibile()) {
            daPrestare.dataPrestito = LocalDateTime.now();
            return true;
        }
        return false;
    }

    /**
     * Il metodo returnBook prende un libro come argomento e restituisce quel
     * libro alla biblioteca. Se quel libro non era stato prestato col metodo
     * loanBook, il metodo returnBook lancia un'eccezione.
     *
     * @param b
     */
    public void returnBook(Book b) {
        Prestito daPrestare = search(b)
                .orElseThrow(() -> new IllegalArgumentException("libro nonpresente"));
        if (daPrestare.isDisponibile()) {
            throw new IllegalArgumentException("Libro non prestato");
        }
        daPrestare.dataPrestito = null;
    }

    /**
     * Il metodo printLoans stampa la lista dei libri attualmente in prestito,
     * in ordine temporale (a partire dal libro in prestito da più tempo).
     */
    public void printLoans() {

    }

    private Optional<Prestito> search(Book b) {
        for (Prestito p : prestiti) {
            if (p.book.equals(b)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    private static class Prestito {

        private final Book book;
        private LocalDateTime dataPrestito = null;

        private Prestito(Book book) {
            this.book = book;
        }

        private boolean isDisponibile() {
            return dataPrestito == null;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 29 * hash + Objects.hashCode(this.book);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Prestito other = (Prestito) obj;
            return Objects.equals(this.book, other.book);
        }

        @Override
        public String toString() {
            return "Prestito{" + "book=" + book + ", dataPrestito=" + dataPrestito + '}';
        }

    }
}
