package by.radzivon.partshop.service.brand;

import by.radzivon.partshop.entity.Brand;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    private BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand getById(Long id) throws ResourceNotFoundException {
        return brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand isn't exist with id " + id));
    }

    @Override
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Brand brand) {
        brandRepository.delete(brand);
    }

    @Override
    public List<Brand> getAll() {
        return (List<Brand>) brandRepository.findAll();
    }

    @Override
    public void editBrand(Brand brand) {
        brandRepository.save(brand);
    }
}
