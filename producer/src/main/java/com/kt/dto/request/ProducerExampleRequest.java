package com.kt.dto.request;

import com.kt.domain.User;

public record ProducerExampleRequest(
        Long id,
        String name,
        String email
) {

    public static ProducerExampleRequest from(User user) {
        return new ProducerExampleRequest(user.getId(), user.getName(), user.getEmail());
    }
}
