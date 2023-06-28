package com.example.Book_My_Show.Transformers;

import com.example.Book_My_Show.Dtos.RequestDtos.AddShowDto;
import com.example.Book_My_Show.Models.Show;

public class ShowTransformer {
    public static Show convertDtoTOEntity(AddShowDto addShowDto){
        Show show = Show.builder().time(addShowDto.getShowStartTime()).date(addShowDto.getShowDate()).build();

        return show ;
    }
}
