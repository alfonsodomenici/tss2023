package it.tss.jfx.attivita;

import java.util.List;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Messages {

    private static final String TITOLO = "Gestione Attivita Message";

    private Messages() {
    }

    public static Optional<ButtonType> showConfirmMessage(String header, 
            String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(TITOLO);
        alert.setHeaderText(header);
        alert.setContentText(content);
        return alert.showAndWait();
    }
    
    public static void showInfoMessage(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(TITOLO);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}