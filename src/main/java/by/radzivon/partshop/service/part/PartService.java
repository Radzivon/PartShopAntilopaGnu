package by.radzivon.partshop.service.part;

import by.radzivon.partshop.entity.Part;
import by.radzivon.partshop.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PartService {
    Part getById(Long id) throws ResourceNotFoundException;

    void save(Part part);

    List<Part> getAll();

    void deletePart(Part part);

    void editPart(Part part);
}
