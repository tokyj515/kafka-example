package com.kt.service;

import com.kt.MessagePayload;
import com.kt.MessageRepository;
import com.kt.domain.Message;
import com.kt.dto.response.ConsumerExampleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaConsumer {

    private final MessageRepository messageRepository;

    @KafkaListener(topics = "test-message", groupId = "consumer-group")
    public void consumeMessage(@Payload MessagePayload message) {
        log.info("Consumed message: {}", message);

        messageRepository.save(Message.builder()
                .content(message.getContent())
                .build());

        log.info("User Info - id: {}, name: {}, email: {}",
                message.getId(), message.getName(), message.getEmail());
    }
}