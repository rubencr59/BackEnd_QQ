package com.quillquest.controller;

import com.quillquest.model.DTO.PostDTO;
import com.quillquest.model.Post;
import com.quillquest.model.User;
import com.quillquest.service.PostService;
import com.quillquest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quillquest/api/post")
public class PostController {

    public final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createPost(@RequestBody PostDTO postDTO) {
        try {
            Long idPost = postService.createPost(postDTO);
            return ResponseEntity.ok(idPost );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable Long id) {
        try {
            boolean deleted = postService.deletePostById(id);

            if (deleted) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }






}
