package com.application.administration.core.transaction.domain;

import com.application.administration.core.shared.domain.AggregateRoot;
import com.application.administration.core.shared.domain.events.TransactionSavedDomainEvent;

import java.util.Objects;
import java.util.UUID;

public final class Transaction extends AggregateRoot {

    private final TransactionHash hash;
    private final TransactionFrom from;
    private final TransactionTo to;
    private final TransactionQuantity quantity;

    public Transaction(TransactionHash hash, TransactionFrom from, TransactionTo to, TransactionQuantity quantity) {
        this.hash = hash;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
    }

    public static Transaction create(TransactionHash hash, TransactionFrom from, TransactionTo to, TransactionQuantity quantity) {
        var transaction = new Transaction(hash, from, to, quantity);
        transaction.record(new TransactionSavedDomainEvent(UUID.randomUUID().toString(), hash.value(), from.value(), to.value(), quantity.value()));
        return transaction;
    }

    public TransactionHash hash() {
        return hash;
    }

    public TransactionFrom from() {
        return from;
    }

    public TransactionTo to() {
        return to;
    }

    public TransactionQuantity quantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(hash, that.hash)
                && Objects.equals(from, that.from)
                && Objects.equals(to, that.to)
                && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, from, to, quantity);
    }
}
