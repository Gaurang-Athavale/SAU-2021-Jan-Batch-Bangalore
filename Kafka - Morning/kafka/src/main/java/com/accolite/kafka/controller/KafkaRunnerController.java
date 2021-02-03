package com.accolite.kafka.controller;

import com.accolite.kafka.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaRunnerController {
    private final Producer producer;

    @Autowired
    public KafkaRunnerController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/sendMessage")
    public void messageToTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }
}
