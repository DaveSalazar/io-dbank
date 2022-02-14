package com.application.administration.core.shared.domain.events;


import com.application.administration.core.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class UserCreatedDomainEvent extends DomainEvent {

    private final String email;

    public UserCreatedDomainEvent() {
        super(null);
        this.email = null;
    }

    public UserCreatedDomainEvent(String aggregateId, String email) {
        super(aggregateId);
        this.email = email;
    }

    public UserCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String email) {
        super(aggregateId, eventId, occurredOn);
        this.email = email;
    }

    public String email() {
        return email;
    }


    @Override
    public String eventName() {
        return "user_created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("email", email);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new UserCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("email")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreatedDomainEvent that = (UserCreatedDomainEvent) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
