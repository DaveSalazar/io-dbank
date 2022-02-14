package com.application.administration.core.shared.infrastructure.bus.event;

import com.application.administration.core.shared.infrastructure.bus.event.rabbitmq.RabbitMqEventBus;
import com.application.administration.core.shared.infrastructure.bus.event.rabbitmq.RabbitMqPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientRabbitMqEventBusConfiguration {
    private final RabbitMqPublisher publisher;

    public ClientRabbitMqEventBusConfiguration(
        RabbitMqPublisher publisher
    ) {
        this.publisher         = publisher;
    }

    @Bean
    public RabbitMqEventBus clientRabbitMqEventBus() {
        return new RabbitMqEventBus(publisher);
    }
}
