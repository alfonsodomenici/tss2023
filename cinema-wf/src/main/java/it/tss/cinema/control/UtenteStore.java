package it.tss.cinema.control;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import it.tss.cinema.Control;
import it.tss.cinema.entity.Utente;

@Control
public class UtenteStore extends AbstractStore<Utente>{
    

    public UtenteStore() {
        super(Utente.class);
    }

    public Optional<Utente> findByUsrAndPwd(String usr, String pwd){
        try{
            Utente found = em.createNamedQuery(Utente.FIND_BY_USR_PWD,Utente.class)
            .setParameter("usr", usr)
            .setParameter("pwd", pwd)
            .getSingleResult();
            return Optional.of(found);
        }catch(NoResultException | NonUniqueResultException  ex){
            return Optional.empty();
        }
    }


}
