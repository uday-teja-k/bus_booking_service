package com.example.bus.book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "available_buses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusesAvailable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serviceProviderName;

    @Column(nullable = false)
    private String busType;

    @Column(nullable = false)
    private double busRating;

    @Column(nullable = false)
    private String fromLocation;

    @Column(nullable = false)
    private String toLocation;

    @Column(nullable = false)
    private String departureTime;

    @Column(nullable = false)
    private String arrivalTime;

    @Column(nullable = false)
    private double ticketPrice;

    @Column(nullable = false)
    private int availableSeats;

    @Column(nullable = false)
    private String travelDate; // Assuming date is stored as String

}

