package by.radzivon.partshop.service.part;

import by.radzivon.partshop.entity.Part;
import by.radzivon.partshop.repository.PartRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter
public class PartServiceImpl implements PartService {
    @Autowired
    private PartRepository partRepository;

    @Override
    public Optional<Part> getById(Long id) {
        return partRepository.findById(id);
    }

    //    @Override
//    public Optional<Part> findByBrandAndModel(String brand, String model) {
//        return partRepository.findBrandAndModel(brand, model);
//    }
    @Override
    public Optional<Part> getByCategory(String category) {
        return partRepository.findByCategory(category);
    }

    @Override
    public void save(Part part) {
        partRepository.save(part);
    }

    @Override
    public List<Part> getAll() {
        return partRepository.findAll();
    }

    @Override
    public void deletePart(Part part) {
        partRepository.delete(part);
    }
}
