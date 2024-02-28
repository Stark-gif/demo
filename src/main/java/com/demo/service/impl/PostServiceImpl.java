package com.demo.service.impl;

import com.demo.entity.Post;
import com.demo.exception.ResourceNotFoundException;
import com.demo.payload.PostDto;
import com.demo.repository.PostRepository;
import com.demo.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }


    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
post.setDescription(postDto.getDescription());
post.setContent(postDto.getContent());
        Post savedPost = postRepo.save(post);
        return mapToDto(savedPost);
    }

    @Override
    public void deletePost(long id) {
         postRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post is Not found for given Id:" +id)
        );
        postRepo.deleteById(id);
    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        Post post = postRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post is Not found for given Id:" + id)
        );
post.setTitle(postDto.getTitle());
post.setDescription(postDto.getDescription());
post.setContent(postDto.getContent());
        Post savedPost = postRepo.save(post);

        return mapToDto(savedPost);
    }

    @Override
    public PostDto viewPostById(long id) {
        Post post = postRepo.findById(id).get();
        return mapToDto(post);
    }

    @Override
    public List<PostDto> viewAllPost() {
        List<Post> all = postRepo.findAll();
        return all.stream().map(c->mapToDto(c)).collect(Collectors.toList());
    }

    PostDto mapToDto(Post post) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
    return dto;
    }
}
//    String postId = UUID.randomUUID().toString();
//        post.setId(postId);
//                Post savedPost = postRepo.save(post);
//                return savedPost;
