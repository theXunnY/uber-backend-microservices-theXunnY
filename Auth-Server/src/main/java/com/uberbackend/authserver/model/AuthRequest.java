package com.uberbackend.authserver.model;

import lombok.Data;

@Data
public class AuthRequest {

   private String name;
    private String licensePlate;
    private String model;
    private String type;
    private String email;
    private String role;
    private String password;

}
