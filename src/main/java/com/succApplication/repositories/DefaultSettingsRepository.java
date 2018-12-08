package com.succApplication.repositories;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;

public class DefaultSettingsRepository implements SettingsRepository {

    private final MongoCollection collection;

    public DefaultSettingsRepository() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("succMongoDB");
        collection = database.getCollection("settings");
    }

    @Override
    public Integer getTemplateId(String mode) {
        List<Map<String,Object>> template = new LinkedList<>(); //TODO: гавно
        collection.find(eq("mode",mode)).into(template);
        return (Integer) template.get(0).get("template");
    }
}
