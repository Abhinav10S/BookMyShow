package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.Dtos.RequestDtos.AddShowDto;
import com.example.Book_My_Show.Dtos.RequestDtos.ShowSeatDto;
import com.example.Book_My_Show.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService ;

    @PostMapping("/add")
    public String addShow (@RequestBody AddShowDto addShowDto){
          try{
              return showService.addShow(addShowDto);
          }
          catch (Exception e){
              return e.getMessage();
          }
    }
    @PostMapping("/associate-seats")
    public String associateShowSeats(@RequestBody ShowSeatDto showSeatsDto){
        try{
            return showService.associateShowSeats(showSeatsDto);
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/most-recommended-movie-name")
    public String getMovieName (AddShowDto addShowDto){
        return showService.getMovieName(addShowDto);
    }
}

