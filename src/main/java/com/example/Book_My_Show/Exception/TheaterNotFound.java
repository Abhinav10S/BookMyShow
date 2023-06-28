package com.example.Book_My_Show.Exception;

import com.example.Book_My_Show.Dtos.RequestDtos.TheaterEntryDto;

public class TheaterNotFound extends Exception{
    public  TheaterNotFound (String message){
        super(message) ;
    }
}
