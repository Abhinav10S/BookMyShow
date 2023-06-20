package com.example.Book_My_Show.Dtos.ReaponseDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class UserResponseDto {

        private String name;
        private int age;
        private String mobNo;


        private String statusCode;
        private String statusMessage;
}
