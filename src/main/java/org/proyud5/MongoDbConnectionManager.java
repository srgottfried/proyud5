package org.proyud5;

import com.mongodb.MongoClient;
import org.bson.Document;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MongoDbConnectionManager {

    private MongoClient connection = null;

    public MongoDbConnectionManager() {

        connection = getConnectionWithPropertiesDta();
    }

    public MongoDbConnectionManager(String host, int port) {

        connection = new MongoClient(host, port);
    }

    private MongoClient getConnectionWithPropertiesDta() {

        try (InputStream input = new FileInputStream("mongodbconfig.properties")) {

            Properties prop = new Properties();
            prop.load(input);

            String host = prop.getProperty("host");
            int port = Integer.parseInt(prop.getProperty("port"));
            connection = new MongoClient(host, port);

            return new MongoClient(host, port);

        } catch (IOException ex) {
            System.out.printf("Error al cargar la configuración de MongoDB: %s\n", ex);
            return null;
        }
    }

    public void close() {

        if (connection != null) {

            connection.close();
        }
    }

    public MongoClient getConnection() {

        return connection;
    }


    public static void main(String[] args) {

        MongoDbConnectionManager manager = new MongoDbConnectionManager();

        manager.getConnection()
                .getDatabase("Frutas")
                .getCollection("Manzanas")
                .insertOne(
                        new Document()
                                .append("roja", "roja")
                );

        System.out.println(manager.getConnection()
                .getDatabase("Frutas")
                .getCollection("Manzanas")
                .countDocuments());

        manager.close();
    }
}