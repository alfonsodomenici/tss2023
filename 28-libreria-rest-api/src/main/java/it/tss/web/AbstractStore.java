/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.web;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author ospite
 * @param <T>
 */
public class AbstractStore<T extends AbstractEntity> {

    @PersistenceContext
    protected EntityManager em;

    protected Class<T> entityClass;

    @PostConstruct
    public void init() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class) genericSuperclass.getActualTypeArguments()[0];
    }

    public T save(T e) {
        return em.merge(e);
    }

    public void remove(Long id) {
        em.remove(
                findById(id)
                        .orElseThrow(() -> new NotFoundException())
        );
    }

    public Optional<T> findById(Long id) {
        T found = em.find(entityClass, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

}
