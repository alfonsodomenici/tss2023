/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/CDI/Stereotype.java to edit this template
 */
package it.tss.web;

import java.lang.annotation.ElementType;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.transaction.Transactional;

/**
 *
 * @author ospite
 */
@Stereotype
@Transactional(Transactional.TxType.REQUIRES_NEW)
@RequestScoped
@Retention(RUNTIME)
@Target({ElementType.TYPE})
public @interface Boundary {
}
