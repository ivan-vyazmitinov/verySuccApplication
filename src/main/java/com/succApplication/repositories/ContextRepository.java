package com.succApplication.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;

public interface ContextRepository{
    List<Map<String, Object>> getContexts(ObjectId templateId, String mode);
}
