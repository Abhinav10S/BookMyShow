package com.example.Book_My_Show.Transformers;

import com.example.Book_My_Show.Dtos.ReaponseDtos.UserResponseDto;
import com.example.Book_My_Show.Dtos.RequestDtos.AddUserDto;
import com.example.Book_My_Show.Models.User;

public class UserTransformer {
    public static User convertDtoToEntity(AddUserDto userDto){

        User userObj = User.builder().age(userDto.getAge()).email(userDto.getEmailId()).mobileNumber(userDto.getMobNo())
                .name(userDto.getName()).build();
        return userObj;
    }

    public static UserResponseDto convertEntityToDto(User user){

        UserResponseDto userResponseDto = UserResponseDto.builder().age(user.getAge()).name(user.getName())
                .mobNo(user.getMobileNumber()).build();
        return userResponseDto;
    }
}
