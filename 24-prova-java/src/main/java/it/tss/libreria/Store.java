/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.libreria;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 * Classe con solo metodi statici per interagire con il DB tramite JPA
 *
 *
 * @author ospite
 */
public class Store {

    private static Logger logger
            = Logger.getLogger(Store.class.getName());

    private static EntityManager em;

    static {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();

    }

    private Store() {
    }

    public static void init() {

    }

    /**
     * Salva un generico oggetto su database.
     *
     * @param <T>
     * @param e
     * @return
     */
    public static <T> T save(T e) {
        if (em.getTransaction().isActive()) {
            return em.merge(e);
        }

        em.getTransaction().begin();

        final T saved = em.merge(e);

        em.getTransaction().commit();

        return saved;
    }

    /**
     * Importa i Libri da uno Stream
     *
     * @param libri
     */
    public static void importFromStream(Stream<Libro> libri) {
        em.getTransaction().begin();

        logger.info("start import libri.....");

        libri.forEach(em::merge);

        logger.info("end import libri.....");

        em.getTransaction().commit();

    }

    /**
     * Cerca Libri tramite il titolo
     *
     * @param titolo
     * @return
     *
     */
    public static Optional<Libro> findLibroByTitolo(String titolo) {
        try {
           return Optional.of(em.createNamedQuery(Libro.FIND_BY_TITOLO, Libro.class)
                    .setParameter("ptitolo", titolo)
                    .getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    /**
     * Cerca Autori tramite nome e cognome
     *
     * @param nome
     * @param cognome
     * @return
     */
    public static List<Autore> findAutore(String nome, String cognome) {

        return em.createNamedQuery(Autore.FIND_BY_NOME_COGNOME, Autore.class)
                .setParameter("pnome", nome)
                .setParameter("pcognome", cognome)
                .getResultList();

    }

    /**
     * Cerca Categorie tramite il nome
     *
     * @param nome
     * @return
     */
    public static List<Categoria> findCategoria(String nome) {

        return em.createNamedQuery(Categoria.FIND_BY_NOME, Categoria.class)
                .setParameter("pnome", nome)
                .getResultList();

    }

}
