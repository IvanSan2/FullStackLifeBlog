package com.ivansan.blogfinalproject.controller;

import com.ivansan.blogfinalproject.dto.CommentRequestDTO;
import com.ivansan.blogfinalproject.dto.CommentResponseDTO;
import com.ivansan.blogfinalproject.dto.CommentsListDTO;
import com.ivansan.blogfinalproject.service.CommentService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(
        name = "Comment Controller",
        description = "Blog Comments"
)
@SecurityRequirement(name = "Bearer Authentication")
public class CommentController {

    private final CommentService commentService;


    @PostMapping("/posts/{id}/comments")
    public ResponseEntity<CommentResponseDTO> createComment(
            Authentication authentication,
           @PathVariable(name = "id") long postId,
           @Valid @RequestBody CommentRequestDTO dto,
            UriComponentsBuilder uriComponentsBuilder) {
        //1: create comment
        var response = commentService.createComment(postId, dto, authentication);
        //2: create uri for the response
        var uri = uriComponentsBuilder.path("/api/v1/posts/{postId}/comments/{commentId}")
                .buildAndExpand(postId, response.getId())
                .toUri();
        //3: return response with created status code (201)
        return ResponseEntity.created(uri).body(response);
    }

    // Get all comments for a post
    @GetMapping("/posts/{id}/comments")
    public ResponseEntity<CommentsListDTO> getCommentsByPostId(
            @PathVariable(name = "id") long postId,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "DESC") String sortOrder,
            @RequestParam(defaultValue = "createdAt") String sortBy) {
        var response = commentService.getCommentsByPostId(postId, pageNumber, pageSize, sortOrder, sortBy);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/posts/{id}/comments/")
    public ResponseEntity<List<CommentResponseDTO>> getCommentsByPostId(
            @PathVariable(name = "id") long postId) {
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<CommentResponseDTO> updateCommentById(
            Authentication authentication,
            @PathVariable(name = "id") long id,
            @Valid @RequestBody CommentRequestDTO dto) {
        var response = commentService.updateCommentById(id, dto, authentication);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<CommentResponseDTO> deleteCommentById(
            Authentication authentication,
            @PathVariable(name = "id") long id) {
        var response = commentService.deleteCommentById(id, authentication);
        return ResponseEntity.ok(response);
    }

}
