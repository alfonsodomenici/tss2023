/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.enterprise.context.Dependent;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author ospite
 */
@Entity
public class Categoria extends AbstractEntity {

    @NotBlank
    @Column(unique = true)
    private String nome;

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", this.getId())
                .add("nome", this.nome)
                .build();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", nome=" + nome + '}';
    }

}
