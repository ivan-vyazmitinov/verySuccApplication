package com.succApplication.entities;

public class EsCreditPolicyContext {
    String field;
    String type;

    public EsCreditPolicyContext(String field, String type) {
        this.field = field;
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public String getType() {
        return type;
    }
}
