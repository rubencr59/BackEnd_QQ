package com.quillquest.service;

import com.quillquest.model.Comment;
import com.quillquest.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    //Obtener todos los comentarios
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    //Obtener comentario por id de post
    public List<Comment> getCommentsByPost(Long postId) {
        return commentRepository.findByPost_PostID(postId);
    }


    //Obtener comentario por id de usuario
    public List<Comment> getCommentsByUser(Long userId) {
        return commentRepository.findByUser_UserID(userId);
    }

    //Guardar nuevo comentario
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }


    //Eliminar un comentario
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

}
