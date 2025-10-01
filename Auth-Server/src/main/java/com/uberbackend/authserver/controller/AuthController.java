package com.uberbackend.authserver.controller;

import com.uberbackend.authserver.jwt.JwtUtil;
import com.uberbackend.authserver.model.AuthRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping
    public String home(){
        return "HOme PaGe";
    }

    @PostMapping("/register")
    public String login(@RequestBody AuthRequest request) {
      String ss=  JwtUtil.generateToken(request.getEmail(), "DRIVER");
        return ss;

    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // validate user credentials (hardcoded or DB)
        System.out.println("Login triggers");
        if (username.equals("admin") && password.equals("admin")) {
            return JwtUtil.generateToken(username, "DRIVER");
        }
        throw new RuntimeException("Invalid credentials");
    }


    @GetMapping("/check")
    public String check(@RequestBody String token){
        System.out.println("Token : " + token);
        return  JwtUtil.extractUsername(token);

//        return "This Url /check don't need authentication";
    }

}
