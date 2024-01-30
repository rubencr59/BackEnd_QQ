package com.quillquest.controller;

import com.quillquest.model.DTO.UserDTO;
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
    public ResponseEntity<Long> registerUser(@RequestBody UserDTO userRequest) {
        try {

            Long idUser = userService.registerUser(userRequest);

            if(idUser != null){
                return new ResponseEntity<>(idUser, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDTO userRequest) {
        try {
            if(userService.loginUser(userRequest)){
                return new ResponseEntity<>("Usuario logueado exitosamente", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Error al iniciar sesión", HttpStatus.BAD_REQUEST);
            }
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            if(userService.deleteUserById(id)){
                return new ResponseEntity<>("Usuario eliminado exitosamente", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Error al eliminar el usuario", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
        return null;
    }




}