package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
