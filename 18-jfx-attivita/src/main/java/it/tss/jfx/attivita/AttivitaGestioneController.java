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

    private final AttivitaGestioneViewModel viewModel = new AttivitaGestioneViewModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spDurata.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60, 0, 15));
        tfCosto.setTextFormatter(new TextFormatter<>(this::filterNumbers));
        lvAttivita.getSelectionModel().selectedItemProperty().addListener(this::onSelectedAttivitaChange);
        lvAttivita.setCellFactory(lv -> new AttivitaCell());
        
        initBindigs();
    }

    private void initBindigs() {
        lvAttivita.setItems(viewModel.getElencoAttivita());
        dpData.valueProperty().bindBidirectional(viewModel.dataProperty());
        spDurata.getValueFactory().valueProperty().bindBidirectional(viewModel.durataProperty());
        Bindings.bindBidirectional(tfCosto.textProperty(), viewModel.costoProperty(), new NumberStringConverter());
        taDescrizione.textProperty().bindBidirectional(viewModel.descrizioneProperty());
    }

    @FXML
    private void onNuovaAttivita(ActionEvent e) {
        viewModel.reset();
        lvAttivita.getSelectionModel().clearSelection();
    }

    @FXML
    private void onSalvaAttivita(ActionEvent e) {
        viewModel.save();
    }

    @FXML
    private void onEliminaAttivita(ActionEvent e) {
        viewModel.delete();
        lvAttivita.getSelectionModel().clearSelection();
    }

    private void onSelectedAttivitaChange(ObservableValue<? extends Attivita> obs,
            final Attivita ov, final Attivita nv) {
        if (nv != null) {
            viewModel.setCurrentAttivita(nv);
        }

    }

    @FXML
    private void onEsci(ActionEvent e) {
        Platform.exit();
    }

    @FXML
    private void onAbout(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("about.fxml"));
        Stage dialog = new Stage();
        dialog.setTitle("About Gestione Attivita Software");
        dialog.setScene(new Scene(fxmlLoader.load()));
        dialog.initOwner(App.getRootStage());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }

    private TextFormatter.Change filterNumbers(TextFormatter.Change change) {
        String text = change.getText();

        if (text.matches("[0-9]*")) {
            return change;
        }

        return null;
    }
}
