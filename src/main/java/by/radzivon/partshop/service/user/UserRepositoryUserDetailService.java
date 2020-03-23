package by.radzivon.partshop.service.user;

import by.radzivon.partshop.entity.User;
import by.radzivon.partshop.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userDetailsService")
@Slf4j
public class UserRepositoryUserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserRepositoryUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user != null){
            return user;
        }
        log.error("User '" + username + "' not found");
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }
}
