package com.succApplication.repositories;

import com.succApplication.entities.PolicyContextGroup;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.*;

public class DefaultContextRepository implements ContextRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Map<String, Object>> findById (ObjectId id){
        PolicyContextGroup context = mongoTemplate.findById(id, PolicyContextGroup.class);
        return context.getContext();                                                            //TODO: optional
    }
}
