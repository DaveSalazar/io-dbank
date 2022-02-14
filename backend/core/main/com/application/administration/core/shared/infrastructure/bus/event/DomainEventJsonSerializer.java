package com.application.administration.core.shared.infrastructure.bus.event;

import com.application.administration.core.shared.domain.Utils;
import com.application.administration.core.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public final class DomainEventJsonSerializer {

    public static String serialize(DomainEvent domainEvent) {
        HashMap<String, Serializable> attributes = domainEvent.toPrimitives();
        attributes.put("id", domainEvent.aggregateId());

        var data = new HashMap<String, Serializable>();
        data.put("id", domainEvent.eventId());
        data.put("type", domainEvent.eventName());
        data.put("occurred_on", domainEvent.occurredOn());
        data.put("attributes", attributes);

        var serialized = new HashMap<String, Serializable>();
        serialized.put("data", data);
        serialized.put("meta", new HashMap<String, Serializable>());

        return Utils.jsonEncode(serialized);
    }

}
