package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Dtos.RequestDtos.AddShowDto;
import com.example.Book_My_Show.Dtos.RequestDtos.ShowSeatDto;
import com.example.Book_My_Show.Enums.SeatType;
import com.example.Book_My_Show.Exception.MovieNotFound;
import com.example.Book_My_Show.Exception.ShowNotFound;
import com.example.Book_My_Show.Exception.TheaterNotFound;
import com.example.Book_My_Show.Models.*;
import com.example.Book_My_Show.Repository.MovieRepository;
import com.example.Book_My_Show.Repository.ShowRepository;
import com.example.Book_My_Show.Repository.TheaterRepository;
import com.example.Book_My_Show.Transformers.ShowTransformer;
import com.fasterxml.jackson.core.PrettyPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private MovieRepository movieRepository ;
    @Autowired
    private TheaterRepository theaterRepository ;
    @Autowired
    private ShowRepository showRepository ;
    public String addShow(AddShowDto addShowDto) throws TheaterNotFound , MovieNotFound {
        Show show = ShowTransformer.convertDtoTOEntity(addShowDto);
        Optional<Movie> movieOptional = movieRepository.findById(addShowDto.getMovieId()) ;

        if(!movieOptional.isPresent()){
            throw new MovieNotFound("Movie is not found") ;
        }

        Optional<Theater> optionalTheater = theaterRepository.findById(addShowDto.getTheaterId());
        if(!optionalTheater.isPresent()){
            throw new TheaterNotFound("Theater is not found") ;
        }

        Movie movie =  movieOptional.get() ;
        Theater theater = optionalTheater.get() ;

        show.setMovie(movie);
        show.setTheater(theater);

        show = showRepository.save(show) ;

        theater.getShowList().add(show) ;

        theaterRepository.save(theater) ;

        return "Show has been added and showId  is "+show.getId() ;
    }

    public String associateShowSeats(ShowSeatDto showSeatsDto) throws ShowNotFound {
        Optional<Show> optionalShow = showRepository.findById(showSeatsDto.getShowId());
        if(!optionalShow.isPresent()){
            throw new ShowNotFound("Show Id is incorrect") ;
        }
         Show show = optionalShow.get() ;

        Theater theater = show.getTheater();

        List<TheaterSeats> theaterSeatList = new ArrayList<>();
        List<ShowSeat> showSeatList = new ArrayList<>() ;

        for ( TheaterSeats theaterSeat: theaterSeatList){
            ShowSeat showSeat = new ShowSeat() ;

            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if(showSeat.getSeatType().equals(SeatType.CLASSIC))
                showSeat.setPrice(showSeatsDto.getPriceForClassicSeats());
            else
                showSeat.setPrice(showSeatsDto.getPriceForPremiumSeats());

            showSeat.setShow(show);
            showSeat.setAvailable(true);
            showSeat.setFoodAttached(false);

            showSeatList.add(showSeat) ;

        }
        showRepository.save(show);
        return "Show seats has been successfully added" ;
    }

    public String getMovieName(AddShowDto addShowDto) {
        Integer movieId = showRepository.getMostShowedMovie(addShowDto.getShowDate());
        Movie movie = movieRepository.findById(movieId).get() ;

        return movie.getMovieName() ;
    }
}
