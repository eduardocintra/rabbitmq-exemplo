package com.teste.publicador;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${queue.name}")
    private String nomeFila;

    @Value("${queue.routing.key}")
    private String rountingKey;

    @Bean
    public Queue queue() {
        return new Queue(nomeFila, true);
    }

    @Bean
    public DirectExchange exchange() {
        return  new DirectExchange("direct-exchange");
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(exchange()).with(rountingKey);
    }

}
