// common 모듈
package com.kt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder  // 👈 이거 추가!
public class MessagePayload {
    private Long id;
    private String name;
    private String email;
    private String content;  // 메시지 내용
}
