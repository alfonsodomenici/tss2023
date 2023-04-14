package it.tss.cinema.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@NamedQueries({
        @NamedQuery(name = Sala.FIND_ALL, query = "select e from Sala e order by e.nome"),
})

@Entity
@Table(name = "sala")
public class Sala extends AbstractEntity {
    
    public static final String FIND_ALL = "Sala.findAll";
    
    @NotBlank
    @Column(nullable = false, unique = true)
    String nome;

    @Min(0)
    @Column(nullable = false)
    int posti;

    public Sala() {
    }
    public Sala(String nome, int posti) {
        this.nome = nome;
        this.posti = posti;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPosti() {
        return posti;
    }
    public void setPosti(int posti) {
        this.posti = posti;
    }

    
    
}
