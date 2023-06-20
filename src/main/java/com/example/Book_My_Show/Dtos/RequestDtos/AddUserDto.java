package com.example.Book_My_Show.Dtos.RequestDtos;

import lombok.Data;

@Data
public class AddUserDto {
    private String name;
    private Integer age;
    private String mobNo;
    private String emailId;
}
