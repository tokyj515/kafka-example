package com.kt.controller;

import com.kt.global.ApiResponse;
import com.kt.service.ProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "UserController", description = "user 관련 API")
@Slf4j
@RequiredArgsConstructor
@RequestMapping
@RestController
public class ProducerController {

    private final ProducerService producerService;

    @Operation(summary = "producer test", description = "producer test")
    @GetMapping("/produce-message")
    public ApiResponse<String> sendMessage(
            @RequestParam Long userId,
            @RequestParam String message
    ) {
        producerService.sendMessage(userId, message);

        return new ApiResponse<>("성공적으로 발행되었습니다");
    }

    @GetMapping("/test")
    public ApiResponse<String> test(){
        return new ApiResponse<>("쿠버네티스 배포 테스트");
    }
}
