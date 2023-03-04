package org.proyud5.database;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.proyud5.parser.PojoToDocument;

import java.util.List;


public class MongoDbCollectionPersistenceManager {

    private final MongoCollection<Document> collection;

    public MongoCollection<Document> getCollection() {

        return collection;
    }

    public MongoDbCollectionPersistenceManager(String collectionName) {

        collection = MongoDbConnection
                .getInstance()
                .getDatabase()
                .getCollection(collectionName);
    }

    public void save(Object object) {

        collection
                .insertOne(PojoToDocument.parse(object));
    }

    public void save(List<Object> objects) {

        collection
                .insertMany(PojoToDocument.parse(objects));
    }
}
