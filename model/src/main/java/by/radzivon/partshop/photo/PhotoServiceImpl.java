package by.radzivon.partshop.photo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Override
    public Optional<Photo> getPhotoById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Photo> getPhotosForPart(Long partId) {
        return null;
    }

    @Override
    public void save(Photo photo) {

    }

    @Override
    public void savePhotos(List<Photo> photos) {

    }

    @Override
    public void update(Long id, String comment) {

    }

    @Override
    public List<Photo> findAll() {
        return null;
    }
}
