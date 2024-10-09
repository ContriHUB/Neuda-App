package com.example.Banking_System.model;

public class UserInfoDTO {
  private String username;
  private String firstName;
  private String lastName;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public static UserInfoDTO fromUser(final User user) {
    UserInfoDTO userInfoDTO = new UserInfoDTO();
    userInfoDTO.setUsername(user.getUsername());
    userInfoDTO.setFirstName(user.getFirstName());
    userInfoDTO.setLastName(user.getLastName());
    return userInfoDTO;
  }
}
