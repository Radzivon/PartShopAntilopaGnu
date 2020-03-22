package by.radzivon.partshop.repository;

import by.radzivon.partshop.entity.Part;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface PartRepository extends CrudRepository<Part, Long> {
    Part save(Part part);
    List<Part> findAll();
    Optional<Part> findById(Long id);
    Optional<Part> findByCategory(String category);
}
