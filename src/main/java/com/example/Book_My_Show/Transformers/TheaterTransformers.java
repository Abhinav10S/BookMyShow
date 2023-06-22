package com.example.Book_My_Show.Transformers;

import com.example.Book_My_Show.Dtos.RequestDtos.TheaterEntryDto;
import com.example.Book_My_Show.Models.Theater;

public class TheaterTransformers {
    public static Theater convertDtoToEntity (TheaterEntryDto theaterEntryDto){
        Theater  theater = Theater.builder().location(theaterEntryDto.getLocation()).name(theaterEntryDto.getName()).build();
        return theater  ;
    }
}
