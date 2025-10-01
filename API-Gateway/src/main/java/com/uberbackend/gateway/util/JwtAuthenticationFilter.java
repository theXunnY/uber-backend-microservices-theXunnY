package com.uberbackend.gateway.util;


import io.jsonwebtoken.Claims;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String path = exchange.getRequest().getPath().toString();
        HttpMethod method = exchange.getRequest().getMethod();

        System.out.println("----------------------------------------------");
        System.out.println("Request Path: " + path);
        System.out.println("Request Method: " + method);

        // Allow preflight requests (OPTIONS) for CORS
        if (HttpMethod.OPTIONS.equals(method)) {
            return chain.filter(exchange);
        }

        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");

        // Allow unauthenticated access to auth endpoints
        if (authHeader == null || path.contains("/api/auth/login")
                || path.contains("/api/auth/register")
                || path.contains("/api/auth/check")) {
            return chain.filter(exchange);
        }

        if (!authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = authHeader.substring(7); // Remove "Bearer "
        Claims claims;
        try {
            claims = JwtUtil.extractClaims(token);
            System.out.println(claims.get("role"));
        } catch (Exception e) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // Extract role from token
        String role = claims.get("role", String.class);

        // Role-based access control
        if (path.startsWith("/driver-service") && !"DRIVER".equals(role)) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }
        if (path.startsWith("/rider-service") && !"USER".equals(role)) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }

        // Continue filter chain if authorized
        return chain.filter(exchange);
    }
}