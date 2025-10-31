package com.example.myproject.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "afsdafsdvxcvarwvdasdfsadfasdfdasfasdfsdfasdfe";

    public static String generateToken(String username){
        long expirationTime = 1000*60*60; //1시간(1초 * 60 * 60)

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
