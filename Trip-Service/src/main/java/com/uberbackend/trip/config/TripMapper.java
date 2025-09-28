package com.uberbackend.trip.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TripMapper {

    @Bean
    public ModelMapper  mapper(){
        return new ModelMapper();
    }
}
