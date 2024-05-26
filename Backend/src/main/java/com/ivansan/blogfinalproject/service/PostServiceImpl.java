package com.ivansan.blogfinalproject.service;

import com.ivansan.blogfinalproject.dto.PostCreateDTO;
import com.ivansan.blogfinalproject.dto.PostResponseDTO;
import com.ivansan.blogfinalproject.dto.PostsListDTO;
import com.ivansan.blogfinalproject.entity.Post;
import com.ivansan.blogfinalproject.entity.User;
import com.ivansan.blogfinalproject.error.PaginationException;
import com.ivansan.blogfinalproject.error.ResourceNotFoundException;
import com.ivansan.blogfinalproject.repository.PostRepository;
import com.ivansan.blogfinalproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{


    // postRepository is used to access the database using the Post entity
    private final PostRepository postRepository;
    // modelMapper is used to convert entity to dto
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public PostResponseDTO createPost(PostCreateDTO dto, Authentication authentication) {
        //0: get the current user
        // - authentication is used to get the current user
        User user = userRepository.findByUsernameOrEmailIgnoreCase(authentication.getName(), authentication.getName())
                .orElseThrow(()-> new ResourceNotFoundException("User", "email", authentication.getName()));

        //1: convert dto to entity
        Post post = modelMapper.map(dto, Post.class);
        post.setUser(user);
        //2: save entity to database
        var saved = postRepository.save(post);
        //3: return response dto
        return modelMapper.map(saved, PostResponseDTO.class);
    }

    @Override
    public PostsListDTO getAllPosts(int pageNumber, int pageSize, String sortOrder, String... sortBy) {
        try{
        //1: Pageable is used to tell spring that the result will be paginated
        // - pageNumber is used to tell spring the current page number
        // - pageSize is used to tell spring the number of posts in a page
        // - Sort.by is used to tell spring the sorting order and the sorting field
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortBy);
        var pageable = PageRequest.of(pageNumber, pageSize, sort);

        //2: get all posts from database
        Page<Post> pr = postRepository.findAll(pageable);

            if (pageNumber > pr.getTotalPages()) {
                throw new PaginationException(STR."Page Number \{pageNumber} Exceeds totalPages \{pr.getTotalPages()}");
            }

        //3: convert entity to dto
        List<PostResponseDTO> postListDto =
                pr.getContent().stream()
                        .map(p -> modelMapper.map(p, PostResponseDTO.class))
                        .toList();

        //4: return response dto
        return new PostsListDTO(
                pr.getTotalElements(),
                pr.getNumber(),
                pr.getSize(),
                pr.getTotalPages(),
                pr.isFirst(),
                pr.isLast(),
                postListDto
        );}
        catch (IllegalArgumentException e){
            throw new PaginationException(e.getMessage());
        }
    }


    @Override
    public PostResponseDTO getPostById(long id) {
        //1: get post by id from database
        Post post = getPostOrThrow(id);
        //2: return response dto
        return modelMapper.map(post, PostResponseDTO.class);
    }

    @Override
    public PostResponseDTO updatePostById(long id, PostCreateDTO dto) {
        //1: get post by id from database
        Post post = getPostOrThrow(id);
        //2: update post
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setContent(dto.getContent());
        post.setImage(dto.getImage());
        //3: save post to database
        var saved = postRepository.save(post);
        //4: return response dto
        return modelMapper.map(saved, PostResponseDTO.class);
    }

    @Override
    public PostResponseDTO deletePostById(long id) {
        //1: get post by id from database
        Post post = getPostOrThrow(id);
        //2: delete post from database
        postRepository.delete(post);
        //3: return response dto
        return modelMapper.map(post, PostResponseDTO.class);
    }

    @Override
    public Post getPostOrThrow(long id) {
        return postRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Post", "id", String.valueOf(id)));
    }
}
