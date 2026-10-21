package com.example.hospitalappointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospitalappointment.model.Appointment;

public interface AppointmentRepository
        extends JpaRepository<Appointment, Integer> {
}
