/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web;

import java.math.BigDecimal;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;

/**
 *
 * @author ospite
 */
@RequestScoped
public class AutoreLinkAdapter implements JsonbAdapter<Autore,JsonObject> {

    @Inject
    AutoreStore store;
    
    @Override
    public JsonObject adaptToJson(Autore e) throws Exception {
        return Json.createObjectBuilder()
                .add("id", e.getId())
                .add("descr", e.getNome()+  " " + e.getCognome())
                .build();
                
    }

    @Override
    public Autore adaptFromJson(JsonObject e) throws Exception {
       return e==null ? null : store.findById(Long.valueOf(e.getInt("id")))
               .orElseThrow(() -> new RuntimeException("id non trovato..."));
    }

    
}
