package com.example.bus.book.controller;

import com.example.bus.book.entity.Booking;
import com.example.bus.book.entity.User;
import com.example.bus.book.service.BusesAvailableService;
import com.example.bus.book.service.UserService;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final BusesAvailableService busesAvailableService;

    public UserController(UserService userService, BusesAvailableService busesAvailableService) {
        this.userService = userService;
        this.busesAvailableService = busesAvailableService;
    }


    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (OptimisticLockingFailureException e) {
            return ResponseEntity.status(409).body("Conflict: User data was updated by another transaction");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        String response = userService.loginUser(email, password);

        if (response.contains("Error")) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@RequestBody Booking booking) {
        String response = userService.bookTicket(booking);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = busesAvailableService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }







}
