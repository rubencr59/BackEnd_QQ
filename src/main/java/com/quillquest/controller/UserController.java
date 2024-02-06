package com.quillquest.controller;

import com.quillquest.model.DTO.UserDTO;
import com.quillquest.model.Response.DeleteUserResponse;
import com.quillquest.model.Response.UserResponse;
import com.quillquest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quillquest/api/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserDTO userRequest) {
        try {

            UserResponse newUserResponse = userService.registerUser(userRequest);

            if(newUserResponse != null){
                return new ResponseEntity<>(newUserResponse, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody UserDTO userRequest) {
        try {

            UserResponse loginUser = userService.loginUser(userRequest);

            if(loginUser != null){
                return new ResponseEntity<>(loginUser, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
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
    public ResponseEntity<DeleteUserResponse> deleteUser(@PathVariable Long id) {
        try {



            if(userService.deleteUserById(id)){

                DeleteUserResponse deleteUserResponse = new DeleteUserResponse(true, "Usuario eliminado exitosamente");

                return new ResponseEntity<>(deleteUserResponse, HttpStatus.OK);
            }else{

                DeleteUserResponse deleteUserResponse = new DeleteUserResponse(false, "No ha sido eliminado el usuario");

                return new ResponseEntity<>(deleteUserResponse, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
        return null;
    }




}