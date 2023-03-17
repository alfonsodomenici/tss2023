/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.libreria;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 *
 *
 * @author ospite
 */
public class ImportManager {

    private static final String IMPORT_NAME = "libri.csv";

    private static final Logger logger
            = Logger.getLogger(ImportManager.class.getName());

    private ImportManager() {
    }

    /**
     * Importa i libri nel database
     *
     * @param skipExisting non aggiorna i libri esistenti
     * @throws URISyntaxException
     * @throws IOException
     */
    public static void initDB(boolean skipExisting) throws URISyntaxException, IOException {
        Store.importFromStream(
                leggiFileCsv()
                        .map(v -> ImportManager.libroToImport(v, skipExisting))
                        .filter(v -> v.isPresent())
                        .map(v -> v.get())
        );
    }

    /**
     * Leggi i dati dal file resources/libri.csv
     *
     *
     * @return uno Stream<String> che sono le righe del file letto
     * @throws URISyntaxException
     * @throws IOException
     */
    private static Stream<String> leggiFileCsv() throws URISyntaxException, IOException {
        URL resource = App.class.getResource("/" + IMPORT_NAME);
        
        if (resource == null) {
            logger.info("nulla da importare, file non trovato");
            return Stream.empty();
        }
        
        Stream<String> righe = Files.lines(Paths.get(resource.toURI()));
        if (righe.count() == 0) {
            logger.info("nulla da importare, file vuoto");
            return Stream.empty();
        }
        
        return Files.lines(Paths.get(resource.toURI()));
    }

    /**
     *
     *
     * @param dati (campi del libro da importare separati da ",")
     * @return Optional<Libro> contenente l'istanza di Libro da Importare
     */
    private static Optional<Libro> libroToImport(String dati, boolean skipExisting) {
        String[] campi = dati.split(",");
        
        logger.info(String.format("dati libro: %s ", Arrays.asList(campi)));
        
        Optional<Libro> found = Store.findLibroByTitolo(campi[0].trim());
        if (found.isPresent() && skipExisting) {
            logger.warning(String.format("Libro non importato perchè esistente.%s", found));
            return Optional.empty();
        }
        
        Libro libro = found.orElse(new Libro());
        libro.setTitolo(campi[0]);
        libro.setDataPubblicazione(LocalDate.parse(campi[2]));
        libro.setAutore(insertOrFindAutore(campi[1]));
        libro.setCategorie(insertOrFindCategorie(campi[3]));
        
        logger.info(String.format("Importo il Libro %s", libro));
        
        return Optional.of(libro);

    }

    /**
     * Ritorna un Autore esistente oppure un nuovo Autore
     *
     * @param dati (campi dell'autore da importare separati da "|")
     * @return Autore trovato o inserito
     */
    private static Autore insertOrFindAutore(String dati) {
        String[] campi = dati.split("\\|");
        
        List<Autore> found = Store.findAutore(campi[0], campi[1]);
        
        return found.isEmpty()
                ? Store.save(new Autore(campi[0], campi[1]))
                : found.get(0);
    }

    /**
     * Ritorna una collezione di Categorie esistenti e/o nuove
     *
     * @param dati (campi dell'autore da importare separati da "|")
     * @return Set<Categoria> trovate e/o inserite
     */
    private static Set<Categoria> insertOrFindCategorie(String dati) {
        
        String[] campi = dati.split("\\|");
        
        return Arrays.stream(campi)
                .map(ImportManager::insertOrFindCategoria)
                .collect(Collectors.toSet());
    }

    /**
     * Ritorna una Categoria esistente oppure una nuova Categoria
     *
     * @param dati (campi dell'autore da importare separati da "|")
     * @return Categoria trovata o inserita
     */
    private static Categoria insertOrFindCategoria(String nome) {
        
        List<Categoria> found = Store.findCategoria(nome);
        
        return found.isEmpty()
                ? Store.save(new Categoria(nome))
                : found.get(0);
    }
}
