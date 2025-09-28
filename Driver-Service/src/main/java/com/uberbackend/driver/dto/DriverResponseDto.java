package com.uberbackend.driver.dto;

import com.uberbackend.driver.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverResponseDto {
    private Long id;
    private String name;
    private String licensePlate;
    private String model;
    private String type;
    private Status status;
    private String currentLocation;
}

