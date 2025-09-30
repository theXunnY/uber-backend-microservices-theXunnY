package com.uberbackend.trip.controller;

import com.uberbackend.trip.dto.PaymentResponseDto;
import com.uberbackend.trip.dto.TripRequestDto;
import com.uberbackend.trip.dto.TripResponseDto;
import com.uberbackend.trip.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trip")
public class TripController {

    private final TripService service;

    @PostMapping
    ResponseEntity<TripResponseDto> createTrip(@RequestBody TripRequestDto dto){
        TripResponseDto response = service.createTrip(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    ResponseEntity<List<TripResponseDto>> check(@RequestBody TripRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<TripResponseDto> findTrip(@PathVariable long id){
        TripResponseDto response = service.findTrip(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{tripId}")
    ResponseEntity<PaymentResponseDto> tripCompleted(@PathVariable long tripId){
        PaymentResponseDto responseDto = service.tripCompleted(tripId);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

}
