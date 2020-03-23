package by.radzivon.partshop.dto;

import by.radzivon.partshop.entity.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    public User toUser(PasswordEncoder passwordEncoder) {
        return User.builder().username(username)
                .password(passwordEncoder.encode(password))
                .firstName(firstName)
                .lastName(lastName)
                .street(street)
                .city(city)
                .state(state)
                .zip(zip)
                .phoneNumber(phoneNumber)
                .build();
    }
}
