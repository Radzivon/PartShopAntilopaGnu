package by.radzivon.partshop.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return Optional.empty();
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void deleteUserByLogin(String login) {

    }
}
