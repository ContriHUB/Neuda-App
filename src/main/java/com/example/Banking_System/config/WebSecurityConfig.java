package com.example.Banking_System.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            (requests) ->
                requests
                    .requestMatchers(
                        "/",
                        "/favicon.ico",
                        "/signup",
                        "/signup.html",
                        "/signin",
                        "/signin.html",
                        "/error",
                        "/css/*",
                        "/js/*",
                        "/img/*")
                    .permitAll()
                    .anyRequest()
                    .authenticated()).csrf().disable()
        .formLogin((form) -> form.loginPage("/signin").permitAll())
        .logout((logout) -> logout.permitAll());

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
