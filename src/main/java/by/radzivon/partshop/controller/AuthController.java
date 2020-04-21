package by.radzivon.partshop.controller;

import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.message.request.LoginForm;
import by.radzivon.partshop.message.request.SignUpForm;
import by.radzivon.partshop.service.auth.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginForm) {
        log.info("/user/signin " + loginForm.getUsername());
        return authService.signIn(loginForm);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpForm) throws ResourceNotFoundException {
        log.info("/signup  " + signUpForm.getUsername());
        return authService.signUp(signUpForm);
    }
}