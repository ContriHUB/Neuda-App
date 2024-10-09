package com.example.Banking_System.service;

import com.example.Banking_System.model.User;
import com.example.Banking_System.model.UserCreationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/** UserSignUpService */
@Service
public class UserSignUpService {
  private PasswordEncoder passwordEncoder;
  private UserService userService;

  @Autowired
  public UserSignUpService(final PasswordEncoder passwordEncoder, final UserService userService) {
    this.passwordEncoder = passwordEncoder;
    this.userService = userService;
  }

  public User registerUser(final UserCreationDTO userCreationDTO) {
    User user = new User();
    user.setFirstName(userCreationDTO.getFirstName());
    user.setLastName(userCreationDTO.getLastName());
    user.setUsername(userCreationDTO.getUsername());
    user.setPassword(this.passwordEncoder.encode(userCreationDTO.getPassword()));

    return this.userService.save(user);
  }
}
