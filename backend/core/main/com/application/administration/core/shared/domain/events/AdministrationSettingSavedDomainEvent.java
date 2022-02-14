package com.application.administration.core.shared.domain.events;

import com.application.administration.core.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public final class AdministrationSettingSavedDomainEvent extends DomainEvent {

    private final String institutionId;
    private final String name;
    private final String description;
    private final String value;

    public AdministrationSettingSavedDomainEvent(String aggregateId, String institutionId, String name, String description,
                                                 String value) {
        super(aggregateId);
        this.institutionId = institutionId;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public AdministrationSettingSavedDomainEvent(String aggregateId, String eventId, String occurredOn,
                                                 String institutionId, String name, String description, String value) {
        super(aggregateId, eventId, occurredOn);
        this.institutionId = institutionId;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public AdministrationSettingSavedDomainEvent() {
        this.institutionId = null;
        this.name = null;
        this.description = null;
        this.value = null;
    }

    @Override
    public String eventName() {
        return "setting.saved";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        var response = new HashMap<String, Serializable>();
        response.put("institutionId", name);
        response.put("name", name);
        response.put("description", description);
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
                (String) body.get("institutionId"),
                (String) body.get("name"),
                (String) body.get("description"),
                (String) body.get("value")
        );
    }
}
