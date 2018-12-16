package com.succApplication.model;

public class PolicyRequestParams {
    private long creditId;
    private long borrowerId;

    public PolicyRequestParams(long creditId, long borrowerId) {
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
