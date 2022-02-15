package com.application.administration.core.transaction.application;

import com.application.administration.core.shared.domain.bus.query.Response;

import java.util.List;

public class TransactionsResponse implements Response {
    private final List<TransactionResponse> data;

    public TransactionsResponse(List<TransactionResponse> data) {
        this.data = data;
    }

    public List<TransactionResponse> data() {
        return data;
    }
}
