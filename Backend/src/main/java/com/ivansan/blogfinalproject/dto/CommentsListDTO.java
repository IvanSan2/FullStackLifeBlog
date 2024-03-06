package com.ivansan.blogfinalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentsListDTO {
    private long totalComments;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private boolean isFirst;
    private boolean isLast;
    private Collection<CommentResponseDTO> comments;
}
