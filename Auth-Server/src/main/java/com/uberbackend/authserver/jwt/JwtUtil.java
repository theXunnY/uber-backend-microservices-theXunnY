package com.uberbackend.authserver.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String secretKey="My-Super-man-bat-spider-man-manSecure-Secret-Key";
    private static final Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    private static final long expirationMs = 86400000; // 1 day

    public static String generateToken(String username, String role){
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public static String extractUsername(String token){

        // remove possible "Bearer " prefix
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        // remove extra quotes if they exist
        token = token.replace("\"", "").trim();

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public static boolean validateToken(String token) {
        try {
            Claims claims =Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token).getBody();
            return  !claims.getExpiration().before(new Date());
        }catch (Exception e){
            return false;
        }
    }


}
