package com.quillquest.repository;

import com.quillquest.model.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>{
    Post findById(long id);

    Post save(Post post);

    List<Post> findByUser_UserID(Long userId);

    void deleteById(long id);


    @Query(value = "SELECT * FROM Post ORDER BY RAND() LIMIT ?1", nativeQuery = true)
    List<Post> findRandomPosts(int limit);

    @Query(value= "SELECT p FROM Post p ORDER BY p.created_date DESC")
    List<Post> findPostsOrderByDate();


}
