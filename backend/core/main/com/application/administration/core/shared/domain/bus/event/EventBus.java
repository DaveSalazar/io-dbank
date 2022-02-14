package com.application.administration.core.shared.domain.bus.event;

import java.util.List;

public interface EventBus {
    void publish(final List<DomainEvent> events);
}
