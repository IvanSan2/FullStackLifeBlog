package com.ivansan.blogfinalproject.controller;

import com.ivansan.blogfinalproject.dto.PostCreateDTO;
import com.ivansan.blogfinalproject.dto.PostResponseDTO;
import com.ivansan.blogfinalproject.dto.PostsListDTO;
import com.ivansan.blogfinalproject.service.PostService;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


// @RestController annotation is used to tell spring that this class is a controller
// - controller is used to handle http request from the client and return http response
@RestController
// @RequestMapping annotation is used to tell spring that this controller will handle http request with /api/v1/posts path
// - this controller will handle http request with /api/v1/posts path
@RequestMapping("/api/v1/posts")
// @RequiredArgsConstructor annotation is used to tell spring to create a constructor with all final fields as parameters
// - this annotation is used to inject dependencies
@RequiredArgsConstructor
@Tag(
        name = "Post Controller",
        description = "Blog Posts"//swagger annotation
) //swagger annotation

@SecurityRequirement(name = "Bearer Authentication")

public class PostController {
    private final PostService postService;

    @Operation(summary = "Get all posts") //swagger annotation
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get all posts", content = @Content (mediaType = "application/json", schema = @Schema(implementation = PostsListDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Posts not found"),
    }) //swagger annotation
    @GetMapping
    //GET /api/v1/posts?pageNo=0&pageSize=10&sortOrder=ASC&sortBy=id
    // - pageNo is used to tell spring the current page number
    // - pageSize is used to tell spring the number of posts in a page
    // - sortOrder is used to tell spring the sorting order
    // - sortBy is used to tell spring the sorting field (it can be multiple fields)
    public ResponseEntity<PostsListDTO> getAllPosts(
            @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "sortOrder", required = false, defaultValue = "ASC") String sortOrder,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String... sortBy
    ){
        //1: get all posts from database
        var res = postService.getAllPosts(pageNo, pageSize, sortOrder, sortBy);
        //2: return response entity with ok status 200
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody @Valid PostCreateDTO dto,
                                                           UriComponentsBuilder uriComponentsBuilder,
                                                      Authentication authentication
    ){


        //1: convert dto to entity
        var res = postService.createPost(dto,authentication);
        //2: build uri for the response
        // - uriComponentsBuilder is used to build uri (uriComponentsBuilder is injected by spring)
        var uri = uriComponentsBuilder.path("/api/v1/posts/{id}").buildAndExpand(res.getId()).toUri();

        //3: return response entity with created status 201
        return ResponseEntity.created(uri).body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> getPostById(@PathVariable long id){
        //1: get post by id from database
        var res = postService.getPostById(id);
        //2: return response entity with ok status 200
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    // PreAuthorize is used to tell spring to check the authorization before executing the method
    // - hasRole('ADMIN') is used to check if the user has role ADMIN
    // this annotation is work only if the @EnableMethodSecurity is enabled in the SecurityConfig
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PostResponseDTO> updatePostById(
            @PathVariable long id,
            @RequestBody @Valid PostCreateDTO dto
    ){
        //1: update post by id
        var res = postService.updatePostById(id, dto);
        //2: return response entity with ok status 200
        return ResponseEntity.ok(res);

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PostResponseDTO> deletePostById(@PathVariable long id){
        //1: delete post by id
        var res = postService.deletePostById(id);
        //2: return response entity with ok status 200
        return ResponseEntity.ok(res);
    }

}
