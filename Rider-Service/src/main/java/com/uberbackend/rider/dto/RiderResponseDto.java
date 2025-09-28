package com.uberbackend.rider.dto;

import com.uberbackend.rider.model.PaymentMethod;
import lombok.Data;

@Data
public class RiderResponseDto {

    private Long id;
    private String name;
    private String phone;
    private PaymentMethod paymentMethod;
}
