package com.quillquest.controller;

import com.quillquest.model.Entities.Comment;
import com.quillquest.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quillquest/api/comments")
public class CommentController {

    private CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping("/allComments")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = service.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/post/{postID}")
    public ResponseEntity<List<Comment>> getCommentByPostId(@PathVariable long postID) {
        List<Comment> comments = service.getCommentsByPost(postID);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        Comment saveComment = service.saveComment(comment);
        return new ResponseEntity<>(saveComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{commentID}")
    public ResponseEntity<Comment> deleteComment(@PathVariable long commentID) {
        service.deleteComment(commentID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
