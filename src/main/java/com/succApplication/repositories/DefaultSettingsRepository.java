package com.succApplication.repositories;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.succApplication.services.ConfigurationService;
import org.bson.types.ObjectId;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;

public class DefaultSettingsRepository {

    private ConfigurationService configuration;

    public DefaultSettingsRepository() {
    }

    public ObjectId getTemplateId(String mode) {
        return null;
    }

}
