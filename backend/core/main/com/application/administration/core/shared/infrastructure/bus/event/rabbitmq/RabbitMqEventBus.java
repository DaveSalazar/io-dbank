package com.application.administration.core.shared.infrastructure.bus.event.rabbitmq;

import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.event.DomainEvent;
import com.application.administration.core.shared.domain.bus.event.EventBus;
import org.springframework.amqp.AmqpException;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Service
public class RabbitMqEventBus implements EventBus {
    private final RabbitMqPublisher publisher;
    private final String            exchangeName;

    public RabbitMqEventBus(RabbitMqPublisher publisher) {
        this.publisher         = publisher;
        this.exchangeName      = "domain_events";
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        try {
            this.publisher.publish(domainEvent, exchangeName);
        } catch (AmqpException error) {
            error.printStackTrace();
        }
    }
}
