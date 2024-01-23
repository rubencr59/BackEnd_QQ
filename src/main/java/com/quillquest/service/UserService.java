package com.quillquest.service;

import com.quillquest.model.User;
import com.quillquest.model.UserRegistrationRequest;
import com.quillquest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


        @Autowired
        private UserRepository userRepository;

        public void registerUser(UserRegistrationRequest registerUser) {

            User newUser = new User(registerUser.getUsername(), registerUser.getEmail(), registerUser.getPassword());


            User savedUser = userRepository.save(newUser);

            System.out.println("El usuario con id " + savedUser.getUserID() + " ha sido registrado");
        }

        public boolean loginUser(User loginUser) {

            User searchedUser = userRepository.findByID(loginUser.getUserID());

            return searchedUser != null;
        }

        public boolean logoutUser() {
                User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                return user != null;
        }

        public void getUser(Long id) {
                User user = userRepository.findByID(id);
                System.out.println("El usuario con id " + user.getUserID() + " es " + user.getUserName());
        }


        public boolean deleteUserById(Long userId) {
            Optional<User> userOptional = userRepository.findById(userId);

            if (userOptional.isPresent()) {
                userRepository.deleteByID(userId);
                return true;
            } else {
                return false;
            }
        }
}
