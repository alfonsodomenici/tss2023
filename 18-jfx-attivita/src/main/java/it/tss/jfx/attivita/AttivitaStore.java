/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jfx.attivita;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author alfonso
 */
public class AttivitaStore {

    private static AttivitaStore instance;

    private List<Attivita> elenco;

    private AttivitaStore() {
        elenco = new ArrayList<>();
    }

    public static AttivitaStore getInstance() {
        if (instance == null) {
            instance = new AttivitaStore();
        }
        return instance;
    }

    public List<Attivita> getAttivita() {
        return Collections.unmodifiableList(elenco);
    }

    public void save(@Valid Attivita e) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator v = vf.getValidator();
        Set<ConstraintViolation<Attivita>> validate = v.validate(e);
        if(!validate.isEmpty()){
            System.out.println(validate);
            return;
        }
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
