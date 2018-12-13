package com.succApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Document(collection = "context")
public class PolicyContextGroup {
    @Id
    String id;
    String templateId;
    String mode;
    List<Map<String, Object>> context;

    public List<Map<String, Object>> getContext() {
        return context;
    }

    public Stream getContextInANewWay(){
        return context.stream();
    }
}