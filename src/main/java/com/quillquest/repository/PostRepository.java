package com.quillquest.repository;

import com.quillquest.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>{
    Post findById(long id);

    Post save(Post post);

    List<Post> findByUser_UserID(Long userId);

    void deleteById(long id);
}
