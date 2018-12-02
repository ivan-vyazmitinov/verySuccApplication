package com.succApplication.repositories;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DefaultContextRepository implements ContextRepository{
    private final MongoCollection collection ;

    public DefaultContextRepository() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("succMongoDB");
        collection = database.getCollection("context");
    }

    @Override
    public List getContexts(){
        List<Map> contextList = new LinkedList<>();

        collection.find().into(contextList);
        contextList.forEach(n -> n.remove("_id"));
        return contextList;
    }

}
