package com.quillquest.repository;

import com.quillquest.model.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAll();


    List<Comment> findByUser_UserID(Long userId);

    List<Comment> findByPost_PostID(Long postId);

    Comment save(Comment comment);


    void deleteById(Long commentId);

}
