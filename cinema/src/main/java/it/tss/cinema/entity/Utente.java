package it.tss.cinema.entity;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

@Entity
@Table(name = "utente")
public class Utente extends AbstractEntity {
    public static enum Ruolo{
        USER,ADMIN
    }

    @NotBlank
    @Column(nullable = false,unique = true)
    String usr;

    @NotBlank
    @Column(nullable = false)
    String pwd;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    Ruolo ruolo;

    @JsonbProperty("data_nascita")
    @NotNull
    @PastOrPresent
    @Column(nullable = false, name = "data_nascita")
    LocalDate dataNascita;

    public Utente() {
    }

    public Utente(@NotBlank String usr, @NotBlank String pwd, @NotNull Ruolo ruolo,
            @NotNull @PastOrPresent LocalDate dataNascita) {
        this.usr = usr;
        this.pwd = pwd;
        this.ruolo = ruolo;
        this.dataNascita = dataNascita;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    

    

}
