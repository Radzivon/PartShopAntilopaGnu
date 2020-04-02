package by.radzivon.partshop.service.user;

import by.radzivon.partshop.entity.User;
import by.radzivon.partshop.exception.ResourceNotFoundException;

import java.util.List;

public interface UserService {
    User getById(Long id) throws ResourceNotFoundException;

    void save(User user);

    void deleteUser(User user);

    List<User> getAll();

    void update(User user);
}
