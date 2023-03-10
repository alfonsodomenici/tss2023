/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.libreria;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ospite
 * @param <T>
 */
public class  AbstractStore<T extends Serializable> {
    protected static EntityManager em;
    protected Class<T> entityClass;
    
    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();
    }

    public AbstractStore() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class) genericSuperclass.getActualTypeArguments()[1];
    }
    
    
    public T save(T e){
        em.getTransaction().begin();
        final T saved = em.merge(e);
        em.getTransaction().commit();
        return saved;
    }
    
    public void remove(Long id){
        em.getTransaction().begin();
        em.remove(findById(id));
        em.getTransaction().commit();
    }
    
    public T findById(Long id){
        return em.find(entityClass, id);
    }
    
}
