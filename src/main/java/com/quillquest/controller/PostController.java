package com.quillquest.controller;

import com.quillquest.model.DTO.PostDTO;
import com.quillquest.model.Entities.Post;
import com.quillquest.model.Response.PostResponse;
import com.quillquest.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return new ResponseEntity<>(idPost, HttpStatus.CREATED);
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

    @GetMapping("/getPostsRandom/{limit}")
    public ResponseEntity<List<PostResponse>> getPostsRandom(@PathVariable int limit) {
        try {
            List<PostResponse> randomPosts = postService.getRandomPostsOrderByDate(limit);

            return new ResponseEntity<>(randomPosts, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/getPostsByUser/{userId}")
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable Long userId) {
        try {
            List<Post> postsByUser = postService.getPostsByUserId(userId);
            return ResponseEntity.ok(postsByUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
