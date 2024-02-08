package com.quillquest.service;

import com.quillquest.model.DTO.PostDTO;
import com.quillquest.model.Entities.Post;
import com.quillquest.model.Entities.User;
import com.quillquest.model.Response.CommentResponse;
import com.quillquest.model.Response.PostResponse;
import com.quillquest.model.Response.UserResponse;
import com.quillquest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    private UserService userService;

    private ImageService imageService;


    public PostService(UserService userService, ImageService imageService) {
        this.userService = userService;
        this.imageService = imageService;
    }

    public Long createPost(PostDTO post, MultipartFile image) throws IOException {
        if(userService.getUserById(post.getUserId()) == null){
            return null;
        }

        Post newPost = this.postRepository.save(convertToEntity(post, image));

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

    public List<PostResponse> getRandomPostsOrderByDate(int page, int pageSize, int skip) {
        // Calcular el índice de inicio para la paginación
        int startIndex = (page - 1) * pageSize + skip;

        // Obtener posts aleatorios con paginación y skip
        List<Post> paginatedRandomPosts = postRepository.findRandomPosts(startIndex, pageSize);

        List<PostResponse> paginatedRandomPostsDTO = new ArrayList<>();

        for (Post post : paginatedRandomPosts) {
            paginatedRandomPostsDTO.add(convertToDTO(post));
        }

        return paginatedRandomPostsDTO;
    }



    public List<Post> getPostsByUserId(Long userId) {
        List<Post> posts = postRepository.findByUser_UserID(userId);

        return posts;
    }

    public PostResponse convertToDTO(Post post) {

        UserResponse userResponse = new UserResponse(post.getUser().getUserID(), post.getUser().getUserName());


        List<CommentResponse> commentResponses = new ArrayList<CommentResponse>();

        for (int i = 0; i < post.getComments().size(); i++) {
            CommentResponse commentResponse = new CommentResponse(post.getComments().get(i).getCommentID(), post.getComments().get(i).getCommentText(), new UserResponse(post.getComments().get(i).getUser().getUserID(), post.getComments().get(i).getUser().getUserName()));
            commentResponses.add(commentResponse);
        }

        PostResponse postResponse = new PostResponse(post.getPostID(), post.getTitle(), post.getContent(), post.getCreated_date(),post.getImage(),userResponse,  commentResponses);


        return postResponse;
    }


    public Post convertToEntity(PostDTO postDTO, MultipartFile image) throws IOException {

        User user = userService.getUserById(postDTO.getUserId());

        try{
            byte[] imageBLOB = ImageService.converttoBlob(image);
            Post post = new Post(postDTO.getTitle(), postDTO.getContent(), imageBLOB, postDTO.getCreatedDate(), user);
            return post;

        }catch (IOException e){
            throw new IOException("Error al convertir la imagen a BLOB");
        }


    }




}
