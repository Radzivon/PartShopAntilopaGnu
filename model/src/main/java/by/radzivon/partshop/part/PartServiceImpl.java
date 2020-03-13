package by.radzivon.partshop.part;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartServiceImpl implements PartService {

    @Override
    public Optional<Part> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Part> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public void save(Part part) {

    }

    @Override
    public List<Part> findAll() {
        return null;
    }
}
