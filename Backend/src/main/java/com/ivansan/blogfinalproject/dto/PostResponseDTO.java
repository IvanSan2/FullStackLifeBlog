package com.ivansan.blogfinalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@Data annotation is used to tell spring to generate getters and setters for all fields
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponseDTO {
    // this class is used to store the data that is sent from the server to the client

    private Long id;
    private String title;
    private String description;
    private String content;
    private String image;
    private String createdAt;
    private String updatedAt;
    private List<CommentResponseDTO> comments;
    private UserResponseDTO user;
}
