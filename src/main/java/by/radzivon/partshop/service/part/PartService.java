package by.radzivon.partshop.service.part;

import by.radzivon.partshop.entity.Part;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PartService {
    Part getById(Long id) throws ResourceNotFoundException;

    void save(Part part);

    Page<Part> getAll(Pageable pageable);

    void deletePart(Part part);

    void editPart(Part part);
}
