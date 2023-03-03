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
 * @author ospite
 */
public class AttivitaGestioneViewModel {

    private Attivita currentAttivita;
    private AttivitaStore store
            = AttivitaStore.getInstance();
    private final ObjectProperty<LocalDate> data = new SimpleObjectProperty<>();
    private final ObjectProperty<Integer> durata = new SimpleObjectProperty<>();
    private final IntegerProperty costo = new SimpleIntegerProperty();
    private final StringProperty descrizione = new SimpleStringProperty();
    private ObservableList<Attivita> elencoAttivita;

    public AttivitaGestioneViewModel() {

        elencoAttivita = FXCollections
                .observableArrayList(store.all());
        data.addListener((obs, ov, nv)
                -> currentAttivita.setData(nv));
        durata.addListener((obs, ov, nv)
                -> currentAttivita.setDurata(nv));
        costo.addListener((obs, ov, nv)
                -> currentAttivita.setCosto(nv.intValue()));
        descrizione.addListener((obs, ov, nv)
                -> currentAttivita.setDescrizione(nv));

    }

    private void fromAttivita() {
        data.setValue(currentAttivita.getData());
        durata.setValue(currentAttivita.getDurata());
        costo.setValue(currentAttivita.getCosto());
        descrizione.setValue(currentAttivita.getDescrizione());
    }

    public void save() {
        store.save(currentAttivita);
        updateElencoAttivita();
    }

    public void updateElencoAttivita() {
        elencoAttivita.clear();
        elencoAttivita.addAll(store.all());
    }

    public void reset() {
        currentAttivita = new Attivita();
        fromAttivita();
    }

    public void setCurrentAttivita(Attivita value) {
        currentAttivita = value;
        fromAttivita();
    }

    /*
    getters / setters 
     */
    public ObservableList<Attivita> getElencoAttivita() {
        return elencoAttivita;
    }

    public LocalDate getData() {
        return data.get();
    }

    public void setData(LocalDate value) {
        data.set(value);
    }

    public ObjectProperty<LocalDate> dataProperty() {
        return data;
    }

    public Integer getDurata() {
        return durata.get();
    }

    public void setDurata(Integer value) {
        durata.set(value);
    }

    public ObjectProperty<Integer> durataProperty() {
        return durata;
    }

    public Integer getCosto() {
        return costo.get();
    }

    public void setCosto(Integer value) {
        this.costo.set(value);
    }

    public IntegerProperty costoProperty() {
        return costo;
    }

    public String getDescrizione() {
        return descrizione.get();
    }

    public void setDescrizione(String value) {
        this.descrizione.set(value);
    }

    public StringProperty descrizioneProperty() {
        return descrizione;
    }

    public void delete() {
        if(currentAttivita==null){
            return;
        }
        store.remove(currentAttivita);
        updateElencoAttivita();
        reset();
    }

}
