package com.uberbackend.driver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverRequestDto {
    private String name;
    private String licensePlate;
    private String model;
    private String type;
}

