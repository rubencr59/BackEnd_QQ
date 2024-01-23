package com.quillquest.controller;

import com.quillquest.model.UserRegistrationRequest;
import com.quillquest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest userRequest) {
        // UserRegistrationRequest es una clase que defines para representar los datos enviados desde el frontend

        try {
            userService.registerUser(userRequest);
            return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar el usuario: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public void loginUser() {
    }

    @PostMapping("/logout")
    public void logoutUser() {
    }


    @GetMapping("/{id}")
    public void getUser() {
    }




}
