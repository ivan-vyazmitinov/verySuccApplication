package com.succApplication.repositories;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;

public class DefaultContextRepository implements ContextRepository{

    private MongoDatabase database;

    public DefaultContextRepository() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        database = mongoClient.getDatabase("succMongoDB");
    }

    @Override
    public List<Map<String, Object>> getContexts(Integer templateId, String mode){
        List<Map<String, Object>> contextList = new LinkedList<>();
        List<Map<String, Object>> result = new LinkedList<>();

        MongoCollection collection = database.getCollection(mode);
        collection.find(eq("template_id", templateId)).into(contextList); //TODO: гавно
        contextList.forEach(n -> n.remove("_id"));
        result.add(contextList.get(0));
        return result;
    }

}
