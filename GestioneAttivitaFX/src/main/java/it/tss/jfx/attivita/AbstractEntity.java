/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jfx.attivita;

import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author alfonso
 */
public abstract class AbstractEntity {

    private final String id;

    public AbstractEntity() {
        id = UUID.randomUUID().toString();
    }

    /*
    getters / setters
     */
    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "id=" + id + '}';
    }

}
