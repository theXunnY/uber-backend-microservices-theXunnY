package com.uberbackend.driver.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Vehicle {
    private String licensePlate;
    private String model;
    private String type; // CAR, BIKE, AUTO
}
