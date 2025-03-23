package com.kt.dto.request;

import lombok.*;

// producer 쪽 DTO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProducerMessageRequest {
    private Long id;
    private String name;
    private String email;
    private String content;  // 메시지 내용 추가!
}
