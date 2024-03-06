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
// PostsListDTO is used to return a list of posts
// - this dto is used to return a list of posts in the response body
public class PostsListDTO {
    // totalPosts is used to store the total number of posts
    private long totalPosts;
    // pageNumber is used to store the current page number
    private int pageNumber;
    // pageSize is used to store the number of posts in a page
    private int pageSize;
    // totalPages is used to store the total number of pages
    private int totalPages;
    // isFirst is used to store whether the current page is the first page
    private boolean isFirst;
    // isLast is used to store whether the current page is the last page
    private boolean isLast;
    // posts is used to store the list of posts
    private Collection<PostResponseDTO> posts;
}
