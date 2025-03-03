package com.example.bus.book.repository;


import com.example.bus.book.entity.BusesAvailable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusesAvailableRepository extends JpaRepository<BusesAvailable, Long> {
    List<BusesAvailable> findByFromLocationAndToLocationAndTravelDate(String from, String to, String travelDate);
}

