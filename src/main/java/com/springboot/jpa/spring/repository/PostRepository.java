package com.springboot.jpa.spring.repository;

import com.springboot.jpa.spring.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
