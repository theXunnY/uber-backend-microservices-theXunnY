package com.uberbackend.trip.dto;

import com.uberbackend.trip.model.TripStatus;
import lombok.Data;


@Data
public class TripResponseDto {

    private Long riderId;
    private Long driverId;
    private String pickupLocation;
    private String dropLocation;

    private TripStatus status;
}
