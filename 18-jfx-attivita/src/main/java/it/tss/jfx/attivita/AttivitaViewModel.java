/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jfx.attivita;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author alfonso
 */
public class AttivitaViewModel {

    private AttivitaStore store = AttivitaStore.getInstance();

    private Attivita currentAttivita;
    private ObservableList<Attivita> elencoAttivita;
    private final ObjectProperty<LocalDate> data = new SimpleObjectProperty<>();
    private final ObjectProperty<Integer> durata = new SimpleObjectProperty<>(0);
    private final IntegerProperty costo = new SimpleIntegerProperty(0);
    private final StringProperty descrizione = new SimpleStringProperty();

    public AttivitaViewModel() {
        reset();
        elencoAttivita = FXCollections.observableArrayList(store.getAttivita());
    }

    public final void setData(LocalDate value) {
        data.set(value);
    }

    public final LocalDate getData() {
        return data.get();
    }

    public final ObjectProperty<LocalDate> dataProperty() {
        return data;
    }

    public final void setDurata(Integer value) {
        durata.set(value);
    }

    public final Integer getDurata() {
        return durata.get();
    }

    public final ObjectProperty<Integer> durataProperty() {
        return durata;
    }

    public final void setCosto(Integer value) {
        costo.set(value);
    }

    public final Integer getCosto() {
        return costo.get();
    }

    public final IntegerProperty costoProperty() {
        return costo;
    }

    public final void setDescrizione(String value) {
        descrizione.set(value);
    }

    public final String getDescrizione() {
        return descrizione.get();
    }

    public final StringProperty descrizioneProperty() {
        return descrizione;
    }

    public Attivita getCurrentAttivita() {
        return currentAttivita;
    }

    public void setCurrentAttivita(Attivita currentAttivita) {
        System.out.println(currentAttivita);
        this.currentAttivita = currentAttivita;
        toUI();
    }

    public ObservableList<Attivita> getElencoAttivita() {
        return elencoAttivita;
    }

    public final void reset() {
        currentAttivita = new Attivita();
        toUI();
    }

    public void save() {
        fromUI();
        store.save(currentAttivita);
        updateCurrentInElenco();
        reset();
    }

    void delete() {
        if(currentAttivita==null){
            return;
        }
        store.remove(currentAttivita);
        elencoAttivita.remove(currentAttivita);
        reset();
    }

    private void updateCurrentInElenco() {
        int idx = elencoAttivita.indexOf(currentAttivita);
        if (idx == -1) {
            elencoAttivita.add(currentAttivita);
        } else {
            elencoAttivita.set(idx, currentAttivita);
        }
    }

    private void toUI() {
        data.setValue(currentAttivita.getData());
        durata.setValue(currentAttivita.getDurata());
        costo.setValue(currentAttivita.getCosto());
        descrizione.setValue(currentAttivita.getDescrizione());
    }

    private void fromUI() {
        currentAttivita.setData(data.getValue());
        currentAttivita.setDurata(durata.getValue());
        currentAttivita.setCosto(costo.getValue());
        currentAttivita.setDescrizione(descrizione.getValue());
    }
}
