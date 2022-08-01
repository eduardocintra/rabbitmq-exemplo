package com.teste.publicador;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class PublicadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublicadorApplication.class, args);
    }

}
