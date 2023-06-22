package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.Dtos.ReaponseDtos.UserResponseDto;
import com.example.Book_My_Show.Dtos.RequestDtos.AddUserDto;
import com.example.Book_My_Show.Models.User;
import com.example.Book_My_Show.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService  userService  ;
    @PostMapping("/add")
    public String addUser (@RequestBody AddUserDto user){
        try {
          return   userService.addUser(user);
        }catch (Exception e){
            return e.getMessage();
        }
    }
    @GetMapping("/getOlderUser")
    public UserResponseDto getOldestUser (){
        try{
            UserResponseDto userResponseDto = userService.getOldestUser();

            userResponseDto.setStatusCode("200");
            userResponseDto.setStatusMessage("SUCCESS");
            return userResponseDto;
        }catch (Exception e){
            UserResponseDto responseDto = new UserResponseDto();
            responseDto.setStatusCode("500");
            responseDto.setStatusMessage("Failure");
            return responseDto;
        }
    }

    @GetMapping("/findUserGreaterThanAAge")
    public List<User> getAllUsers (@RequestParam ("age") Integer age){
        return userService.getAllUsersGreaterThan(age);
    }
}
