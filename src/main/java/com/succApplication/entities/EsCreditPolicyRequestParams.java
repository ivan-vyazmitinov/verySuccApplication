package com.succApplication.entities;

public class EsCreditPolicyRequestParams {
    private long creditId;
    private long borrowerId;

    public EsCreditPolicyRequestParams(long creditId, long borrowerId) {
        this.creditId = creditId;
        this.borrowerId = borrowerId;
    }

    public long getCreditId() {
        return creditId;
    }

    public long getBorrowerId() {
        return borrowerId;
    }
}
