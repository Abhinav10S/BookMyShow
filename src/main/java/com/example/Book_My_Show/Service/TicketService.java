package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Dtos.ReaponseDtos.TicketResponseDto;
import com.example.Book_My_Show.Dtos.RequestDtos.TicketRequestDto;
import com.example.Book_My_Show.Exception.NoUserFoundException;
import com.example.Book_My_Show.Exception.ShowNotFound;
import com.example.Book_My_Show.Models.Show;
import com.example.Book_My_Show.Models.ShowSeat;
import com.example.Book_My_Show.Models.Ticket;
import com.example.Book_My_Show.Models.User;
import com.example.Book_My_Show.Repository.ShowRepository;
import com.example.Book_My_Show.Repository.TicketRepository;
import com.example.Book_My_Show.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository  ;
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private ShowRepository showRepository ;
    public TicketResponseDto bookTicket(TicketRequestDto ticketRequestDto) throws NoUserFoundException, ShowNotFound, Exception {
        int userId = ticketRequestDto.getUserId() ;
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()){
            throw new NoUserFoundException("user Id is incorrect") ;
        }

        int showId = ticketRequestDto.getShowId();
        Optional<Show> showOptional = showRepository.findById(showId);
        if(!showOptional.isPresent()){
            throw  new ShowNotFound("Show is not found") ;
        }

        Show show = showOptional.get();
        boolean isValid = validateShowAvailability(show,ticketRequestDto.getRequestedSeats());

        if(isValid == false){
            throw new Exception("Requested Seats entered are not available") ;
        }

        Ticket ticket = new Ticket() ;

        int totalPrice = calculateTotalPrice(show,ticketRequestDto.getRequestedSeats());
        ticket.setTotalTicketsPrice(totalPrice);

        String bookedSeats = convertListToString(ticketRequestDto.getRequestedSeats());
        ticket.setBookedSeats(bookedSeats);
        
        User user = userOptional.get();
        ticket.setUser(user);
        ticket.setShow(show);
        
        ticket = ticketRepository.save(ticket);
        show.getTicketList().add(ticket);
        
        showRepository.save(show);
        
        return createTicketResponseDto(show,ticket);
    }

    private TicketResponseDto createTicketResponseDto(Show show, Ticket ticket) {
        TicketResponseDto ticketResponseDto = TicketResponseDto.builder()
                .bookedSeats(ticket.getBookedSeats())
                .location(show.getTheater().getLocation())
                .theaterName(show.getTheater().getName())
                .movieName(show.getMovie().getMovieName())
                .showDate(show.getDate())
                .showTime(show.getTime())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();

        return ticketResponseDto;
    }

    private String convertListToString(List<String> requestedSeats) {
        String result = "";
        for(String seatNo : requestedSeats){
            result = result + seatNo+", ";
        }
        return result;
    }

    private int calculateTotalPrice(Show show, List<String> requestedSeats) {
        int totalPrice = 0 ;

        List<ShowSeat> showSeatList = new ArrayList<>() ;

        for (ShowSeat showSeat : showSeatList){
            if(requestedSeats.contains(showSeat.getSeatNo())){
                totalPrice = totalPrice + showSeat.getPrice() ;
                showSeat.setAvailable(false);
            }
        }
        return totalPrice ;
    }

    private boolean validateShowAvailability(Show show, List<String> requestedSeats) {
        List<ShowSeat> showSeatList = show.getShowSeatList();

        for(ShowSeat showSeat : showSeatList){
            String seatNo = showSeat.getSeatNo();
            if(requestedSeats.contains(seatNo)){

                if(showSeat.isAvailable()==false)
                    return false;
            }
        }
        return true;
    }
}
