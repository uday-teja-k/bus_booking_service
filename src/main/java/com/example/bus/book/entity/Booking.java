package com.example.bus.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfSeats;
    private double price;
    private String serviceProviderName;
    private String busType;
    private double busRating;
    private String fromLocation;
    private String toLocation;
    private String departureTime;
    private String arrivalTime;
    private double ticketPrice;
    private String travelDate;

}



