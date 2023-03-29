/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web.categorie;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.stream.JsonCollectors;

/**
 *
 * @author ospite
 */
@RequestScoped
public class CategoriaLinkAdapter implements JsonbAdapter<Set<Categoria>, JsonArray> {

    @Inject
    CategoriaStore store;

    @Override
    public JsonArray adaptToJson(Set<Categoria> e) throws Exception {
        return e.stream()
                .map(Categoria::toJson)
                .collect(JsonCollectors.toJsonArray());
    }

    @Override
    public Set<Categoria> adaptFromJson(JsonArray e) throws Exception {
        Set<Categoria> result = new HashSet<>();
        for (int i = 0; i < e.size(); i++) {
            result.add(store.findById(
                    Long.valueOf(e.getInt(i)))
                    .orElseThrow(() -> new RuntimeException("id non trovato")));
        }
        return result;
    }

}
