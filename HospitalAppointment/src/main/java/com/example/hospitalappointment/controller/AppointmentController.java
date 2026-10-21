
package com.example.hospitalappointment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.example.hospitalappointment.model.Appointment;
import com.example.hospitalappointment.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    // Add appointment
    @PostMapping
    public Appointment addAppointment(
            @Valid @RequestBody Appointment appointment) {
        return service.addAppointment(appointment);
    }

    // Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return service.getAllAppointments();
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable int id) {
        return service.getAppointmentById(id);
    }

    // Update appointment
    @PutMapping("/{id}")
    public Appointment updateAppointment(
            @PathVariable int id,
            @Valid @RequestBody Appointment appointment) {
        return service.updateAppointment(id, appointment);
    }

    // Delete appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(
            @PathVariable int id) {
        return ResponseEntity.ok(service.deleteAppointment(id));
    }
}
