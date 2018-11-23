package com.springboot.jpa.spring.converter;

import com.springboot.jpa.spring.dto.PostDto;
import com.springboot.jpa.spring.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    public static Post dtoToEntity(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setCreatedAt(postDto.getCreatedAt());
        post.setUpdatedAt(postDto.getUpdatedAt());
        return post;
    }

    public static PostDto entityToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setCreatedAt(post.getCreatedAt());
        postDto.setUpdatedAt(post.getUpdatedAt());
        return postDto;
    }

}
