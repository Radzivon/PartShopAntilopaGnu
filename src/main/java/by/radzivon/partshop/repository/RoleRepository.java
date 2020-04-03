package by.radzivon.partshop.repository;

import by.radzivon.partshop.entity.Role;
import by.radzivon.partshop.entity.enums.RoleName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}