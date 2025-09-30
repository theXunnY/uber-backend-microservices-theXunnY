package com.uberbackend.driver.controller;

import com.uberbackend.driver.dto.DriverRequestDto;
import com.uberbackend.driver.dto.DriverResponseDto;
import com.uberbackend.driver.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping
    ResponseEntity<DriverResponseDto> saveDriver(@RequestBody DriverRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(driverService.createDriver(dto));
    }

    @GetMapping
    ResponseEntity<List<DriverResponseDto>> findAllDrivers(){
        return ResponseEntity.status(HttpStatus.FOUND).body(driverService.findAllDriver());
    }


    @GetMapping("/{id}")
    ResponseEntity<DriverResponseDto> findDriver(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(driverService.findDriver(id));
    }
}
