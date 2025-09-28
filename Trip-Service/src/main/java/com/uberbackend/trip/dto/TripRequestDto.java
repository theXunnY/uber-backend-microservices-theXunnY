package com.uberbackend.trip.dto;

import com.uberbackend.trip.model.TripStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class TripRequestDto {

    private Long riderId;
    private Long driverId;
    private String pickupLocation;
    private String dropLocation;

    private TripStatus status;
}
