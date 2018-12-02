package com.succApplication.repositories;

import com.mongodb.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DefaultContextRepository implements ContextRepository{
    private final MongoClient mongoClient;
    private final DB database;
    private final DBCollection collection ;

    public DefaultContextRepository() {
        mongoClient = new MongoClient("localhost", 27017);
        database = mongoClient.getDB("succMongoDB");
        collection = database.getCollection("context");
    }

    @Override
    public List getContexts(){
        List<Map> contextList = new LinkedList<>();

        BasicDBObject searchQuery = new BasicDBObject();
        DBCursor cursor = collection.find(searchQuery);


        while (cursor.hasNext()){
            contextList.add((Map) cursor.next());
        }
        contextList.forEach(n -> n.remove("_id"));

        return contextList;
    }

}
