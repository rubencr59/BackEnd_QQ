package com.quillquest.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postID")
    public long postID;

    @Column(name = "title")
    public String title;

    @Column(name = "content")
    public String content;

    @Column(name = "created_date")
    public Date  created_date;

    @ManyToOne
    @JoinColumn(name = "userID")
    public User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Comment> comments = new ArrayList<>();

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

    public User getUserPost() {
        return user;
    }

    public void setUserPost(User userPost) {
        this.user = userPost ;
    }
}
