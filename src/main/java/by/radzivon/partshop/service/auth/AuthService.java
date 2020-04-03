package by.radzivon.partshop.service.auth;

import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.message.request.LoginForm;
import by.radzivon.partshop.message.request.SignUpForm;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity signUp(SignUpForm signUpForm) throws ResourceNotFoundException;

    ResponseEntity signIn(LoginForm loginForm);
}
