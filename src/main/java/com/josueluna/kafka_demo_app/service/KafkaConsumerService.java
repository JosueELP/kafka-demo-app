package com.josueluna.kafka_demo_app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "topic_example_demo", groupId = "example_group_id")
    public void consume(String message) {
        System.out.println("Message received: " + message);
    }

}
