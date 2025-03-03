package com.example.bus.book.repository;


import com.example.bus.book.entity.EmergencyAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyAlertRepository extends JpaRepository<EmergencyAlert, Long> {
    
}

