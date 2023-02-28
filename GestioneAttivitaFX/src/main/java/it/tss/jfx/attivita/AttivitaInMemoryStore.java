/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jfx.attivita;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Singleton
 * @author alfonso
 */
public class AttivitaInMemoryStore {

    private static AttivitaInMemoryStore instance;

    private List<Attivita> elenco;

    private AttivitaInMemoryStore() {
        elenco = new ArrayList<>();
    }

    public static AttivitaInMemoryStore getInstance() {
        if (instance == null) {
            instance = new AttivitaInMemoryStore();
        }
        return instance;
    }

    public List<Attivita> getAttivita() {
        return Collections.unmodifiableList(elenco);
    }

    public void save(Attivita e) {
        int idx = elenco.indexOf(e);
        if (idx == -1) {
            elenco.add(e);
        } else {
            elenco.set(idx, e);
        }
        System.out.println(elenco);
    }

    public void remove(Attivita e) {
        elenco.remove(e);
    }

}
