package com.uberbackend.payment.dto;

import com.uberbackend.payment.entity.PaymentStatus;
import lombok.Data;

@Data
public class PaymentRequestDto {

    private Long tripId;
    private Long riderId;
    private Long driverId;
    private Double amount;
    private PaymentStatus  status; // PENDING, SUCCESS, FAILED
}
