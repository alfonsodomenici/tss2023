/*
start

end



 */
package it.tss.libreria;

import java.util.logging.Logger;
import javax.json.JsonObject;

/**
 *
 * @author ospite
 */
public class App {

    private static final Logger logger
            = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Rest rest = new Rest();
        JsonObject found = rest.findLibro(1);
        System.out.println(found);
    }

}
