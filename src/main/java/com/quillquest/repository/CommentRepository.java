package com.quillquest.repository;

import com.quillquest.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAll();


    List<Comment> findByUser_UserID(Long userId);

    Comment save(Comment comment);


    void deleteById(Long commentId);

}
