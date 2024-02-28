package com.demo.service;

import com.demo.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    void deletePost(long id);

    PostDto updatePost(long id, PostDto postDto);

    PostDto viewPostById(long id);

    List<PostDto> viewAllPost();
}
