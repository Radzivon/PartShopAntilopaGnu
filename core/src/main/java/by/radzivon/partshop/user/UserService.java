package by.radzivon.partshop.user;

import by.radzivon.partshop.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id) throws UserNotFoundException;
    Optional<User> getUserByLogin(String login) throws UserNotFoundException;
    void saveUser(User user);
    List<User> findAll();
    void deleteUserByLogin(String login);
}
