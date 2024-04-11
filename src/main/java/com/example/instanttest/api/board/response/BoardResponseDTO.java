package com.example.instanttest.api.board.response;

import com.example.instanttest.api.comment.response.CommentResponseDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class BoardResponseDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;
    private Boolean deletedYn;
    private String email;
    private List<CommentResponseDTO> comments;
}