package com.succapplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "context")
public class PolicyTemplate {
    @Id
    private String id;
    private String name;
    private String mode;
    private List<Map<String, Object>> context;

    public PolicyTemplate(String name, String mode, List<Map<String, Object>> context) {
        this.name = name;
        this.mode = mode;
        this.context = context;
    }

    public List<Map<String, Object>> getContext() {
        return context;
    }

    public String getName() {
        return name;
    }

    public String getMode() {
        return mode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setContext(List<Map<String, Object>> context) {
        this.context = context;
    }
}