package it.tss.cinema.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotNull
    Ruolo ruolo;

    

    public Utente() {
    }

    
    public Utente(String usr, String pwd, Ruolo ruolo) {
        this.usr = usr;
        this.pwd = pwd;
        this.ruolo = ruolo;
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

    

}
