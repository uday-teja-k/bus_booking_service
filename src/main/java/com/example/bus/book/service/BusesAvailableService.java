package com.example.bus.book.service;

import com.example.bus.book.entity.Booking;
import com.example.bus.book.entity.BusesAvailable;
import com.example.bus.book.repository.BusesAvailableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusesAvailableService {

    private final BusesAvailableRepository busRepository;
    private final BookingRepository bookingRepository;

    public BusesAvailableService(BusesAvailableRepository busRepository, BookingRepository bookingRepository) {
        this.busRepository = busRepository;
        this.bookingRepository = bookingRepository;
    }

    public List<BusesAvailable> getAvailableBuses(String from, String to, String date) {
        return busRepository.findByFromLocationAndToLocationAndTravelDate(from, to, date);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}