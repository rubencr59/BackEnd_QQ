package com.quillquest.model.Response;

import java.util.Date;
import java.util.List;

public class PostResponse {
    private long postId;
    private String title;
    private String content;
    private Date createdDate;
    private byte[] imageBlob;
    private UserResponse user;
    private List<CommentResponse> comments;

    public PostResponse() {
    }

    public PostResponse( long postId, String title, String content, Date createdDate, byte[] imageBlob,UserResponse user, List<CommentResponse> comments) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.imageBlob = imageBlob;
        this.user = user;
        this.comments = comments;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public byte[] getImageBlob() {
        return imageBlob;
    }

    public void setImageBlob(byte[] imageBlob) {
        this.imageBlob = imageBlob;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public List<CommentResponse> getComments() {
        return comments;
    }

    public void setComments(List<CommentResponse> comments) {
        this.comments = comments;
    }
}
