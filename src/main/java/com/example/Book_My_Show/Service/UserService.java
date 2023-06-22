package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Dtos.ReaponseDtos.UserResponseDto;
import com.example.Book_My_Show.Dtos.RequestDtos.AddUserDto;
import com.example.Book_My_Show.Exception.NoUserFoundException;
import com.example.Book_My_Show.Models.User;
import com.example.Book_My_Show.Repository.UserRepository;
import com.example.Book_My_Show.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository ;
    public String addUser(AddUserDto userDto) {
        User user = UserTransformer.convertDtoToEntity(userDto);
        userRepository.save(user);
        return "User has been added successfully ";
    }

    public UserResponseDto getOldestUser() throws NoUserFoundException {
        List<User> users = userRepository.findAll() ;
        int maxAge  = 0 ;
        User userAns = null ;

        for (User user : users){
            if (maxAge < user.getAge()){
                maxAge = user.getAge() ;
                userAns = user ;
            }
        }

        if (userAns == null){
            System.out.println("No user Found");
        }
        UserResponseDto userResponseDto = UserTransformer.convertEntityToDto(userAns);

        return userResponseDto;
    }

    public List<User> getAllUsersGreaterThan(Integer age) {
        List<User> users = userRepository.findUserWithAgeGreater(age);
        return  users ;
    }
}
