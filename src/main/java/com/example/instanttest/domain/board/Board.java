package com.example.instanttest.domain.board;

import com.example.instanttest.domain.comment.Comment;
import com.example.instanttest.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_tbl_id")
    private Long id;

    @Column(name = "board_title")
    private String title;

    @Column(name = "board_content")
    private String content;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_yn")
    private Boolean deletedYn;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "board_tbl_id") // Comment 테이블에 있는 board_id 외래키로 매핑
    private List<Comment> comments;


    @Builder
    public Board(Long id, String title, String content, LocalDateTime registeredAt, LocalDateTime updatedAt, Boolean deletedYn, LocalDateTime deletedAt, User user, List<Comment> comments) {
        this.id = id; // 롬복이 자동으로 처리
        this.title = title;
        this.content = content;
        this.registeredAt = registeredAt != null ? registeredAt : LocalDateTime.now(); // 등록 시간 설정
        this.updatedAt = updatedAt;
        this.deletedYn = deletedYn;
        this.deletedAt = deletedAt; // 삭제 시간 설정
        if (user == null) {
            throw new IllegalArgumentException("User information is required to create a board.");
        }
        this.user = user;
        this.comments = comments != null ? comments : new ArrayList<>(); // 댓글 리스트 초기화 & null 반환 방지
    }

}
