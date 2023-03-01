/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jfx.attivita;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

/**
 *
 * @author ospite
 */
public class AttivitaListCell extends ListCell<Attivita> {

    @Override
    protected void updateItem(Attivita att, boolean empty) {
        super.updateItem(att, empty);
        if (empty || att == null) {
            setText(null);
            setGraphic(null);
        } else {
            setText(null);
            setGraphic(new AttivitaPanel(att));
        }
    }
}

class AttivitaPanel extends VBox {

    public AttivitaPanel(Attivita att) {
        this.setPadding(new Insets(10));
        final Label ldata = new Label(att.getData().toString());
        ldata.setPadding(new Insets(5, 5, 5, 0));
        ldata.setStyle("-fx-font-size: 20; -fx-text-fill: red;-fx-font-weight:bold");
        this.getChildren().add(ldata);
        this.getChildren().add(new Label("Durata: " + String.valueOf(att.getDurata())));
        this.getChildren().add(new Label("Costo: " + String.valueOf(att.getDurata())));
        this.getChildren().add(new Label(att.getDescrizione()));
        this.getChildren().add(new Separator(Orientation.HORIZONTAL));
    }
}
