package com.example.instanttest.repository.user;

import com.example.instanttest.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Optional<User> findByUserId(String userId);
    User findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findUsersByDeletedYnFalse();
}
