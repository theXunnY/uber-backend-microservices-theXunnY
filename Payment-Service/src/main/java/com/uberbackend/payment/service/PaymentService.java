package com.uberbackend.payment.service;

import com.uberbackend.payment.dto.PaymentRequestDto;
import com.uberbackend.payment.dto.PaymentResponseDto;
import com.uberbackend.payment.entity.Payment;
import com.uberbackend.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final ModelMapper mapper;


    public PaymentResponseDto createPayment(PaymentRequestDto dto){
        Payment payment = Payment.builder()
                .riderId(dto.getRiderId())
                .tripId(dto.getTripId())
                .driverId(dto.getDriverId())
                .status(dto.getStatus())
                .amount(dto.getAmount())
                .build();

        return mapper.map(repository.save(payment), PaymentResponseDto.class);
    }

    public PaymentResponseDto findPayment(long id){

        Payment payment = repository.findById(id).orElseThrow();
        System.out.println(payment);

        return mapper.map(payment, PaymentResponseDto.class);
    }
}
