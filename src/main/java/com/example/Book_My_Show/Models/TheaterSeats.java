package com.example.Book_My_Show.Models;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "theaterSeat")
@Data
public class TheaterSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(nullable = false)
    private int SeatNo ;
    private SeatType seatType ;

//    @ManyToOne
//    @JoinColumn
//    private Theater theater ;
}
