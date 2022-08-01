package com.teste.consumidor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class QueueConsumer {

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload Message message) {

        MessageHeaders headers = message.getHeaders();

        System.out.println("Mensagem: " + new String((byte[]) message.getPayload(), StandardCharsets.UTF_8));
        System.out.println("Propriedade: " +  headers.get("propriedade"));
    }
}
