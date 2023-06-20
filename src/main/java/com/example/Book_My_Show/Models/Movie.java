package com.example.Book_My_Show.Models;

import com.example.Book_My_Show.Enums.Genre;
import com.example.Book_My_Show.Enums.Language;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="movies")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(nullable = false)
    private String movieName ;

    private double duration ;

    private double rating ;

    private Date releaseDate ;

    @Enumerated(EnumType.STRING)
    private Genre genre ;

    @Enumerated(EnumType.STRING)
    private Language language ;

//    @OneToMany
//    @JoinColumn
//    private Show show ;

}
