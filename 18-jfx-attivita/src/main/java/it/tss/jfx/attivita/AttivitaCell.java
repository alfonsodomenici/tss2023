/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jfx.attivita;

import it.tss.jfx.attivita.Attivita;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;

/**
 *
 * @author ospite
 */
public class AttivitaCell extends ListCell<Attivita> {

    @Override
    public void updateItem(Attivita att, boolean empty) {
        super.updateItem(att, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else if (att != null) {
            setText(null);
            setGraphic(new CellPanel(att));
        } else {
            setText("null");
            setGraphic(null);
        }
    }

}

class CellPanel extends VBox {

    private Attivita att;

    public CellPanel(Attivita att) {
        this.setPadding(new Insets(10));
        this.att = att;
        final Label ldata = new Label(att.getData().toString());
        ldata.setPadding(new Insets(5,5,5,0));
        ldata.setStyle("-fx-font-size: 20; -fx-text-fill: gray;-fx-font-weight:bold");
        this.getChildren().add(ldata);
        this.getChildren().add(new Label("Durata: " + String.valueOf(att.getDurata())));
        this.getChildren().add(new Label("Costo: " + String.valueOf(att.getDurata())));
        this.getChildren().add(new Label(att.getDescrizione()));
        this.getChildren().add(new Separator(Orientation.HORIZONTAL));
    }

}
