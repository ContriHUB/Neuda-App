package com.example.Banking_System.controller;

import com.example.Banking_System.model.User;
import com.example.Banking_System.model.UserCreationDTO;
import com.example.Banking_System.model.UserInfoDTO;
import com.example.Banking_System.service.UserSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SignInSignUpController {

  @Autowired private UserSignUpService userSignUpService;

  @GetMapping("/signin")
  public ModelAndView signin() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("signin.html");
    return modelAndView;
  }

  @GetMapping("/signup")
  public ModelAndView signup() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("signup.html");
    return modelAndView;
  }

  @PostMapping("/signup")
  public UserInfoDTO signupNewUser(@RequestBody UserCreationDTO userCreationDTO) {
    User user = this.userSignUpService.registerUser(userCreationDTO);
    return UserInfoDTO.fromUser(user);
  }
}
