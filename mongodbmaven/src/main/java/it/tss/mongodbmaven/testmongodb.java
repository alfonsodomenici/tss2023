/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.tss.mongodbmaven;

import static com.mongodb.client.model.Filters.*;

import com.mongodb.client.FindIterable;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class testmongodb {

    public static void main(String[] args) {
        // Replace the placeholder with your MongoDB deployment's connection string
        String[] nomi = {"qwe", "sdf", "fgh", "xcv", "fgn", "qwd", "cfg", "rtn", "aef", "xdb", "lkj", "oiu", "uyt", "76r", "65r", "hui", "lnn", "oiu", "jpo", "joo"};

        String uri = "mongodb://localhost";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("cinema");
            MongoCollection<Document> collection = database.getCollection("films");
            //Random rand = new Random();
            Document film = new Document("titolo", "NewBlade");
            film.append("actors", asList(
                    new Document("actor", "Jerry"),
                    new Document("actor", "Geremyquiz")));
            film.append("anno", 1987);
            collection.insertOne(film);
            int rnd = (int) Math.random() * 20;
            int rnd2 = (int) Math.random() * rnd * 10;

            int maxnew = 100000;
            System.out.println(new Date().toLocaleString());
            for (int i = 0; i < maxnew; i++) {
                double drnd =  Math.random() * 20;
                
                
                
                double drnd2 = Math.random() * drnd + 10;
                collection.insertOne(new Document().append("titolo", nomi[(int)drnd]).append("anno", 1990+(int)drnd2));

            }
            System.out.println(new Date().toLocaleString());

            Bson listaCampi = Projections.fields(
                    Projections.include("titolo", "anno"),
                    
                    
                    Projections.excludeId());
            FindIterable<Document> filmsfounded = collection.find()
                    .projection(listaCampi)
                    .sort(Sorts.descending("_id"));
            MongoCursor<Document> cursor = filmsfounded.iterator();
            int c=0;
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
                if (c++>50) break;
            }
            Document doc = collection.find(eq("titolo", "Blade")).first();
            if (doc != null) {
                System.out.println("Il titolo e': " + doc.getString("titolo"));
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }
}
