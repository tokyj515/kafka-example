package com.kt.service;

import com.kt.MessagePayload;
import com.kt.domain.User;
import com.kt.dto.request.ProducerExampleRequest;
import com.kt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProducerService {

    private final KafkaProducer kafkaProducer;
    private final UserRepository userRepository;

    public void sendMessage(Long userId, String message) {

        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));

        MessagePayload payload = MessagePayload.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .content(message)
                .build();
        kafkaProducer.send("test-message", payload);

//        kafkaProducer.send("test-message", ProducerExampleRequest.from(user));

    }
}
