/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it.tss.jfx.attivita;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    private Label leftStatus;
    @FXML
    private Button btnElimina;
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

    private AttivitaGestioneViewModel viewModel
            = new AttivitaGestioneViewModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spDurata.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        0, 120, 0, 15));
        tfCosto.setTextFormatter(new TextFormatter<>(this::onlyNumbers));
        lvAttivita.getSelectionModel()
                .selectedItemProperty()
                .addListener(this::onSelectedAttivitaChange);
        btnElimina.setDisable(true);
        lvAttivita.setCellFactory(lv -> new AttivitaListCell());
        initBindings();
    }

    private void initBindings() {
        viewModel.reset();
        dpData.valueProperty().bindBidirectional(viewModel.dataProperty());
        spDurata.getValueFactory().valueProperty()
                .bindBidirectional(viewModel.durataProperty());
        Bindings.bindBidirectional(tfCosto.textProperty(),
                viewModel.costoProperty(), new NumberStringConverter());
        taDescrizione.textProperty()
                .bindBidirectional(viewModel.descrizioneProperty());
        lvAttivita.setItems(viewModel.getElencoAttivita());
    }

    private TextFormatter.Change onlyNumbers(TextFormatter.Change change) {
        String testo = change.getText();
        if (testo.matches("[0-9]*")) {
            return change;
        }
        return null;
    }

    private void onSelectedAttivitaChange(
            ObservableValue<? extends Attivita> obs,
            Attivita ov,
            Attivita nv) {
        btnElimina.setDisable(nv == null);
        if (nv != null) {
            viewModel.setCurrentAttivita(nv);
            leftStatus.setText("in modifica attivita...");
        }
    }

    @FXML
    private void onNuovaAttivita(ActionEvent e) {
        viewModel.reset();
        lvAttivita.getSelectionModel().clearSelection();
        leftStatus.setText("nuova attivita...");
    }

    @FXML
    private void onSalvaAttivita(ActionEvent e) {
        Optional<ButtonType> result = Messages.showConfirmMessage("Salva attivita",
                "Sei sicuro di voler salvare le modifche all'Attività?");
        if (result.isEmpty()
                || result.get().getButtonData().isCancelButton()) {
            return;
        }
        viewModel.save();
        viewModel.reset();
        leftStatus.setText("attivita salvata...");
    }

    @FXML
    private void onEliminaAttivita(ActionEvent e) {
        Optional<ButtonType> result = Messages.showConfirmMessage(
                "Elimina attivita",
                "Sei sicuro di voler eliminare l'Attività selezionata?");
        if (result.isEmpty()
                || result.get().getButtonData().isCancelButton()) {
            return;
        }
        viewModel.delete();
        lvAttivita.getSelectionModel().clearSelection();
        leftStatus.setText("attivita eliminata...");
    }

    @FXML
    private void onEsci(ActionEvent e) {
        Platform.exit();
    }

    @FXML
    private void onAbout(ActionEvent e) throws IOException {

    }

}
