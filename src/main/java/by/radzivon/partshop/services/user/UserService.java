package by.radzivon.partshop.services.user;

import by.radzivon.partshop.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id);
    Optional<User> getUserByLogin(String login) ;
    void saveUser(User user);
    List<User> findAll();
    void deleteUserByLogin(String login);
}
