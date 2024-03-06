package com.ivansan.blogfinalproject.repository;

import com.ivansan.blogfinalproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> { }
