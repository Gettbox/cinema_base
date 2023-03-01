package com.kata.cinema.base.repositories;

import com.kata.cinema.base.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByEmailContainingIgnoreCase(String email);
}
