package com.quillquest.repository;

import com.quillquest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

        User findByID(long id);

        User findByUsername(String username);

        User findByEmail(String email);

        User save(User user);


        void deleteByID(long id);
}
