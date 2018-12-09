package com.succApplication.repositories;

import com.succApplication.model.ModeSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;


public class DefaultSettingsRepository implements SettingsRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    public ModeSettings findByMode (String mode){
        Query query = Query.query(where("mode").in(mode));
        return mongoTemplate.findOne(query, ModeSettings.class);     //TODO: optional?
    }
}
