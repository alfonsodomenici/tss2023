/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it.tss.jfx.attivita;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 * FXML Controller class
 *
 * @author alfonso
 */
public class AttivitaGestioneController implements Initializable {
    
    @FXML
    private DatePicker dpData;
    @FXML
    private Spinner<Integer> spDurata;
    @FXML
    private TextField tfCosto;
    @FXML
    private TextArea taDescrizione;
    @FXML
    private ListView<Attivita> lvAttivita;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    

    @FXML
    private void onNuovaAttivita(ActionEvent e) {
        
    }

    @FXML
    private void onSalvaAttivita(ActionEvent e) {
        
    }

    @FXML
    private void onEliminaAttivita(ActionEvent e) {
        
    }

    private void onSelectedAttivitaChange(ObservableValue<? extends Attivita> obs,
            final Attivita ov, final Attivita nv) {
        

    }

    @FXML
    private void onEsci(ActionEvent e) {
        Platform.exit();
    }

    @FXML
    private void onAbout(ActionEvent e) throws IOException {
        
    }

    
}
