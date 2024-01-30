package com.quillquest.service;

import com.quillquest.model.User;
import com.quillquest.model.DTO.UserDTO;
import com.quillquest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public Long registerUser(UserDTO registerUser) {

        User newUser = convertToEntity(registerUser);


        User savedUser = userRepository.save(newUser);

        if(savedUser != null){
            System.out.println("El usuario con id " + savedUser.getUserID() + " ha sido registrado");

            return savedUser.getUserID();
        }else {
            return null;
        }

    }

    public boolean loginUser(UserDTO loginUser) {

        User searchedUser = userRepository.findByEmail(loginUser.getEmail());

        return searchedUser != null;
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

    private UserDTO convertToDTO(User user) {
        return  new UserDTO(user.getUserName(), user.getEmail(), user.getPassword());
    }

    private User convertToEntity(UserDTO userDTO) {

        return new User(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());
    }
}