package by.radzivon.partshop.service.photo;

import by.radzivon.partshop.entity.Photo;
import by.radzivon.partshop.exception.ResourceNotFoundException;

import java.util.List;

public interface PhotoService {
    Photo getById(Long id) throws ResourceNotFoundException;
    void save(Photo photo);
    void update(Photo photo);
    List<Photo> getAll();
    void delete(Photo photo);
}
