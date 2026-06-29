package com.loopd.controller;

import com.loopd.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("me")
    public ResponseEntity<?> me(Authentication authentication) {
        String userId = authentication.getName();
        return ResponseEntity.ok(authService.findOrCreateUser(userId));
    }
}
