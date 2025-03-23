package com.kt.repository.init;

import com.kt.domain.User;
import com.kt.repository.UserRepository;
import com.kt.util.DummyDataInit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Order(2)
@DummyDataInit
public class UserInitializer implements ApplicationRunner {

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) {
        if (userRepository.count() > 0) {
            log.info("[User]더미 데이터 존재");
            return;
        }

        List<User> userList = new ArrayList<>();

        User user1 = User.builder()
                .name("user1")
                .email("user1@email.com")
                .build();

        User user2 = User.builder()
                .name("user2")
                .email("user2@email.com")
                .build();

        User user3 = User.builder()
                .name("user3")
                .email("user3@email.com")
                .build();

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        userRepository.saveAll(userList);
    }
}
