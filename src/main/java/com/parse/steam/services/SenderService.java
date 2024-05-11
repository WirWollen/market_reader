package com.parse.steam.services;

import com.parse.steam.dtos.OutputItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SenderService {
    private final KafkaTemplate<String, OutputItemDto> template;

    @Value(value = "${spring.kafka.producer.topic}")
    private String topic;

    public void send(OutputItemDto item) {
        template.send(topic, item);
    }
}
