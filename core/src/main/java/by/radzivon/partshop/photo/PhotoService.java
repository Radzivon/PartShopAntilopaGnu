package by.radzivon.partshop.photo;

import java.util.List;
import java.util.Optional;

public interface PhotoService {
    Optional<Photo> getPhotoById(Long id);
    List<Photo> getPhotosForPart(Long partId);
    void save(Photo photo);
    void savePhotos(List<Photo> photos);
    void update(Long id, String comment);
    List<Photo> findAll();
}
