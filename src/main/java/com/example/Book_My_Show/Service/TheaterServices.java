package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Dtos.RequestDtos.TheaterEntryDto;
import com.example.Book_My_Show.Dtos.RequestDtos.TheaterSeatsEntryDto;
import com.example.Book_My_Show.Enums.SeatType;
import com.example.Book_My_Show.Models.Theater;
import com.example.Book_My_Show.Models.TheaterSeats;
import com.example.Book_My_Show.Repository.TheaterRepository;
import com.example.Book_My_Show.Transformers.TheaterTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServices {
    @Autowired
    TheaterRepository theaterRepository ;
    public String addTheater(TheaterEntryDto theaterEntryDto) {
        Theater theater = TheaterTransformers.convertDtoToEntity(theaterEntryDto);
        theaterRepository.save(theater);
        return "Theater Added Successfully" ;
    }

    public String addTheaterSeats(TheaterSeatsEntryDto theaterSeatsEntryDto) {
         int columns =theaterSeatsEntryDto.getNoOfSeatsIn1Row() ;

         int noOfClassicSeats = theaterSeatsEntryDto.getNofOfClassicSeats();

         int noOfPremiumSeats = theaterSeatsEntryDto.getNoOfPremiumSeats() ;

         String location = theaterSeatsEntryDto.getLocation() ;

         Theater theater = theaterRepository.findByLocation(location);

        List<TheaterSeats> theaterSeatsList = theater.getTheaterSeatList() ;

        System.out.println("The value of noOfPremium Seats"+noOfPremiumSeats);

        int counter = 1 ;
        int ch = 'A' ;

        for (int count = 1; count<=noOfClassicSeats ;count++){
            String seatNo = counter+"";
            seatNo = seatNo + ch ;

            ch++ ;

            if ((ch-'A') == columns){
                ch='A' ;
                counter++ ;
            }

            TheaterSeats theaterSeat = new TheaterSeats() ;
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setTheater(theater);
            theaterSeat.setSeatType(SeatType.CLASSIC);

            theaterSeatsList.add(theaterSeat);

        }

        for (int count = 1 ; count <=noOfPremiumSeats ; count++){
            String seatNo = counter+"";
            seatNo = seatNo + ch ;
            ch++ ;

            if((ch-'A')==columns){
                ch='A';
                counter++ ;
            }

            TheaterSeats theaterSeats = new TheaterSeats() ;
            theaterSeats.setSeatNo(seatNo);
            theaterSeats.setTheater(theater);
            theaterSeats.setSeatType(SeatType.PREMIUM);

            System.out.println("The SeatNo is "+seatNo);
            theaterSeatsList.add(theaterSeats);
        }
        theaterRepository.save(theater);
        return "Theater Sests have been successfully added";
    }
}