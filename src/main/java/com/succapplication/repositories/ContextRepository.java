package com.succapplication.repositories;

import com.succapplication.model.PolicyContextGroup;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface ContextRepository{
    List<Map<String, Object>> findById(ObjectId id);
    List<PolicyContextGroup> findByMode(String mode);
}
