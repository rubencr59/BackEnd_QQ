package com.quillquest.model.DTO;

public class PostDTO {

    private String title;

    private String content;

    private String image;

    private Long userId;

    public PostDTO(String title, String content, String image, Long userId) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.userId = userId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
