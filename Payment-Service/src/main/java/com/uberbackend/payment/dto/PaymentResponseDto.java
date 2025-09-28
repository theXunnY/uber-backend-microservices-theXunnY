package com.uberbackend.payment.dto;

import lombok.Data;

@Data
public class PaymentResponseDto {
    private Long id;
    private Long tripId;
    private Long riderId;
    private Long driverId;
    private Double amount;
    private String status; // PENDING, SUCCESS, FAILED
}
