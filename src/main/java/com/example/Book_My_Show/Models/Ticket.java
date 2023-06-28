package com.example.Book_My_Show.Models;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

@Entity
@Table(name="tickets")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private int totalTicketsPrice ;

    private String bookedSeats ;

    @CreationTimestamp
    private Date bookedAt ;

    @ManyToOne
    @JoinColumn
    private Show show ;

    @ManyToOne
    @JoinColumn
    private User user ;

}
