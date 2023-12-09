package com.example.demo.dto;

import jakarta.persistence.Column;

import java.util.Objects;

public class UserDto {

    private String userName;
    private String password;
    private Integer phone;

    public UserDto( String userName, String password, Integer phone) {

        this.userName = userName;
        this.password = password;
        this.phone = phone;
    }

    public UserDto() {
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(userName, userDto.userName) && Objects.equals(password, userDto.password) && Objects.equals(phone, userDto.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, phone);
    }
}
