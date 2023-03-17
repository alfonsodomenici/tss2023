/*
start
    if (file libri.csv non esiste o vuoto) then
        log("nulla da importare");
        termina programma;
    end if

    righe = leggoFile();
    inizio transazione
        while(righe non finite) do
            campi[] = leggiCampi(riga);
            if(titolo esiste già)then
                log("libro non importato perchè esistente");
                continue;
            end if
            Libro e = new Libro(campi libro);
            e.setAutore(cercaOrInserisciAutore(campi autore))
            e.setCategorie(cercaOrInserisciCategorie(campi categorie))
            salva libro
            log("libro importato correttamente")
        end while
    commit transazione

end



 */
package it.tss.libreria;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.DateTimeException;
import java.util.logging.Logger;

/**
 *
 * @author ospite
 */
public class App {

    private static final Logger logger
            = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            logger.info("start program");
            ImportManager.initDB(false);
            logger.info("import iniziale eseguito correttamente");
        } catch (Exception ex) {
            logger.severe("Importazione annullata!!!!!!!");
            logger.severe(ex.getMessage());
        }finally{
            logger.info("end program");
        }
    }

}
