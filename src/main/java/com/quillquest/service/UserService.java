package com.quillquest.service;

import com.quillquest.model.User;
import com.quillquest.model.UserRegistrationRequest;
import com.quillquest.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public boolean registerUser(UserRegistrationRequest registerUser) {

        User newUser = new User(registerUser.getUsername(), registerUser.getEmail(), registerUser.getPassword());


        User savedUser = userRepository.save(newUser);

        if(savedUser != null){
            System.out.println("El usuario con id " + savedUser.getUserID() + " ha sido registrado");

            return true;
        }else {
            return false;
        }

    }

    public boolean loginUser(UserRegistrationRequest loginUser) {

        User searchedUser = userRepository.findByEmail(loginUser.getEmail());

        return searchedUser != null;
    }

    //  public boolean logoutUser() {


    // }


    public boolean deleteUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            userRepository.deleteById(userId);
            return true;
        } else {
            return false;
        }
    }
}