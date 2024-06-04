package com.ivansan.blogfinalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponseDTO {
    private Long id;
    private String comment;
    private String createdAt;
    private String updatedAt;
    private UserResponseDTO user;
}
