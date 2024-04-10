package com.example.instanttest.api.comment.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponseDTO {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private String email;
    private Long boardId;

    @Builder
    public CommentResponseDTO(Long id, String content, LocalDateTime createdAt, String email, Long boardId) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.email = email;
        this.boardId = boardId;
    }
}
