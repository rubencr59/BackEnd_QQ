package com.quillquest.model.DTO;

public class CommentDTO {

    private String textComment;

    private Long postId;

    public CommentDTO(String textComment, Long postId) {
        this.textComment =    textComment;
        this.postId = postId;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }
}
