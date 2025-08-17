package vn.edu.fpt.sblog_authentication_service.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.fpt.sblog_authentication_service.dto.UserCredential;

import java.util.Date;
import java.util.Map;

@RestController
public class AuthenticationController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserCredential credential) {
        if (credential.username().equals("admin") && credential.password().equals("admin")) {
            String token = Jwts.builder()
                    .setSubject("0") //User ID
                    .claim("role", "admin")
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 3600_000)) // 1 hour
                    .signWith(SignatureAlgorithm.HS256, "VHKJMNnbfhbsjkdbVJHVkhbJBKJBsmfnbngygiyguFYVHJbkjnjnsjdnlkfn")
                    .compact();

            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
