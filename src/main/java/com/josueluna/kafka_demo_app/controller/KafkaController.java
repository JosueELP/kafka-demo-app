package com.josueluna.kafka_demo_app.controller;

import com.josueluna.kafka_demo_app.dto.KafkaMessageRequestDTO;
import com.josueluna.kafka_demo_app.service.KafkaProducerService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private static final Logger log = LoggerFactory.getLogger(KafkaController.class);
    private final KafkaProducerService kafkaProducerService;

    public KafkaController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping(value = "/send", consumes = "application/json", produces = "application/json")
    public String sendKafkaMessage(@Validated @RequestBody KafkaMessageRequestDTO request) {
        kafkaProducerService.sendMessage(request.message);
        log.info("KAFKA MESSAGE: {} - SENT", request.message);
        return "MESSAGE SENT";
    }
}
