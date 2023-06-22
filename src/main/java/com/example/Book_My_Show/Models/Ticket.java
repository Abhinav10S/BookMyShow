package com.example.Book_My_Show.Models;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

@Entity
@Table(name="tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private int totalPrice ;

    private Boolean bookedSeats ;

    private Time movieTime ;

    private Date movieDate ;

    private String movieName ;

    private String theaterName ;

//    @OneToMany
//    @JoinColumn
//    private ShowSeat showSeat ;
//
//    @ManyToOne
//    @JoinColumn
//    private User user ;

}
