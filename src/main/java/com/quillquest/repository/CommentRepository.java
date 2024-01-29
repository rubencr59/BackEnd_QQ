package com.quillquest.repository;

import com.quillquest.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findByCommentID(Long commentID);


}
