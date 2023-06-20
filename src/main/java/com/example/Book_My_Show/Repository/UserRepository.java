package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
