package com.example.demo.service;

import com.example.demo.dto.UserAllDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserUpdateDto;

import java.util.List;

public interface UserService {

  public   String addUserDetails(UserDto userDto);

  public   String updateUserDetails(UserUpdateDto userUpdateDto);


  Integer deleteUserDetails(Integer userID);

  List<UserAllDto> getAllUserdetails();
}
