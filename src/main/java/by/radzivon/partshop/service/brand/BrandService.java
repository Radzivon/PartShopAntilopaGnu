package by.radzivon.partshop.service.brand;

import by.radzivon.partshop.entity.Brand;
import by.radzivon.partshop.exception.ResourceNotFoundException;

import java.util.List;


public interface BrandService {
    Brand getById(Long id) throws ResourceNotFoundException;

    void save(Brand brand);

    void deleteBrand(Brand brand);

    List<Brand> getAll();

    void editBrand(Brand brand);
}
