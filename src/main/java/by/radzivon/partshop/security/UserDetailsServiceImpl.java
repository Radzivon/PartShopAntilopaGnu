package by.radzivon.partshop.security;

import by.radzivon.partshop.controller.ResourceNotFound;
import by.radzivon.partshop.entity.User;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));

        return UserPrinciple.build(user);
    }

    public User getFirstNameAndLastNameUserById(Long id) throws ResourceNotFoundException {
        User userTemp = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User don't exist with " + id));
        return User.builder()
                .name(userTemp.getName())
                .build();

    }
}