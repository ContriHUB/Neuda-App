package com.example.Banking_System.service;

import com.example.Banking_System.model.User;
import com.example.Banking_System.repository.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

/** UserService */
@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> findByUsername(String username) {
    return this.userRepository.findByUsername(username);
  }

  public User save(User user) {
    return this.userRepository.save(user);
  }
}
