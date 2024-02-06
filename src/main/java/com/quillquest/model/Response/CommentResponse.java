package com.quillquest.model.Response;

public class CommentResponse {
    private long commentID;
    private String commentText;
    private UserResponse user;

    public CommentResponse() {
    }

    public CommentResponse(long commentID, String commentText, UserResponse user) {
        this.commentID = commentID;
        this.commentText = commentText;
        this.user = user;
    }

    public long getCommentID() {
        return commentID;
    }

    public void setCommentID(long commentID) {
        this.commentID = commentID;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}

