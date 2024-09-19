package org.example.recette.controller;

import org.example.recette.dto.AccountDTO;
import org.example.recette.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("login")
    public ResponseEntity<Boolean> login(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok(authService.login(accountDTO));
    }

    @PostMapping("register")
    public ResponseEntity<Boolean> register(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok(authService.register(accountDTO));
    }

}
