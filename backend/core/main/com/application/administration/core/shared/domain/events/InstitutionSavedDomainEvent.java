package com.application.administration.core.shared.domain.events;

import com.application.administration.core.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public final class InstitutionSavedDomainEvent extends DomainEvent {

    private final String name;
    private final String address;
    private final String email;
    private final String mission;
    private final String vision;
    private final String phone;

    public InstitutionSavedDomainEvent(String aggregateId, String name, String address, String email,
                                       String mission, String vision, String phone) {
        super(aggregateId);
        this.name = name;
        this.address = address;
        this.email = email;
        this.mission = mission;
        this.vision = vision;
        this.phone = phone;
    }

    public InstitutionSavedDomainEvent(String aggregateId, String eventId, String occurredOn, String name,
                                       String address, String email, String mission, String vision, String phone) {
        super(aggregateId, eventId, occurredOn);
        this.name = name;
        this.address = address;
        this.email = email;
        this.mission = mission;
        this.vision = vision;
        this.phone = phone;
    }

    public InstitutionSavedDomainEvent() {
        this.name = null;
        this.address = null;
        this.email = null;
        this.mission = null;
        this.vision = null;
        this.phone = null;
    }

    @Override
    public String eventName() {
        return "institution.saved";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {

        var response = new HashMap<String, Serializable>();
        response.put("name", name);
        response.put("address", address);
        response.put("email", email);
        response.put("mission", mission);
        response.put("vision", vision);
        response.put("phone", phone);

        return response;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId,
                                      String occurredOn) {
        return new InstitutionSavedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("name"),
                (String) body.get("address"),
                (String) body.get("email"),
                (String) body.get("mission"),
                (String) body.get("vision"),
                (String) body.get("phone")
        );
    }
}
