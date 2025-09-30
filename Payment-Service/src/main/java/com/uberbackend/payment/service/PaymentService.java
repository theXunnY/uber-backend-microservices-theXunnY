package com.uberbackend.payment.service;

import com.uberbackend.payment.dto.PaymentRequestDto;
import com.uberbackend.payment.dto.PaymentResponseDto;
import com.uberbackend.payment.entity.Payment;
import com.uberbackend.payment.entity.PaymentStatus;
import com.uberbackend.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final PaymentRepository repository;
    private final ModelMapper mapper;


    public PaymentResponseDto createPayment(PaymentRequestDto dto){
        Payment payment = Payment.builder()
                .transactionId(UUID.randomUUID())
                .riderId(dto.getRiderId())
                .tripId(dto.getTripId())
                .driverId(dto.getDriverId())
                .status(PaymentStatus.SUCCESS)
                .amount(dto.getAmount())
                .build();
        Payment savedPayment = repository.save(payment);
        log.info("Payment: {} ",savedPayment);

        return mapper.map(payment, PaymentResponseDto.class);
    }

    public PaymentResponseDto findPayment(long id){

        Payment payment = repository.findById(id).orElseThrow();
        System.out.println(payment);

        return mapper.map(payment, PaymentResponseDto.class);
    }
}
