package com.josueluna.kafka_demo_app.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class KafkaMessageRequestDTO {

    public String message;

}
