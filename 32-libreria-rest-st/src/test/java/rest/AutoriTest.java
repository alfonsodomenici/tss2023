/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ospite
 */
public class AutoriTest {

    static Client client;
    static WebTarget wt;

    @BeforeAll
    public static void init() {
        client = ClientBuilder.newClient();
        wt = client.target("http://localhost:8080/28-libreria-rest-1.0/api");
    }

    @Test
    public void all() {
        Response resp = wt.path("autori")
                .request(MediaType.APPLICATION_JSON)
                .get();
        assertTrue(resp.getStatus() == 200);
        JsonArray data = resp.readEntity(JsonArray.class);
        assertNotNull(data);
        assertTrue(data.size() > 0);
    }

    @Test
    public void find() {
        Response resp = wt.path("autori")
                .path("{id}")
                .resolveTemplate("id", 1)
                .request(MediaType.APPLICATION_JSON)
                .get();
        assertTrue(resp.getStatus() == 200);
        JsonObject data = resp.readEntity(JsonObject.class);
        assertNotNull(data);
        assertTrue(data.getString("cognome").equals("Ammaniti"));
    }

    @Test
    public void create() {
        JsonObjectBuilder ob = Json.createObjectBuilder();
        JsonObject autore = ob.add("nome", "Fabio")
                .add("cognome", "Volo")
                .build();
        
        Response resp = wt.path("autori")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(autore.toString()));
        
        assertTrue(resp.getStatus() == 200);
        JsonObject data = resp.readEntity(JsonObject.class);
        assertNotNull(data);
        assertTrue(data.getString("cognome").equals("Volo"));
    }
}
