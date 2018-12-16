package com.succApplication.model;

public enum CreditPolicyMods {
    MAIN_POLICY("main-policy"),
    PRELIMINARY_POLICY("preliminary-policy");

    private String policyName;  // в данном случае это чистое property так что лучше public final и убрать get

    CreditPolicyMods(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicyName() {
        return policyName;
    }
}
