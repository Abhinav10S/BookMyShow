package com.example.Book_My_Show.Controller;


import com.example.Book_My_Show.Dtos.RequestDtos.TheaterEntryDto;
import com.example.Book_My_Show.Dtos.RequestDtos.TheaterSeatsEntryDto;
import com.example.Book_My_Show.Models.TheaterSeats;
import com.example.Book_My_Show.Service.TheaterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterServices theaterServices ;

    @PostMapping("/add")
    public String addTheater (@RequestBody TheaterEntryDto theaterEntryDto){
       return theaterServices.addTheater(theaterEntryDto);
    }

    @PostMapping("/addTheaterSeats")
    public String addTheaterSeats (@RequestBody TheaterSeatsEntryDto theaterSeatsEntryDto ){
        return theaterServices.addTheaterSeats(theaterSeatsEntryDto);
    }
}
