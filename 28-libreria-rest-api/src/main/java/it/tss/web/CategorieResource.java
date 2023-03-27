/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web;

import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author ospite
 */
@Path("categorie")
public class CategorieResource {

    @Inject
    CategoriaStore store;
}
