package com.quillquest.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long userID;

    public String userName;

    public String email;

    public String password;

    public User( String userName,  String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    public Long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
