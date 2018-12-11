package com.succApplication.model;

public enum CreditPolicyMods {
    MAIN_POLICY("main-policy"),
    PRELIMINARY_POLICY("preliminary-policy");

    private String policyName;

    CreditPolicyMods(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicyName() {
        return policyName;
    }
}
