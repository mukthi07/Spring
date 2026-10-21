package com.example.hospitalappointment.exception;

public class AppointmentNotFoundException
        extends RuntimeException {

    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
