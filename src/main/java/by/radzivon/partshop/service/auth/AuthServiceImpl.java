package by.radzivon.partshop.service.auth;

import by.radzivon.partshop.entity.Role;
import by.radzivon.partshop.entity.User;
import by.radzivon.partshop.entity.enums.RoleName;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.message.request.LoginForm;
import by.radzivon.partshop.message.request.SignUpForm;
import by.radzivon.partshop.message.response.JwtResponse;
import by.radzivon.partshop.message.response.ResponseMessage;
import by.radzivon.partshop.repository.RoleRepository;
import by.radzivon.partshop.repository.UserRepository;
import by.radzivon.partshop.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder encoder;

    private JwtProvider jwtProvider;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public ResponseEntity signUp(SignUpForm signUpForm) throws ResourceNotFoundException {

        if (userRepository.existsByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = User.builder()
                .name(signUpForm.getName())
                .username(signUpForm.getUsername())
                .email(signUpForm.getEmail())
                .password(encoder.encode(signUpForm.getPassword()))
                .build();

        Set<String> strRoles = signUpForm.getRole();
        Set<Role> roles = new HashSet<>();
        for (String role : strRoles) {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new ResourceNotFoundException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);

                    break;
                case "pm":
                    Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
                            .orElseThrow(() -> new ResourceNotFoundException("Fail! -> Cause: User Role not find."));
                    roles.add(pmRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new ResourceNotFoundException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
            user.setRoles(roles);
            userRepository.save(user);
        }
        return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);

    }

    @Override
    public ResponseEntity signIn(LoginForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }
}
