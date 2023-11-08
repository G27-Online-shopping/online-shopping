package com.example.onlineshopping.user;

import com.example.onlineshopping.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByEmail(String email);

    Optional<User> deleteUserByEmail(String email);
}
