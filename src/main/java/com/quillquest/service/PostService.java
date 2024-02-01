package com.quillquest.service;

import com.quillquest.model.DTO.PostDTO;
import com.quillquest.model.DTO.PostResponseDTO;
import com.quillquest.model.Post;
import com.quillquest.model.User;
import com.quillquest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    private UserService userService;


    public PostService(UserService userService) {
        this.userService = userService;
    }

    public Long createPost(PostDTO post) {

        //Si no existe ese usuario que sea null

        if(userService.getUserById(post.getUserId()) == null){
            return null;
        }

        Post newPost = this.postRepository.save(convertToEntity(post));

        if (newPost != null) {
            System.out.println("El post con id " + newPost.getPostID() + " ha sido creado");
            return newPost.getPostID();
        } else {
            return null;
        }
    }

    public boolean deletePostById(Long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);

        if (postOptional.isPresent()) {
            postRepository.deleteById(postId);
            return true;
        } else {
            return false;
        }
    }

    public List<PostResponseDTO> getRandomPostsOrderByDate(int limit) {
        List<Post> randomPosts = postRepository.findPostsOrderByDate();

        List<PostResponseDTO> randomPostsDTO =  new ArrayList<PostResponseDTO>();

        for (Post post: randomPosts) {
            randomPostsDTO.add(convertToDTO(post));
        }



        return randomPostsDTO;
    }

    public List<Post> getPostsByUserId(Long userId) {
        List<Post> posts = postRepository.findByUser_UserID(userId);

        return posts;
    }

    public PostResponseDTO convertToDTO(Post post) {
        PostResponseDTO postResponseDTO = new PostResponseDTO(post.getPostID(), post.getTitle(), post.getContent(), post.getCreated_date(), post.getUser().getUserID(), post.getUser().getUserName(), post.getComments());

        return postResponseDTO;
    }


    public Post convertToEntity(PostDTO postDTO) {

        User user = userService.getUserById(postDTO.getUserId());

        byte[] imageBLOB = ImageService.convertBase64(postDTO.getImage());

        Post post = new Post(postDTO.getTitle(), postDTO.getContent(), imageBLOB, user);

        return post;
    }




}
