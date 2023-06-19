package com.example.Book_My_Show.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "theater")
@Data
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name ;

    private String location ;

     @OneToMany
     @JoinColumn
     private TheaterSeats theaterSeats ;

     @OneToMany
     @JoinColumn
     private Show show ;

}
