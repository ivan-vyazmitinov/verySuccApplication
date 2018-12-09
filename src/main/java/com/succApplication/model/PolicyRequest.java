package com.succApplication.model;

public class PolicyRequest {
    private String kind;
    private PolicyRequestParams params;

    public PolicyRequest(String kind, PolicyRequestParams params) {
        this.kind = kind;
        this.params = params;
    }

    public String getKind() {
        return kind;
    }

    public PolicyRequestParams getParams() {
        return params;
    }
}
