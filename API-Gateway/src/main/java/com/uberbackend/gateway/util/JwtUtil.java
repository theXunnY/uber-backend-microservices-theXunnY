package com.uberbackend.gateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtil {

    private static final String secretKey="My-Super-man-bat-spider-man-manSecure-Secret-Key";
    private static final Key KEY = Keys.hmacShaKeyFor(secretKey.getBytes());

    public static Claims extractClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public static String extractRole(Claims claims){
        return claims.get("role", String.class);
    }

    public static String extractUsername(Claims claims){
        return claims.get("username", String.class);
    }

}
