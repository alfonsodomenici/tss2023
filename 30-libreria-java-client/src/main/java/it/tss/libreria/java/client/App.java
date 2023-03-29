/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.libreria.java.client;

import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author ospite
 */
public class App {
    public static void main(String[] args) {
        Client c = ClientBuilder.newClient();
        Response resp = c
                .target("http://localhost:8080/28-libreria-rest-1.0/api/libri")
                .request(MediaType.APPLICATION_JSON)
                .get();
        JsonArray data = resp.readEntity(JsonArray.class);
        data.forEach(System.out::println);
    }
}
