package com.example.bus.book.service;


import com.example.bus.book.entity.Booking;
import com.example.bus.book.entity.User;
import com.example.bus.book.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BookingRepository bookingRepository;

    public UserService(UserRepository userRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;

    }

    @Transactional
    public User registerUser(User user) {
        return userRepository.save(user);
    }


    @Transactional
    public String loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if ( userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            return "Login successful";
        }
        return "Invalid email or password";
    }

    public String bookTicket(Booking booking) {
        bookingRepository.save(booking);
        return "Booking Successful!";
    }
}
