/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.hello;

import it.tss.hello.entity.Libro;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ospite
 */
@SessionScoped
@Named
public class LibriController implements Serializable{
    @Inject
    Store store;
    private List<Libro> filteredLibri;
    private List<Libro> libri;
    
    @PostConstruct
    public void init(){
        System.out.println("init");
        libri = store.allLibri();
    }

    public List<Libro> getLibri() {
        System.out.println("getLibri");
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }

    

    public List<Libro> getFilteredLibri() {
        return filteredLibri;
    }

    public void setFilteredLibri(List<Libro> filteredLibri) {
        this.filteredLibri = filteredLibri;
    }
    
    
}
