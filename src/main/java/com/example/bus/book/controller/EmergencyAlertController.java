package com.example.bus.book.controller;


import com.example.bus.book.entity.EmergencyAlert;
import com.example.bus.book.service.EmergencyEmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emergency-alerts")
public class EmergencyAlertController {

    private final EmergencyEmailService alertService;

    public EmergencyAlertController(EmergencyEmailService alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/send")
    public String sendEmergencyAlert(
            @RequestParam String bookingId,
            @RequestParam String receiverEmail,
            @RequestParam String message) {
        return alertService.sendEmergencyAlert(bookingId, receiverEmail, message);
    }
}
