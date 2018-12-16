package com.succapplication.repository;

import com.succapplication.model.CreditPolicyMods;
import com.succapplication.model.PolicyTemplate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.*;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class DefaultContextRepository implements ContextRepository {

    private MongoTemplate mongoTemplate;

    public DefaultContextRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @SuppressWarnings("ConstantConditions")
    public List<Map<String, Object>> findById(ObjectId id) {
        PolicyTemplate policyTemplate = mongoTemplate.findById(id, PolicyTemplate.class);
        return policyTemplate.getContext();
    }

    @Override
    public List<PolicyTemplate> findActiveByMode(CreditPolicyMods mode) {
        Query query = Query.query(where("mode").is(mode).and("active").is(true));
        return mongoTemplate.find(query, PolicyTemplate.class);
    }

    @Override
    public List<PolicyTemplate> findAll() {
        Query query = new Query();
        return mongoTemplate.find(query, PolicyTemplate.class);
    }

    @Override
    public PolicyTemplate findByName(String name) {
        Query query = Query.query(where("name").is(name));
        return mongoTemplate.findOne(query, PolicyTemplate.class);
    }

    @Override
    public void createNewTemplate(PolicyTemplate template) {
        mongoTemplate.insert(template);
    }

    @Override
    public void removeTemplate(String name) {
        Query query = Query.query(where("name").is(name));
        mongoTemplate.remove(query, PolicyTemplate.class);
    }

    @Override
    public PolicyTemplate updateTemplate(PolicyTemplate policyTemplate) {
        Query query = Query.query(where("name").is(policyTemplate.getName()));
        PolicyTemplate result = mongoTemplate.findOne(query, PolicyTemplate.class);

        if (Optional.ofNullable(result).isPresent()) {
            Update update = new Update();
            update.set("context", policyTemplate.getContext());
            update.set("mode", policyTemplate.getMode());
            return mongoTemplate.findAndModify(query, update,
                    new FindAndModifyOptions().returnNew(true),
                    PolicyTemplate.class);
        } else {
            return null;
        }
    }
}