package com.example.Book_My_Show.Dtos.RequestDtos;

import lombok.Data;

@Data
public class ShowSeatDto {
    private int showId ;
    private int priceForClassicSeats ;
    private int priceForPremiumSeats ;
}
