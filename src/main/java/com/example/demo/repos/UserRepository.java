package com.example.demo.repos;

import com.example.demo.models.Task;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);
    User findByEmail(String email);
    List<User> findAllByOrderByIdAsc();

}
