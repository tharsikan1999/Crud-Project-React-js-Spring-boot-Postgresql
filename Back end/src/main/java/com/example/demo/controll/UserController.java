package com.example.demo.controll;

import com.example.demo.dto.UserAllDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserUpdateDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping(path = "add")
    public String addUserDetails(@RequestBody UserDto userDto){
         String id=userService.addUserDetails(userDto);
         return id;
    }

    @PutMapping(path = "update")
    public  String updateUserDetails(@RequestBody UserUpdateDto userUpdateDto){
        String updateData = userService.updateUserDetails(userUpdateDto);

        return updateData;
    }

    @DeleteMapping(path = "{userID}")
    public Integer deleteUserDetails(@PathVariable Integer userID){
        Integer deleteId = userService.deleteUserDetails(userID);

        return  deleteId;
    }

    @GetMapping(path = "get")
    public List<UserAllDto> getAllUserdetails(){
        List<UserAllDto> getUsers = userService.getAllUserdetails();
        return getUsers;
    }



}
