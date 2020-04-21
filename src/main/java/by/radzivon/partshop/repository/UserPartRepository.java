package by.radzivon.partshop.repository;

import by.radzivon.partshop.entity.UserPart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPartRepository extends CrudRepository<UserPart, Long> {
    UserPart save(UserPart part);

    List<UserPart> findAll();

    Optional<UserPart> findById(Long id);

}
