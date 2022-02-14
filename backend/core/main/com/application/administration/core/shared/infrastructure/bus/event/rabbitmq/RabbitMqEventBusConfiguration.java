package com.application.administration.core.shared.infrastructure.bus.event.rabbitmq;

import com.application.administration.core.shared.infrastructure.bus.event.DomainEventsInformation;
import com.application.administration.core.shared.infrastructure.bus.event.DomainEventSubscribersInformation;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@EnableConfigurationProperties
@Configuration
public class RabbitMqEventBusConfiguration {

    private final DomainEventSubscribersInformation domainEventSubscribersInformation;
    private final DomainEventsInformation domainEventsInformation;
    private final String exchangeName;

    public RabbitMqEventBusConfiguration(
            DomainEventSubscribersInformation domainEventSubscribersInformation,
            DomainEventsInformation domainEventsInformation
    ) {
        this.domainEventSubscribersInformation = domainEventSubscribersInformation;
        this.domainEventsInformation = domainEventsInformation;
        this.exchangeName = "domain_events";
    }

    @Bean
    public CachingConnectionFactory connection() {
        return new CachingConnectionFactory();
    }

    @Bean
    public Declarables declaration() {
        String retryExchangeName = RabbitMqExchangeNameFormatter.retry(exchangeName);
        String deadLetterExchangeName = RabbitMqExchangeNameFormatter.deadLetter(exchangeName);

        var domainEventsExchange = new TopicExchange(exchangeName, true, false);
        var retryDomainEventsExchange = new TopicExchange(retryExchangeName, true, false);
        var deadLetterDomainEventsExchange = new TopicExchange(deadLetterExchangeName, true, false);
        List<Declarable> declarables = new ArrayList<>();
        declarables.add(domainEventsExchange);
        declarables.add(retryDomainEventsExchange);
        declarables.add(deadLetterDomainEventsExchange);

        Collection<Declarable> queuesAndBindings = declareQueuesAndBindings(
                domainEventsExchange,
                retryDomainEventsExchange,
                deadLetterDomainEventsExchange
        ).stream().flatMap(Collection::stream).collect(Collectors.toList());

        declarables.addAll(queuesAndBindings);

        return new Declarables(declarables);
    }

    private Collection<Collection<Declarable>> declareQueuesAndBindings(
            TopicExchange domainEventsExchange,
            TopicExchange retryDomainEventsExchange,
            TopicExchange deadLetterDomainEventsExchange
    ) {
        return domainEventSubscribersInformation.all().stream().map(information -> {
            String queueName = RabbitMqQueueNameFormatter.format(information);
            String retryQueueName = RabbitMqQueueNameFormatter.formatRetry(information);
            String deadLetterQueueName = RabbitMqQueueNameFormatter.formatDeadLetter(information);

            var queue = QueueBuilder.durable(queueName).build();
            var retryQueue = QueueBuilder.durable(retryQueueName).withArguments(
                    retryQueueArguments(domainEventsExchange, queueName)
            ).build();
            var deadLetterQueue = QueueBuilder.durable(deadLetterQueueName).build();

            var fromExchangeSameQueueBinding = BindingBuilder
                    .bind(queue)
                    .to(domainEventsExchange)
                    .with(queueName);

            var fromRetryExchangeSameQueueBinding = BindingBuilder
                    .bind(retryQueue)
                    .to(retryDomainEventsExchange)
                    .with(queueName);

            var fromDeadLetterExchangeSameQueueBinding = BindingBuilder
                    .bind(deadLetterQueue)
                    .to(deadLetterDomainEventsExchange)
                    .with(queueName);

            List<Binding> fromExchangeDomainEventsBindings = information.subscribedEvents().stream().map(
                    domainEventClass -> {
                        String eventName = domainEventsInformation.forClass(domainEventClass);
                        return BindingBuilder
                                .bind(queue)
                                .to(domainEventsExchange)
                                .with(eventName);
                    }).collect(Collectors.toList());

            List<Declarable> queuesAndBindings = new ArrayList<>();
            queuesAndBindings.add(queue);
            queuesAndBindings.add(fromExchangeSameQueueBinding);
            queuesAndBindings.addAll(fromExchangeDomainEventsBindings);

            queuesAndBindings.add(retryQueue);
            queuesAndBindings.add(fromRetryExchangeSameQueueBinding);

            queuesAndBindings.add(deadLetterQueue);
            queuesAndBindings.add(fromDeadLetterExchangeSameQueueBinding);

            return queuesAndBindings;
        }).collect(Collectors.toList());
    }

    private HashMap<String, Object> retryQueueArguments(TopicExchange exchange, String routingKey) {
        var args = new HashMap<String, Object>();
        args.put("x-dead-letter-exchange", exchange.getName());
        args.put("x-dead-letter-routing-key", routingKey);
        args.put("x-message-ttl", 1000);
        return args;
    }
}
