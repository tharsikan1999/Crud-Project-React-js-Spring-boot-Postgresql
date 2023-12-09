package com.example.demo.service;

import com.example.demo.dto.UserAllDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserUpdateDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.userrepo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Transactional
    @Override
    public String addUserDetails(UserDto userDto) {
        UserEntity userEntity = new UserEntity(
                userDto.getUserName(),userDto.getPassword(),userDto.getPhone()
        );
        userRepo.save(userEntity);

        String userName = userEntity.getUserName();
        return userName;

    }

    @Transactional
    @Override
    public String updateUserDetails(UserUpdateDto userUpdateDto) {
      Optional<UserEntity> option = userRepo.findByUserId(userUpdateDto.getUserId());
      UserEntity userentity = option.get();
      userentity.setUserId(userUpdateDto.getUserId());
      userentity.setUserName(userUpdateDto.getUserName());
      userentity.setPassword(userUpdateDto.getPassword());
      userentity.setPhone(userUpdateDto.getPhone());
      userRepo.save(userentity);
      return userentity.getUserName();
    }

    @Transactional
    @Override
    public Integer deleteUserDetails(Integer userID) {
        userRepo.deleteById(userID);
        return userID;
    }

    @Override
    public List<UserAllDto> getAllUserdetails() {
        List<UserEntity> allUsersEntity = userRepo.findAll();
        List<UserAllDto> userAllDtoList = new ArrayList<>();
        for (UserEntity a:allUsersEntity){
            UserAllDto userAllDto = new UserAllDto(
              a.getUserId(),a.getUserName(),a.getPassword(),a.getPhone()
            );

            userAllDtoList.add(userAllDto);
        }
        return userAllDtoList;
    }


}
