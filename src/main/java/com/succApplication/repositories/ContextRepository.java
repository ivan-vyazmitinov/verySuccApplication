package com.succApplication.repositories;

import com.succApplication.model.CreditPolicyMods;
import com.succApplication.model.PolicyContextGroup;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface ContextRepository{
    List<Map<String, Object>> findById(ObjectId id);
    PolicyContextGroup findByMode(String mode);
}
