package com.example.instanttest.api.comment.request;

import lombok.Getter;

@Getter
public class CommentRequestDTO {
    private String content;
    private Long boardId;
}
