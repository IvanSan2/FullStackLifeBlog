package com.ivansan.blogfinalproject.service;

import com.ivansan.blogfinalproject.dto.CommentRequestDTO;
import com.ivansan.blogfinalproject.dto.CommentResponseDTO;
import com.ivansan.blogfinalproject.dto.CommentsListDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface CommentService {
    // Create a comment for a post
    CommentResponseDTO createComment(long postId, CommentRequestDTO dto, Authentication authentication);
    // Get all comments for a post
    CommentsListDTO getCommentsByPostId(long postId, int pageNumber, int pageSize, String sortOrder, String... sortBy);
    List<CommentResponseDTO> getCommentsByPostId(long postId);

    CommentResponseDTO updateCommentById(long id, CommentRequestDTO dto, Authentication authentication);

    CommentResponseDTO deleteCommentById(long id, Authentication authentication);

}
