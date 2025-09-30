package com.uberbackend.driver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;

    @Embedded
    private Vehicle vehicle;
    @Enumerated(EnumType.STRING)
    private Status status;   // AVAILABLE, BUSY, OFFLINE
    private String currentLocation;
}
