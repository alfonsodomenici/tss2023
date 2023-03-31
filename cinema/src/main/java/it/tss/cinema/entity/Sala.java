package it.tss.cinema.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "sala")
public class Sala extends AbstractEntity {
    
    @NotBlank
    @Column(nullable = false)
    String nome;

    @Min(0)
    int posti;

    public Sala() {
    }
    public Sala(String nome, int posti) {
        this.nome = nome;
        this.posti = posti;
    }

    
}
