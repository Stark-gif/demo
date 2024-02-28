package com.demo.controller;

import com.demo.payload.PostDto;
import com.demo.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        PostDto post = postService.createPost(postDto);
        return new ResponseEntity<>(post,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);
       return new ResponseEntity<>("Post is deleted for given id",HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable long id,@RequestBody PostDto postDto){
        PostDto dto = postService.updatePost(id, postDto);
return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("/{id}")
public PostDto viewPostById(@PathVariable long id){
        PostDto dto = postService.viewPostById(id);
        return dto;
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> viewAllPost(){
        List<PostDto> postDtos = postService.viewAllPost();
        return new ResponseEntity<>(postDtos,HttpStatus.OK);

    }

}
