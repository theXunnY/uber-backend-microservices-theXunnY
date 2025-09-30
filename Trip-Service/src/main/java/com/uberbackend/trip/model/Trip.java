package com.uberbackend.trip.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Long riderId;
    @NotNull
    private Long driverId;
    @NotNull
    private String pickupLocation;
    @NotNull
    private String dropLocation;

    @Enumerated(EnumType.STRING)
    private TripStatus status;  // REQUESTED, ASSIGNED, STARTED, COMPLETED
}

