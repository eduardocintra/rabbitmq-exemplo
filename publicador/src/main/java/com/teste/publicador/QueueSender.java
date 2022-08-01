package com.teste.publicador;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {

    @Value("${queue.exchange.name}")
    private String exchangeName;

    @Value("${queue.routing.key}")
    private String rountingKey;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send (String msg) {

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("propriedade", "valor");
        Message message = new Message(msg.getBytes(), messageProperties);
        template.convertAndSend(exchangeName, rountingKey, message);
    }
}


