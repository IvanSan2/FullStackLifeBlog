package com.ivansan.blogfinalproject.service;

import com.ivansan.blogfinalproject.dto.PostCreateDTO;
import com.ivansan.blogfinalproject.dto.PostResponseDTO;
import com.ivansan.blogfinalproject.dto.PostsListDTO;
import com.ivansan.blogfinalproject.entity.Post;
import org.springframework.security.core.Authentication;

// PostService is used to handle business logic
public interface PostService {
    PostResponseDTO createPost(PostCreateDTO dto, Authentication authentication);

    PostsListDTO getAllPosts(int pageNumber, int pageSize, String sortOrder, String... sortBy);

    PostResponseDTO getPostById(long id);

    PostResponseDTO updatePostById(long id, PostCreateDTO dto);

    PostResponseDTO deletePostById(long id);


    Post getPostOrThrow(long id);
}
