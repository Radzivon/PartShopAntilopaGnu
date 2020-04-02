package by.radzivon.partshop.service.photo;

import by.radzivon.partshop.controller.ResourceNotFound;
import by.radzivon.partshop.entity.Photo;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {
    private PhotoRepository photoRepository;

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Photo getById(Long id) throws ResourceNotFoundException {
        return photoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Photo don't exist with id " + id));
    }

    @Override
    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public void update(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public List<Photo> getAll() {
        return photoRepository.findAll();
    }

    @Override
    public void delete(Photo photo) {
        photoRepository.delete(photo);
    }
}
