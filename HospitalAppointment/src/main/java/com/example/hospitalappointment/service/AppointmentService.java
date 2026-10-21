package com.example.hospitalappointment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hospitalappointment.model.Appointment;
import com.example.hospitalappointment.repository.AppointmentRepository;
import com.example.hospitalappointment.exception.AppointmentNotFoundException;

@Service
public class AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    // Add appointment
    public Appointment addAppointment(Appointment appointment) {
        return repository.save(appointment);
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    // Get appointment by ID
    public Appointment getAppointmentById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                    new AppointmentNotFoundException(
                        "Appointment not found with ID: " + id));
    }

    // Update appointment
    public Appointment updateAppointment(
            int id, Appointment appointment) {

        Appointment existing = getAppointmentById(id);

        existing.setPatientName(appointment.getPatientName());
        existing.setDoctorName(appointment.getDoctorName());
        existing.setDisease(appointment.getDisease());
        existing.setAppointmentDate(appointment.getAppointmentDate());

        return repository.save(existing);
    }

    // Delete appointment
    public String deleteAppointment(int id) {
        Appointment appointment = getAppointmentById(id);
        repository.delete(appointment);

        return "Appointment deleted successfully";
    }
}
