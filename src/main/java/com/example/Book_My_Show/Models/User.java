package com.example.Book_My_Show.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(nullable = false)
    private String name ;

    private int age ;
    private String mobileNumber ;

    private String email ;

    @OneToMany
    @JoinColumn
    private Ticket ticket ;
}
