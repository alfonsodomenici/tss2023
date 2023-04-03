package it.tss.cinema;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Stereotype;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Stereotype
@Dependent
@Transactional(value = TxType.REQUIRED)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Control {
    
}
