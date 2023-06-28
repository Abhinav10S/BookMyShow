package com.example.Book_My_Show.Transformers;

import com.example.Book_My_Show.Dtos.RequestDtos.MovieEntryDto;
import com.example.Book_My_Show.Models.Movie;

public class MovieTransformer {

    public static Movie convertDtoToEntity (MovieEntryDto movieEntryDto){
        Movie movie = Movie.builder().movieName(movieEntryDto.getMovieName()).duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre()).language(movieEntryDto.getLanguage()).rating(movieEntryDto.getRating())
                .releaseDate(movieEntryDto.getReleaseDate()).build() ;

        return movie ;
    }

}
