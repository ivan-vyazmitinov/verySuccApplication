package com.succApplication.repositories;

import com.succApplication.entities.Sucker;
import com.mongodb.*;

import java.util.Optional;

public class MongoSuccRepository implements SuccRepository{
    private final MongoClient mongoClient;
    private final DB database;
    private final DBCollection collection ;

    public MongoSuccRepository() {
        mongoClient = new MongoClient("localhost", 27017);
        database = mongoClient.getDB("succMongoDB");
        collection = database.getCollection("suckers");
    }

    @Override
    public Optional<Sucker> findByName(String name) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", name);
        DBCursor cursor = collection.find(searchQuery);

        if (cursor.hasNext()){
            return Optional.of(new Sucker(
                    (String)cursor.one().get("name"),
                    (Boolean)cursor.one().get("isSucc")));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void saveNewSucc(Sucker sucker) {
        DBCollection collection = database.getCollection("suckers");
        BasicDBObject document = new BasicDBObject();
        document.put("name", sucker.getName());
        document.put("isSucc", true);
        collection.insert(document);
    }
}
