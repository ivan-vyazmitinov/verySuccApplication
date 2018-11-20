package com.succApplication.repositories;

import com.succApplication.entities.Sucker;
//import com.mongodb.*;

public class MongoSuccRepository implements SuccRepository{
//    private final MongoClient mongoClient = new MongoClient("localhost", 27017);
//    private final DB database = mongoClient.getDB("succMongoDB");
//    private final DBCollection collection = database.getCollection("suckers");

    @Override
    public Sucker findByName(String name) {
//        BasicDBObject searchQuery = new BasicDBObject();
//        searchQuery.put("name", name);
//        DBCursor cursor = collection.find(searchQuery);
//
//
//        if (cursor.hasNext()){
//            return new Sucker(
//                    (String)cursor.one().get("name"),
//                    (Boolean)cursor.one().get("isSucc"));
//        } else {
//            return null;
//        }
        return null;
    }

    @Override
    public void saveNewSucc(Sucker sucker) {
//        DBCollection collection = database.getCollection("suckers");
//        BasicDBObject document = new BasicDBObject();
//        document.put("name", sucker.getName());
//        document.put("isSucc", true);
//        collection.insert(document);
    }
}
