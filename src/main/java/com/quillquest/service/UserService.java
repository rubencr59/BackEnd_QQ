package com.quillquest.service;

import com.quillquest.model.Entities.User;
import com.quillquest.model.DTO.UserDTO;
import com.quillquest.model.Response.UserResponse;
import com.quillquest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public UserResponse registerUser(UserDTO registerUser) {

        User newUser = convertToEntity(registerUser);


        User savedUser = userRepository.save(newUser);

        if(savedUser != null){
            System.out.println("El usuario con id " + savedUser.getUserID() + " ha sido registrado");

            UserResponse userResponse = new UserResponse(savedUser.getUserID(), savedUser.getUserName());

            return userResponse;
        }else {
            return null;
        }

    }

    public UserResponse loginUser(UserDTO loginUser) {

        Optional<User> userOptional = userRepository.findByEmail(loginUser.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (user.getPassword().equals(loginUser.getPassword())) {
                System.out.println("El usuario con id " + user.getUserID() + " ha iniciado sesión");

                UserResponse userResponse = new UserResponse(user.getUserID(), user.getUserName());

                return userResponse;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    public boolean deleteUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            userRepository.deleteById(userId);
            return true;
        } else {
            return false;
        }
    }


    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            return null;
        }
    }

    private UserDTO convertToDTO(User user) {
        return  new UserDTO(user.getUserName(), user.getEmail(), user.getPassword());
    }

    private User convertToEntity(UserDTO userDTO) {

        return new User(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());
    }
}