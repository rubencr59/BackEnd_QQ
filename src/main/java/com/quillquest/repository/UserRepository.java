package com.quillquest.repository;

import com.quillquest.model.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    User findByUserName(String userName);

    Optional<User> findByEmail(String email);

    User save(User user);


    void deleteById(long id);
}