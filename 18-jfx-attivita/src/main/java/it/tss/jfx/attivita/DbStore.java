/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.jfx.attivita;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alfonso
 */
public class DbStore {

    private static EntityManager em;
    private static EntityManagerFactory emf;

    private DbStore() {
    }

    
    static {
        init();
    }

    private static void init() {
        emf = Persistence.createEntityManagerFactory("dbattivita");
        em = emf.createEntityManager();
    }

    public static EntityManager getEm(){
        return em;
    }
}
