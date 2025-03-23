package com.kt.service;

import com.kt.MessagePayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(String topic, Object message) {
        log.info("sending message: {} to topic: {}", message.toString(), topic);
        kafkaTemplate.send(topic, message);
    }
}