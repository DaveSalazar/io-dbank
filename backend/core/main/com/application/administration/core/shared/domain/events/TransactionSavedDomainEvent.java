package com.application.administration.core.shared.domain.events;

import com.application.administration.core.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class TransactionSavedDomainEvent extends DomainEvent {

    private final String hash;
    private final String from;
    private final String to;
    private final Integer quantity;

    public TransactionSavedDomainEvent(String aggregateId, String hash, String from, String to, Integer quantity) {
        super(aggregateId);
        this.hash = hash;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
    }

    public TransactionSavedDomainEvent(String aggregateId, String eventId, String occurredOn, String hash, String from, String to, Integer quantity) {
        super(aggregateId, eventId, occurredOn);
        this.hash = hash;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
    }

    public TransactionSavedDomainEvent() {
        this.hash = null;
        this.from = null;
        this.to = null;
        this.quantity = null;
    }

    @Override
    public String eventName() {
        return "transaction.saved";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        var response = new HashMap<String, Serializable>();
        response.put("hash", hash);
        response.put("from", from);
        response.put("to", to);
        response.put("quantity", quantity);

        return response;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new TransactionSavedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("hash"),
                (String) body.get("from"),
                (String) body.get("to"),
                (Integer) body.get("quantity")
        );
    }
}
