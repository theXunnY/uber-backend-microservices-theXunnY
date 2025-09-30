package com.uberbackend.rider.controller;

import com.uberbackend.rider.dto.RiderRequestDto;
import com.uberbackend.rider.dto.RiderResponseDto;
import com.uberbackend.rider.service.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rider")
@RequiredArgsConstructor
public class RiderController {

    private final RiderService riderService;

    @GetMapping("/{id}")
    ResponseEntity<RiderResponseDto> findRider(@PathVariable long id){
        RiderResponseDto dto = riderService.findRider(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(dto);
    }

    @PostMapping
    ResponseEntity<RiderResponseDto> createRider(@RequestBody RiderRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(riderService.createRider(dto));
    }

    @GetMapping
    ResponseEntity<List<RiderResponseDto>> findAllRider(){
        return ResponseEntity.status(HttpStatus.CREATED).body(riderService.findAllRider());
    }

}
