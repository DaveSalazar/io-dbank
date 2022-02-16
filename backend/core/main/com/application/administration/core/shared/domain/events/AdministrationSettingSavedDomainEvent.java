package com.application.administration.core.shared.domain.events;

import com.application.administration.core.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public final class AdministrationSettingSavedDomainEvent extends DomainEvent {

    private final String name;
    private final String value;

    public AdministrationSettingSavedDomainEvent(String aggregateId, String name, String value) {
        super(aggregateId);
        this.name = name;
        this.value = value;
    }

    public AdministrationSettingSavedDomainEvent(String aggregateId, String eventId, String occurredOn,
                                                 String name,  String value) {
        super(aggregateId, eventId, occurredOn);
        this.name = name;
        this.value = value;
    }

    public AdministrationSettingSavedDomainEvent() {
        this.name = null;
        this.value = null;
    }

    @Override
    public String eventName() {
        return "setting.saved";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        var response = new HashMap<String, Serializable>();
        response.put("name", name);
        response.put("value", value);

        return response;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId,
                                      String occurredOn) {
        return new AdministrationSettingSavedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("name"),
                (String) body.get("value")
        );
    }
}
