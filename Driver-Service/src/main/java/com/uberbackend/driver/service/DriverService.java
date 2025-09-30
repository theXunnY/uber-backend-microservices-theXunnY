package com.uberbackend.driver.service;

import com.uberbackend.driver.dto.DriverRequestDto;
import com.uberbackend.driver.dto.DriverResponseDto;
import com.uberbackend.driver.model.Driver;
import com.uberbackend.driver.model.Status;
import com.uberbackend.driver.model.Vehicle;
import com.uberbackend.driver.repsoitory.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;
    private final ModelMapper mapper;

    public DriverResponseDto createDriver(DriverRequestDto dto){

        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate(dto.getLicensePlate());
        vehicle.setType(dto.getType());
        vehicle.setModel(dto.getModel());

       Driver driver= mapper.map(dto, Driver.class);
       driver.setCurrentLocation("Earth");
       driver.setStatus(Status.AVAILABLE);
       driver.setVehicle(vehicle);
       driver.setName(dto.getName());

        System.out.println("driver " + driver);
        System.out.println("dto " + dto);

       Driver saved = driverRepository.save(driver);

       DriverResponseDto response= mapper.map(saved, DriverResponseDto.class);
       response.setModel(vehicle.getModel());
       response.setType(vehicle.getType());
       response.setName(saved.getName());
       response.setLicensePlate(vehicle.getLicensePlate());
       return  response;
    }

    public DriverResponseDto findDriver(Long id){
        Driver driver = driverRepository.findById(id).orElseThrow();

        DriverResponseDto response = mapper.map(driver, DriverResponseDto.class);
        response.setLicensePlate(driver.getVehicle().getLicensePlate());
        response.setType(driver.getVehicle().getType());
        response.setModel(driver.getVehicle().getModel());
        return response;
    }

}
