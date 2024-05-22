package com.ivansan.blogfinalproject.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data annotation is used to tell spring to generate getters and setters for all fields
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCreateDTO {
    // this class is used to store the data that is sent from the client to the server

    @NotNull
    @Size(min = 2, max = 128)
    private String title;
    @NotNull
    @Size(min = 2, max = 512)
    private String description;
    @NotNull
    @Size(min = 2)
    private String content;
    private String image;
}
