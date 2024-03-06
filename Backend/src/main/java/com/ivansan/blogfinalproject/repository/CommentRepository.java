package com.ivansan.blogfinalproject.repository;

import com.ivansan.blogfinalproject.entity.Comment;
import com.ivansan.blogfinalproject.entity.Post;
import com.ivansan.blogfinalproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // JPA Query Methods:
    Page<Comment> findByPost(Post post, PageRequest pageable);

    List<Comment> findCommentsByPostId(long postId);

    List<Comment> findCommentsByUser(User user);
}
