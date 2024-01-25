package com.quillquest.controller;

import com.quillquest.model.User;
import com.quillquest.model.UserRegistrationRequest;
import com.quillquest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest userRequest) {
        try {
            userService.registerUser(userRequest);
            return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar el usuario: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserRegistrationRequest userRequest) {
        try {
            userService.loginUser(userRequest);
            return new ResponseEntity<>("Usuario logueado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }
        return null;
    }

   /* @PostMapping("/logout")
    public void logoutUser() {
        try {
            //userService.logoutUser();
        } catch (Exception e) {
            System.out.println("Error al cerrar sesión: " + e.getMessage());
        }
    }*/

   /* @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        try {
           // User user = userService.getUser(id);
           // return ResponseEntity.ok(user);
        } catch (Exception e) {
            System.out.println("Error al obtener usuario: " + e.getMessage());
            return ResponseEntity.status(500).build(); // Devolver un código de error 500 en caso de error
        }
    }*/




}
