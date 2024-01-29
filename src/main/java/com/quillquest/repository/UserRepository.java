package com.quillquest.repository;

import com.quillquest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

        User findById(long id);

        User findByUserName(String userName);

        User findByEmail(String email);

        User save(User user);


        void deleteById(long id);
}
