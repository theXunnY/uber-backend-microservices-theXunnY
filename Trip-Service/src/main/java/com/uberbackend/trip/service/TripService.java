package com.uberbackend.trip.service;

import com.uberbackend.trip.dto.TripRequestDto;
import com.uberbackend.trip.dto.TripResponseDto;
import com.uberbackend.trip.model.Trip;
import com.uberbackend.trip.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository repository;
    private final ModelMapper mapper;

    public TripResponseDto createTrip(TripRequestDto dto){
        Trip trip = Trip.builder()
                        .riderId(dto.getRiderId())
                                .dropLocation(dto.getDropLocation())
                                        .pickupLocation(dto.getPickupLocation())
                                                .status(dto.getStatus())
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
    }
