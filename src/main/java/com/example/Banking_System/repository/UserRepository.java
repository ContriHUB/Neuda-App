package com.example.Banking_System.repository;

import java.util.Optional;

import com.example.Banking_System.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * UserRepository
 */
public interface UserRepository extends MongoRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
