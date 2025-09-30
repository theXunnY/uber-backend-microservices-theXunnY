package com.uberbackend.trip.service;

import com.uberbackend.trip.config.WebClientConfig;
import com.uberbackend.trip.dto.*;
import com.uberbackend.trip.model.Trip;
import com.uberbackend.trip.model.TripStatus;
import com.uberbackend.trip.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TripService {

    private final TripRepository repository;
    private final ModelMapper mapper;
    private final WebClient.Builder clientBuilder;

    public TripResponseDto createTrip(TripRequestDto dto){
        var rider = clientBuilder.build()
                .get()
                .uri("http://RIDER-SERVICE/api/rider/{id}", dto.getRiderId())
                .retrieve()
                .bodyToMono(Object.class)
                .block();
        log.info("Rider: {}", rider);

        if (rider == null){
            throw new RuntimeException("User is not registered please register");
        }

        var driver = clientBuilder.build()
                .get()
                .uri("http://DRIVER-SERVICE/api/driver/{id}", dto.getDriverId())
                .retrieve()
                .bodyToMono(Object.class)
                .block();

        if (driver == null){
            throw new RuntimeException("Driver is not registered please register");
        }

        System.out.println("Driver " + driver);

        Trip trip = Trip.builder()
                        .riderId(dto.getRiderId())
                        .dropLocation(dto.getDropLocation())
                        .pickupLocation(dto.getPickupLocation())
                        .status(TripStatus.STARTED)
                        .driverId(dto.getDriverId())
                        .build();



        System.out.println(trip);
        repository.save(trip);
        return mapper.map(trip, TripResponseDto.class);
    }

    public TripResponseDto findTrip(long id) {
        Trip trip = repository.findById(id).orElseThrow();
        return mapper.map(trip, TripResponseDto.class);
    }

    public List<TripResponseDto> findAll() {
        List<Trip> list = repository.findAll();
        return list.stream().map(t -> mapper.map(t, TripResponseDto.class)).toList();
    }

    public PaymentResponseDto tripCompleted(long tripId) {

        TripResponseDto trip = findTrip(tripId);


        PaymentRequestDto paymentRequest = PaymentRequestDto
                .builder()
                .amount(1000.0)
                .tripId(tripId)
                .riderId(trip.getRiderId())
                .driverId(trip.getDriverId())
                .status(PaymentStatus.SUCCESS)
                .build();



        PaymentResponseDto payment = clientBuilder.build()
                .post()
                .uri("http://PAYMENT-SERVICE/api/payment")
                .bodyValue(paymentRequest)
                .retrieve()
                .bodyToMono(PaymentResponseDto.class)
                .block();
        log.info("Payment Response : {}",payment );

        if (payment == null){
            throw new RuntimeException("Payment failed please try again");
        }


        Trip tripObject = Trip.builder()
                .riderId(trip.getRiderId())
                .dropLocation(trip.getDropLocation())
                .pickupLocation(trip.getPickupLocation())
                .status(TripStatus.COMPLETED)
                .driverId(trip.getDriverId())
                .build();

        repository.save(tripObject);

        return payment;



    }
}
