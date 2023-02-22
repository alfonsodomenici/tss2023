/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it.tss.jfx.attivita;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 * FXML Controller class
 *
 * @author alfonso
 */
public class AttivitaGestioneController implements Initializable {

    @FXML
    private DatePicker dfData;
    @FXML
    private Spinner<Integer> spDurata;
    @FXML
    private TextField tfCosto;
    @FXML
    private TextArea tfDescrizione;
    @FXML
    private Button btnSalva;
    @FXML
    private Button btnNuova;
    @FXML
    private ListView<Attivita> lvAttivita;

    private final AttivitaViewModel viewModel = new AttivitaViewModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spDurata.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60, 0, 15));
        tfCosto.setTextFormatter(new TextFormatter<>(this::filterNumbers));
        btnNuova.setOnAction(this::onNuovaAttivita);
        btnSalva.setOnAction(this::onSalvaAttivita);
        lvAttivita.getSelectionModel().selectedItemProperty().addListener(this::onSelectedAttivitaChange);
        initBindigs();
    }

    private void initBindigs() {
        lvAttivita.setItems(viewModel.getElencoAttivita());
        dfData.valueProperty().bindBidirectional(viewModel.dataProperty());
        spDurata.getValueFactory().valueProperty().bindBidirectional(viewModel.durataProperty());
        Bindings.bindBidirectional(tfCosto.textProperty(), viewModel.costoProperty(), new NumberStringConverter());
        tfDescrizione.textProperty().bindBidirectional(viewModel.descrizioneProperty());
    }

    private void onNuovaAttivita(ActionEvent e) {
        viewModel.reset();
        lvAttivita.getSelectionModel().clearSelection();
    }

    private void onSalvaAttivita(ActionEvent e) {
        viewModel.save();
    }

    private void onSelectedAttivitaChange(ObservableValue<? extends Attivita> obs,
            final Attivita ov, final Attivita nv) {
        if (nv != null) {
            viewModel.setCurrentAttivita(nv);
        }

    }

    private TextFormatter.Change filterNumbers(TextFormatter.Change change) {
        String text = change.getText();

        if (text.matches("[0-9]*")) {
            return change;
        }

        return null;
    }
}
