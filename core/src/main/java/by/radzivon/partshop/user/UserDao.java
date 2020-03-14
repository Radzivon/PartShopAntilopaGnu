package by.radzivon.partshop.user;

import java.util.List;

public interface UserDao {
    User save(User user);
    User getUserByLogin(String name);
    User getUserById(Long id);
    List<User> getAll();
    void deleteUserByLogin(String login);
    void delete(Long id);
}
