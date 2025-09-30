package com.uberbackend.payment.controller;

import com.uberbackend.payment.dto.PaymentRequestDto;
import com.uberbackend.payment.dto.PaymentResponseDto;
import com.uberbackend.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment")
@Slf4j
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    ResponseEntity<PaymentResponseDto> makePayment(@RequestBody PaymentRequestDto dto){
        log.info("Payment DTO revived: {}",dto );

        PaymentResponseDto response = service.createPayment(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("/{id}")
    ResponseEntity<PaymentResponseDto> findPayment(@PathVariable long id){
        PaymentResponseDto response = service.findPayment(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
