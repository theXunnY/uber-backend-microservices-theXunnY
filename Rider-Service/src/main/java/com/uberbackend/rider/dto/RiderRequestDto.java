package com.uberbackend.rider.dto;

import com.uberbackend.rider.model.PaymentMethod;
import lombok.Data;

@Data
public class RiderRequestDto {

    private String name;
    private String phone;
    private PaymentMethod paymentMethod;
}
