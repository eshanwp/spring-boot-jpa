package com.springboot.jpa.spring.service;

import com.springboot.jpa.spring.dto.PostDto;
import com.springboot.jpa.spring.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostDto getAllPost() {
//        return postRepository;
        return null;
    }
}
