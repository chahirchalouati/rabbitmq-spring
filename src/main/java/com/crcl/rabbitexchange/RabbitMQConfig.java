package com.crcl.rabbitexchange;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {
    public static final String EXCHANGE_NAME = "direct.crcl.exchange";
    public static final String ROUTING_KEY = "crcl.routingKey";
    private final QueueProperties queueProperties;
    @Bean
    public DirectExchange fanoutExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Declarables queues() {
        List<Queue> queues = queueProperties.getNames().stream()
                .map(Queue::new)
                .peek(queue -> queue.setShouldDeclare(true))
                .toList();
        return new Declarables(queues);
    }

    @Bean
    public Declarables declarables(Declarables queues, DirectExchange fanoutExchange) {
        List<Binding> bindings = queues.getDeclarables().stream()
                .map(queue -> BindingBuilder.bind((Queue) queue).to(fanoutExchange).with(ROUTING_KEY))
                .toList();
        return new Declarables(bindings);
    }
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }
}
