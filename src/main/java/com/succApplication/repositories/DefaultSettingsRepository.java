package com.succApplication.repositories;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.succApplication.services.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;

public class DefaultSettingsRepository implements SettingsRepository {

    private ConfigurationService configuration;
    private final MongoCollection collection;

    public DefaultSettingsRepository(ConfigurationService configuration) {
        this.configuration = configuration;

        MongoClient mongoClient = new MongoClient(
                configuration.getProperty("mongoDBurl"),
                Integer.parseInt(configuration.getProperty("mongoDBport")));
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
