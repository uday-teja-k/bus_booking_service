package com.example.bus.book.service;



import com.example.bus.book.entity.EmergencyAlert;
import com.example.bus.book.repository.EmergencyAlertRepository;
import org.springframework.stereotype.Service;

@Service
public class EmergencyEmailService {

    private final EmergencyAlertRepository alertRepository;


    public EmergencyEmailService(EmergencyAlertRepository alertRepository){
        this.alertRepository = alertRepository;

    }

    public String sendEmergencyAlert(String bookingId, String receiverEmail, String message) {
        EmergencyAlert alert = new EmergencyAlert();
        alert.setBookingId(bookingId);
        alert.setReceiverEmail(receiverEmail);
        alert.setMessage(message);
        alert.setStatus("PENDING");
        alertRepository.save(alert);
        return "Email sent successfully!";
    }


}

