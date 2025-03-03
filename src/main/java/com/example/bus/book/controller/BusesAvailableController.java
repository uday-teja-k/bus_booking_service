package com.example.bus.book.controller;

import com.example.bus.book.entity.BusesAvailable;
import com.example.bus.book.service.BusesAvailableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusesAvailableController {

    private final BusesAvailableService busService;

    public BusesAvailableController(BusesAvailableService busService) {
        this.busService = busService;
    }

    @GetMapping("/search")
    public List<BusesAvailable> getAvailableBuses(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date) {
        return busService.getAvailableBuses(from, to, date);

    }


}