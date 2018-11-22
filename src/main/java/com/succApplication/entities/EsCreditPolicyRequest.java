package com.succApplication.entities;

public class EsCreditPolicyRequest {
    String kind;
    EsCreditPolicyRequestParams params;

    public EsCreditPolicyRequest(String kind, EsCreditPolicyRequestParams params) {
        this.kind = kind;
        this.params = params;
    }

    public String getKind() {
        return kind;
    }

    public EsCreditPolicyRequestParams getParams() {
        return params;
    }
}
