package com.example.instanttest.api.comment.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class CommentResponseDTO {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private String email;
    private Long boardId;
}
