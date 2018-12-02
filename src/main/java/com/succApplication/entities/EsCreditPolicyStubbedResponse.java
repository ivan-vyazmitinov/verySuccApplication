package com.succApplication.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EsCreditPolicyStubbedResponse {
    private String kind;
    private EsCreditPolicyRequestParams params;
    private List context;

    public EsCreditPolicyStubbedResponse(String kind, EsCreditPolicyRequestParams params, List context) {
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

    public List getContext() {
        return context;
    }
}
