package com.gmail.stalexandr.repository;

import com.gmail.stalexandr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail (String userEmail);
    boolean existsByEmail(String email);
}
