package com.example.Book_My_Show.Models;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theaterSeat")
@Data

public class TheaterSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String seatNo ;

    @Enumerated(EnumType.STRING)
    private SeatType seatType ;

    @ManyToOne
    @JoinColumn
    private Theater theater ;
}
