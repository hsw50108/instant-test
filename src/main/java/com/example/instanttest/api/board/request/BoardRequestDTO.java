package com.example.instanttest.api.board.request;

import lombok.*;

@Getter
@Setter
@Builder
public class BoardRequestDTO {
    private String title;
    private String content;
}