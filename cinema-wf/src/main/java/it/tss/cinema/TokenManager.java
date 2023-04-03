/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cinema;

import io.smallrye.jwt.build.Jwt;
import it.tss.cinema.entity.Utente;
import java.util.Arrays;
import java.util.HashSet;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.Claims;

/**
 *
 * @author ospite
 */
public class TokenManager {
   
    @Inject
    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String iss;
    
    public String generate(Utente e){
        String token = Jwt.issuer(iss)
                .subject(e.getId().toString())
                .upn(e.getUsr())
                .groups(new HashSet<>(Arrays.asList(e.getRuolo().name())))
                .claim(Claims.birthdate.name(), e.getDataNascita().toString())
                .sign();
        return token;
    }
}
