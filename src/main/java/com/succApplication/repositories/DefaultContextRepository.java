package com.succApplication.repositories;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.succApplication.services.ConfigurationService;

import java.util.*;

import static com.mongodb.client.model.Filters.eq;

public class DefaultContextRepository implements ContextRepository{

    private ConfigurationService configuration;
    private MongoDatabase database;

    public DefaultContextRepository(ConfigurationService configuration) {
        this.configuration = configuration;
        MongoClient mongoClient = new MongoClient(
                this.configuration.getProperty("mongoDBurl"),
                Integer.parseInt(this.configuration.getProperty("mongoDBport")));
        database = mongoClient.getDatabase("succMongoDB");
    }

    @Override
    public List<Map<String, Object>> getContexts(Integer templateId, String mode){
        List<Map<String, Object>> contextList = new LinkedList<>();

        MongoCollection collection = database.getCollection(mode);
        collection.find(eq("template_id", templateId)).into(contextList); //TODO: гавно
        contextList.forEach(n -> n.remove("_id"));
        return ((List<Map<String, Object>>)contextList.get(0).get("context"));
    }
}
