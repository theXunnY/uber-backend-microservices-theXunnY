package com.uberbackend.trip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long riderId;
    private Long driverId;
    private String pickupLocation;
    private String dropLocation;

    @Enumerated(EnumType.STRING)
    private TripStatus status;  // REQUESTED, ASSIGNED, STARTED, COMPLETED
}

