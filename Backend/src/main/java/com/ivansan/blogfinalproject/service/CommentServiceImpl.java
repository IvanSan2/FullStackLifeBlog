package com.ivansan.blogfinalproject.service;

import com.ivansan.blogfinalproject.dto.CommentRequestDTO;
import com.ivansan.blogfinalproject.dto.CommentResponseDTO;
import com.ivansan.blogfinalproject.dto.CommentsListDTO;
import com.ivansan.blogfinalproject.dto.UserResponseDTO;
import com.ivansan.blogfinalproject.entity.Comment;
import com.ivansan.blogfinalproject.entity.User;
import com.ivansan.blogfinalproject.error.AuthenticationException;
import com.ivansan.blogfinalproject.error.PaginationException;
import com.ivansan.blogfinalproject.error.ResourceNotFoundException;
import com.ivansan.blogfinalproject.repository.CommentRepository;
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
public class CommentServiceImpl implements CommentService {

    private final PostService postService;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public CommentResponseDTO createComment(long postId, CommentRequestDTO dto, Authentication authentication) {
        //1: convert dto to entity
        var post = postService.getPostOrThrow(postId);
        User user = userRepository.findByUsernameOrEmailIgnoreCase(authentication.getName(), authentication.getName())
                .orElseThrow(()-> new ResourceNotFoundException("User", "email", authentication.getName()));


        //2: save entity to database
        var comment = modelMapper.map(dto, Comment.class);

        //comment belongs to the Post
        comment.setPost(post);
        //comment belongs to the User
        comment.setUser(user);

        //save the comment
        var saved = commentRepository.save(comment);

        // mapping response dto
        var responseDto =  modelMapper.map(saved, CommentResponseDTO.class);
        // mapping user response dto
        responseDto.setUser(modelMapper.map(user, UserResponseDTO.class));
        //3: return response dto
        return responseDto;
    }

    @Override
    public List<CommentResponseDTO> getCommentsByPostId(long postId) {
        postService.getPostOrThrow(postId);
        return commentRepository.findCommentsByPostId(postId).stream()
                .map(c -> modelMapper.map(c, CommentResponseDTO.class))
                .toList();
    }

    @Override
    public CommentResponseDTO updateCommentById(long id, CommentRequestDTO dto, Authentication authentication) {
        //1: get comment from database
        var comment = getCommentByIdOrThrow(id);
        //check if user is the owner of the comment or admin
        checkIfUserIsOwnerOfComment(comment, authentication);
        //2: convert dto to entity
        var commentBeforeSave = modelMapper.map(dto, Comment.class);
        // set the id, post, and createdAt
        commentBeforeSave.setId(comment.getId());
        commentBeforeSave.setPost(comment.getPost());
        commentBeforeSave.setCreatedAt(comment.getCreatedAt());
        // set the user
        commentBeforeSave.setUser(comment.getUser());
        //3: save the comment
        var saved = commentRepository.save(commentBeforeSave);
        //4: return the response dto
        return modelMapper.map(saved, CommentResponseDTO.class);
    }

    private void checkIfUserIsOwnerOfComment(Comment comment, Authentication authentication) {
        var userFromDb = userRepository.findByUsernameIgnoreCase(authentication.getName())
                .orElseThrow(AuthenticationException::new);
        boolean isAdminOrOwner = userFromDb.getRoles().stream()
                .anyMatch(r -> r.getName().equals("ROLE_ADMIN")) || comment.getUser().getId().equals(userFromDb.getId());
        if (!isAdminOrOwner) {
            throw new AuthenticationException("You are not the owner of the comment");
        }
    }

    @Override
    public CommentResponseDTO deleteCommentById(long id, Authentication authentication) {
        //1: get comment from database
        var comment = getCommentByIdOrThrow(id);
        //check if user is the owner of the comment or admin
        checkIfUserIsOwnerOfComment(comment, authentication);
        //2: delete the comment
        commentRepository.delete(comment);
        //3: return the response dto
        return modelMapper.map(comment, CommentResponseDTO.class);
    }


    @Override
    public CommentsListDTO getCommentsByPostId(
            long postId,
            int pageNumber,
            int pageSize,
            String sortOrder,
            String... sortBy) {
        try {
            //1: get post from database
            var post = postService.getPostOrThrow(postId);
            //2: get all comments from database
            var pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));
            Page<Comment> pr = commentRepository.findByPost(post, pageable);
            if (pageNumber > pr.getTotalPages()) {
                throw new PaginationException(STR."Page Number \{pageNumber} Exceeds totalPages \{pr.getTotalPages()}");
            }
            //3: convert entity to dto
            var commentListDto = pr.getContent().stream()
                    .map(c -> modelMapper.map(c, CommentResponseDTO.class))
                    .toList();
            //4: return response dto
            return new CommentsListDTO(
                    pr.getTotalElements(),
                    pr.getNumber(),
                    pr.getSize(),
                    pr.getTotalPages(),
                    pr.isFirst(),
                    pr.isLast(),
                    commentListDto
            );
        }
        catch (PaginationException e){
            throw new PaginationException(e.getMessage());
        }
    }

    public Comment getCommentByIdOrThrow(long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(
                ResourceNotFoundException.newInstance("Comment", "id", String.valueOf(commentId)
                )
        );
    }


}
