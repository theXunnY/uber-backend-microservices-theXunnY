package com.uberbackend.rider.service;

import com.uberbackend.rider.dto.RiderRequestDto;
import com.uberbackend.rider.dto.RiderResponseDto;
import com.uberbackend.rider.model.Rider;
import com.uberbackend.rider.repository.RiderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiderService {

    private final RiderRepository riderRepository;
    private final ModelMapper mapper;



    public RiderResponseDto createRider(RiderRequestDto dto){
        Rider rider = mapper.map(dto, Rider.class);
        System.out.println(dto);
        System.out.println(rider);
        rider.setPaymentMethod(dto.getPaymentMethod());
        riderRepository.save(rider);
        return mapper.map(rider, RiderResponseDto.class);
    }

    public RiderResponseDto findRider(Long id){
        Rider rider = riderRepository.findById(id).orElseThrow();

        return mapper.map(rider, RiderResponseDto.class);
    }

}
