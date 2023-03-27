/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

/**
 *
 * @author ospite
 */
@NamedQueries({
   @NamedQuery(name = Messaggio.FIND_ALL,
           query = "select e from Messaggio e order by  e.data desc"),
    @NamedQuery(name = Messaggio.FIND_BY_TESTO,
            query = "select e from Messaggio e "
                    + "where e.testo like :search order by e.data desc")
})

@Entity
@Table(name = "messaggio")
public class Messaggio implements Serializable {
    
    public static final String FIND_ALL = "Messaggio.findAll";
    
    public static final String FIND_BY_TESTO = "Messaggio.findByTesto";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank
    //@Lob numero illimitato di caratteri
    @Column(nullable = false, length = 1024)
    private String testo;
    
    @NotNull
    @PastOrPresent
    @Column(nullable = false)
    private LocalDateTime data;

    public Messaggio() {
    }

    
    public Messaggio(String testo, LocalDateTime data) {
        this.testo = testo;
        this.data = data;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    @JsonbDateFormat(value = "dd/MMM/yyyy HH:mm:ss")
    public LocalDateTime getData() {
        return data;
    }

    @JsonbDateFormat(value = "dd/MM/yyyy'T'HH:mm:ss")
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id;
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
        final Messaggio other = (Messaggio) obj;
        return this.id == other.id;
    }

    

    @Override
    public String toString() {
        return "Messaggio{" + "id=" + id + ", testo=" + testo + ", data=" + data + '}';
    }
    
    
}
