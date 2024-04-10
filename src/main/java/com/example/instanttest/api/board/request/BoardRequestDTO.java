package com.example.instanttest.api.board.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardRequestDTO {
    private String title;
    private String content;
}