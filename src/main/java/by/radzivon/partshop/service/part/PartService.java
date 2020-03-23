package by.radzivon.partshop.service.part;

import by.radzivon.partshop.entity.Part;

import java.util.List;
import java.util.Optional;

public interface PartService {
    Optional<Part> getById(Long id);
    Optional<Part> getByCategory(String category);
    void save(Part part);
    List<Part> getAll();
    void deletePart(Part part);
}
