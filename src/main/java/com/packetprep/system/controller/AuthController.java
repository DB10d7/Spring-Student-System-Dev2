package com.packetprep.system.controller;

import com.packetprep.system.dto.AuthenticationResponse;
import com.packetprep.system.dto.LoginRequest;
import com.packetprep.system.dto.RefreshTokenRequest;
import com.packetprep.system.dto.RegisterRequest;
import com.packetprep.system.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successful",
                HttpStatus.OK);
    }
    @PostMapping("/signupAdmin")
    public ResponseEntity<String> signupAdmin(@RequestBody RegisterRequest registerRequest) {
        authService.signupAdmin(registerRequest);
        return new ResponseEntity<>("User Registration Successful",
                HttpStatus.OK);
    }
    @PutMapping("/update/{username}")
    public ResponseEntity<String> update(@RequestBody RegisterRequest registerRequest, @PathVariable String username) {
        authService.update(registerRequest, username);
        return new ResponseEntity<>("User Update Successful",
                HttpStatus.OK);
    }
    @DeleteMapping("/delete/id")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        authService.deleteById(id);
        return new ResponseEntity<>("User Successfully Deleted",
                HttpStatus.OK);
    }
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<String> delete(@PathVariable String username) {
        authService.delete(username);
        return new ResponseEntity<>("User Successfully Deleted",
                HttpStatus.OK);
    }
    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", HttpStatus.OK);
    }
    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }
}
