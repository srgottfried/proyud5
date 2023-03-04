package org.proyud5.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MongoDbConnection {

    private static MongoDbConnection instance;

    private MongoClient connection;

    private String dbName;

    private MongoDbConnection() {

        connection = getConnection();
    }

    public static synchronized MongoDbConnection getInstance() {

        if (instance == null) {

            instance = new MongoDbConnection();
        }

        return instance;
    }

    private MongoClient getConnection() {

        try (InputStream input = new FileInputStream("mongodbconfig.properties")) {

            Properties prop = new Properties();
            prop.load(input);

            String host = prop.getProperty("host");
            int port = Integer.parseInt(prop.getProperty("port"));
            connection = new MongoClient(host, port);

            dbName = prop.getProperty("dbname");

            return new MongoClient(host, port);

        } catch (IOException ex) {

            System.out.printf("Error al cargar la configuración de MongoDB: %s\n", ex);

            return null;
        }
    }

    public static void close() {

        if (instance != null) {
            try {

                instance.connection.close();

            } catch (Exception e) {

                System.out.printf("Error al cerrar la conexión: %s\n", e);
            }
        }
    }

    public MongoDatabase getDatabase() {

        return connection.getDatabase(dbName);
    }

}