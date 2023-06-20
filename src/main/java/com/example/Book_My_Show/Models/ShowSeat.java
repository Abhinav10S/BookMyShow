package com.example.Book_My_Show.Models;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "showSeats")
@Data
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showSeatId ;

    private int seatNo ;

    private int price ;

    private SeatType typeOfSeat ;

    private boolean isAvailable ;

    private boolean isFoodAttached ;

//    @ManyToOne
//    @JoinColumn
//    private Ticket ticket ;
//
//    @OneToMany
//    @JoinColumn
//    private Show show ;
}
