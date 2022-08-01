package com.teste.publicador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {

    private final QueueSender sender;

    public TesteController(QueueSender sender) {
        this.sender = sender;
    }

    @GetMapping
    public String send() {
        sender.send("Mensagem Teste!");
        return "Ok!";
    }
}
