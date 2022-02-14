package com.application.administration.core.shared.infrastructure.bus.event.spring;

import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.event.DomainEvent;
import com.application.administration.core.shared.domain.bus.event.EventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Primary
@Service
public class SpringApplicationEventBus implements EventBus {
    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(final List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent event) {
        this.publisher.publishEvent(event);
    }
}
