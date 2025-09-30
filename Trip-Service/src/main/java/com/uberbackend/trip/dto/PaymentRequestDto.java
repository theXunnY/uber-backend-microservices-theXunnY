package com.uberbackend.trip.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequestDto {

    private Long tripId;
    private Long riderId;
    private Long driverId;
    private Double amount;
    private PaymentStatus  status;
}

