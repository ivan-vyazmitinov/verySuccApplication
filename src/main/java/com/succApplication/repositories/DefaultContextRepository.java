package com.succApplication.repositories;

import com.succApplication.model.CreditPolicyMods;
import com.succApplication.model.ModeSettings;
import com.succApplication.model.PolicyContextGroup;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.*;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class DefaultContextRepository implements ContextRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Map<String, Object>> findById (ObjectId id){
        PolicyContextGroup context = mongoTemplate.findById(id, PolicyContextGroup.class);
        return context.getContext();
    }

    @Override
    public List<PolicyContextGroup> findByMode(String mode) {
        Query query = Query.query(where("mode").is(mode).and("active").is(true));
        return mongoTemplate.find(query, PolicyContextGroup.class);
    }
}



