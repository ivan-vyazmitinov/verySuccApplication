package com.succapplication.repository;

import com.succapplication.model.CreditPolicyMods;
import com.succapplication.model.PolicyTemplate;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface ContextRepository {
    List<Map<String, Object>> findById(ObjectId id);
    List<PolicyTemplate> findActiveByMode(CreditPolicyMods mode);
    List<PolicyTemplate> findAll();
    PolicyTemplate findByName(String name);
    void createNewTemplate(PolicyTemplate template);
    void removeTemplate(String name);
    PolicyTemplate updateTemplate(PolicyTemplate policyTemplate);
}
