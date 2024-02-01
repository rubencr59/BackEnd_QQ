package com.quillquest.model.DTO;

import com.quillquest.model.Comment;

import java.util.Date;
import java.util.List;

public class PostResponseDTO {

    private Long postID;
    private String title;
    private String content;
    private Date created_date;

    private Long userID;
    private String username;
    private List<Comment> comments;


    // Constructor
    public PostResponseDTO(Long postID, String title, String content, Date created_date, Long userID, String username, List<Comment> comments) {
        this.postID = postID;
        this.title = title;
        this.content = content;
        this.created_date = created_date;
        this.userID = userID;
        this.username = username;
        this.comments = comments;
    }

    // Getters y setters

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getPostID() {
        return postID;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
