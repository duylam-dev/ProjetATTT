package com.it4015.team13.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it4015.team13.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
