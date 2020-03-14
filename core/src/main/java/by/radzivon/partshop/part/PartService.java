package by.radzivon.partshop.part;

import java.util.List;
import java.util.Optional;

public interface PartService {
    Optional<Part> findById(Long id);
    Optional<Part> findByName(String name);
    void save(Part part);
    List<Part> findAll();
}
