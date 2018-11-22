package com.succApplication.entities;

public class EsCreditPolicyStubbedResponse {
    private String kind;
    private EsCreditPolicyRequestParams params;
    private EsCreditPolicyContext context;

    public EsCreditPolicyStubbedResponse(String kind, EsCreditPolicyRequestParams params, EsCreditPolicyContext context) {
        this.kind = kind;
        this.params = params;
        this.context = context;
    }

    public String getKind() {
        return kind;
    }

    public EsCreditPolicyRequestParams getParams() {
        return params;
    }

    public EsCreditPolicyContext getContext() {
        return context;
    }
}
