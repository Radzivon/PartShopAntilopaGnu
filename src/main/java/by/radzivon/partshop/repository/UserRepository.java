package by.radzivon.partshop.repository;

import by.radzivon.partshop.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllBy();
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    User save(User user);
    void delete(User user);

}
