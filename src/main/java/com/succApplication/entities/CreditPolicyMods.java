package com.succApplication.entities;

public enum CreditPolicyMods {
    MAIN_POLICY("main-policy"),
    PRELIMINARY_POLICY("preliminary-policy");

    private String geg;

    CreditPolicyMods(String geg) {
        this.geg = geg;
    }

    public String getGeg() {
        return geg;
    }
}
