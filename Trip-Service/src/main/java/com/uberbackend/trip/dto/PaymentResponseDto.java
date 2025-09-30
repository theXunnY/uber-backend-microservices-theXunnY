package com.uberbackend.trip.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponseDto {

    private UUID transactionId;
    private String status; // SUCCESS / FAILED
    private Double amount;
}

