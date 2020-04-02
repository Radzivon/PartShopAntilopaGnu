package by.radzivon.partshop.service.part;

import by.radzivon.partshop.entity.Part;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PartServiceImpl implements PartService {

    private PartRepository partRepository;

    @Autowired
    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public Part getById(Long id) throws ResourceNotFoundException {
        return partRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Part don't exist with id " + id));
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

    @Override
    public void editPart(Part part) {
        partRepository.save(part);
    }
}
