package com.quillquest.model.DTO;

import java.util.Date;

public class PostDTO {

    private String title;

    private String content;

    private Date createdDate;

    private Long userId;

    public PostDTO(String title, String content, Date createdDate, Long userId) {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
