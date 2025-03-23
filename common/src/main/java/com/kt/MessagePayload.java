// common 모듈
package com.kt;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessagePayload {
    private Long id;
    private String name;
    private String email;
    private String content;  // 메시지 내용
}
