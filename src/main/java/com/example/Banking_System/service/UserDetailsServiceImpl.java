package com.example.Banking_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/** UserDetailsServiceImpl */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private UserService userService;

  @Autowired
  public UserDetailsServiceImpl(final UserService userService) {
    this.userService = userService;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return this.userService
        .findByUsername(username)
        .orElseThrow(
            () -> new UsernameNotFoundException("can not find user with username=" + username));
  }
}
