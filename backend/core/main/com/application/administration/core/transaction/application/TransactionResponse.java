package com.application.administration.core.transaction.application;

import com.application.administration.core.shared.domain.bus.query.Response;
import com.application.administration.core.transaction.domain.Transaction;

public class TransactionResponse implements Response {

    private final String hash;
    private final String from;
    private final String to;
    private final Integer quantity;

    public TransactionResponse(String hash, String from, String to, Integer quantity) {
        this.hash = hash;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
    }

    public static TransactionResponse fromAggregate(Transaction aggregate) {
        return new TransactionResponse(
                aggregate.hash().value(),
                aggregate.from().value(),
                aggregate.to().value(),
                aggregate.quantity().value()
        );
    }

    public String hash() {
        return hash;
    }

    public String from() {
        return from;
    }

    public String to() {
        return to;
    }

    public Integer quantity() {
        return quantity;
    }
}
