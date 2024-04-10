package com.example.instanttest.service.comment;


import com.example.instanttest.api.comment.request.CommentRequestDTO;
import com.example.instanttest.api.comment.response.CommentResponseDTO;
import com.example.instanttest.config.SecurityUtils;
import com.example.instanttest.domain.board.Board;
import com.example.instanttest.domain.comment.Comment;
import com.example.instanttest.domain.user.User;
import com.example.instanttest.repository.Comment.CommentRepository;
import com.example.instanttest.repository.board.BoardRepository;
import com.example.instanttest.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public CommentResponseDTO addComment(CommentRequestDTO requestDTO) {

        Board board = boardRepository.findById(requestDTO.getBoardId())
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + requestDTO.getBoardId()));

        String userEmail = SecurityUtils.getCurrentUserEmail(); // 현재 사용자의 이메일 가져오기

        User user = userRepository.findByEmail(userEmail);
        if (user == null) {
            throw new RuntimeException("User not found with email: " + userEmail);
        }

//        // 사용자 권한 확인: 게시물 작성자만 댓글을 작성할 수 있도록
//        if (!board.getUser().getEmail().equals(userEmail)) {
//            throw new RuntimeException("You do not have permission to add comment to this board.");
//        }

        Comment comment = Comment.builder()
                .content(requestDTO.getContent())
                .createdAt(LocalDateTime.now())
                .user(user)
                .board(board)
                .deletedYn(false)
                .build();

        Comment savedComment = commentRepository.save(comment);

        // Comment 객체를 DTO로 변환하여 반환
        return convertToDTO(savedComment);
    }

    @Transactional
    public void deleteComment(Long commentId) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + commentId));

        String userEmail = SecurityUtils.getCurrentUserEmail(); // 현재 사용자의 이메일 가져오기

        // 사용자 권한 확인: 댓글 작성자만 삭제할 수 있도록
        if (!comment.getUser().getEmail().equals(userEmail)) {
            throw new RuntimeException("You do not have permission to delete this comment.");
        }

        comment.setDeletedAt(LocalDateTime.now()); // 삭제 시간 설정
        comment.setDeletedYn(true); // 삭제 여부 설정

        // 실제로 데이터를 삭제하는 경우
        // commentRepository.delete(comment);
    }

    @Transactional(readOnly = true)
    public List<CommentResponseDTO> getAllCommentsByBoardId(Long boardId) {
        List<Comment> comments = commentRepository.findAllByBoardId(boardId);
        comments.removeIf(Comment::getDeletedYn);
        System.out.println(comments.stream().map(this::convertToDTO).collect(Collectors.toList()));
        return comments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CommentResponseDTO convertToDTO(Comment comment) {
        return CommentResponseDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .email(comment.getUser().getEmail())
                .boardId(comment.getBoard().getId())
                .build();
    }
}
